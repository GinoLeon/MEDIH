package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.Receta_MedicaDTO;
import pe.edu.upc.medih.dtos.queries.CantidadRolDTO;
import pe.edu.upc.medih.dtos.queries.DoctorRecetasDTO;
import pe.edu.upc.medih.dtos.queries.PacienteRecetasDTO;
import pe.edu.upc.medih.entities.Receta_Medica;
import pe.edu.upc.medih.servicesinterfaces.IReceta_MedicaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/RecetaMedica")
public class Receta_MedicaController {

    @Autowired
    private IReceta_MedicaService rM;

    @GetMapping
    @PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public List<Receta_MedicaDTO> listar() {
        return rM.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, Receta_MedicaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody Receta_MedicaDTO dto) {
        ModelMapper m = new ModelMapper();
        Receta_Medica receta = m.map(dto, Receta_Medica.class);
        rM.insert(receta);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public Receta_MedicaDTO buscarPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Receta_MedicaDTO dto = m.map(rM.searchById(id), Receta_MedicaDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody Receta_MedicaDTO dto) {
        ModelMapper m = new ModelMapper();
        Receta_Medica receta = m.map(dto, Receta_Medica.class);
        rM.update(receta);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        rM.delete(id);
    }


    @GetMapping("/contarPorDoctor")
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public List<DoctorRecetasDTO> contarPorDoctor() {
        List<DoctorRecetasDTO> dtolista = new ArrayList<>();
        List<String[]> fila= rM.countRecetasByDoctor();
        for (String[]columna : fila) {
            DoctorRecetasDTO dto = new DoctorRecetasDTO();
            dto.setNombreDoctor(columna[0]);
            dto.setCantiadRecetas(Integer.parseInt(columna[1]));
            dtolista.add(dto);
        }
        return dtolista;
    }


    @GetMapping("/medicamentos-recetados")
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public List<DoctorRecetasDTO> obtenerMedicamentosRecetados(@RequestParam LocalDate fecha) {
        List<DoctorRecetasDTO> dtolista = new ArrayList<>();
        List<String[]> fila= rM.obtenerMedicamentosRecetados(fecha);
        for (String[]columna : fila) {
            DoctorRecetasDTO dto = new DoctorRecetasDTO();
            dto.setNombreDoctor(columna[0]);
            dto.setCantiadRecetas(Integer.parseInt(columna[1]));
            dtolista.add(dto);
        }
        return dtolista;
    }


    @GetMapping("/recetas-por-paciente")
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public List<PacienteRecetasDTO> obtenerRecetasPorPaciente() {
        List<PacienteRecetasDTO> dtolista = new ArrayList<>();
        List<String[]> fila= rM.obtenerRecetasPorPaciente();
        for (String[]columna : fila) {
            PacienteRecetasDTO dto = new PacienteRecetasDTO();
            dto.setNombre_usuario(columna[0]);
            dto.setTotalRecetas(Integer.parseInt(columna[1]));
            dtolista.add(dto);
        }
        return dtolista;
    }
}
