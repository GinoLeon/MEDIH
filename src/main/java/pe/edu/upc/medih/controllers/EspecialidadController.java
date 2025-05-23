package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.EspecialidadDTO;
import pe.edu.upc.medih.dtos.RolDTO;
import pe.edu.upc.medih.dtos.queries.CantidadDoctorEspecialidadDTO;
import pe.edu.upc.medih.dtos.queries.CantidadRolDTO;
import pe.edu.upc.medih.entities.Especialidad;
import pe.edu.upc.medih.entities.Rol;
import pe.edu.upc.medih.servicesinterfaces.IEspecialidadService;
import pe.edu.upc.medih.servicesinterfaces.IRolService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Especialidad")
public class EspecialidadController {
    @Autowired
    private IEspecialidadService eS;

    @GetMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")

    public List<EspecialidadDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, EspecialidadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody EspecialidadDTO dto) {
        ModelMapper m = new ModelMapper();
        Especialidad a = m.map(dto, Especialidad.class);
        eS.insert(a);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public EspecialidadDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        EspecialidadDTO dto = m.map(eS.searchbyId(id), EspecialidadDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody EspecialidadDTO dto) {
        ModelMapper m = new ModelMapper();
        Especialidad a = m.map(dto, Especialidad.class);
        eS.update(a);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }

    @GetMapping("/Cantidad")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CantidadDoctorEspecialidadDTO>CantidadDoctorEspecialidad() {
        List<CantidadDoctorEspecialidadDTO> dtolista = new ArrayList<>();
        List<String[]> fila=eS.CantidadDoctoresEspecialidad();
        for(String[]columna:fila){
            CantidadDoctorEspecialidadDTO dto=new CantidadDoctorEspecialidadDTO();
            dto.setNombreEspecialidad(columna[0]);
            dto.setCantidadDoctor(Integer.parseInt(columna[1]));
            dtolista.add(dto);
        }
        return dtolista;
    }
}

