package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.DetallesHistorialClinicoDTO;
import pe.edu.upc.medih.dtos.queries.ResumenDetalleHistorialClinicoDTO;
import pe.edu.upc.medih.entities.DetallesHistorialClinico;
import pe.edu.upc.medih.servicesinterfaces.IDetallesHistorialClinicoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DetallesHistorialClinico")
public class DetallesHistorialClinicoController {
    @Autowired
    private IDetallesHistorialClinicoService dS;

    @GetMapping
    public List<DetallesHistorialClinicoDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, DetallesHistorialClinicoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DetallesHistorialClinicoDTO dto) {
        ModelMapper m = new ModelMapper();
        DetallesHistorialClinico detalles = m.map(dto, DetallesHistorialClinico.class);
        dS.insert(detalles);
    }

    @GetMapping("/{id}")
    public DetallesHistorialClinicoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(dS.searchById(id), DetallesHistorialClinicoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody DetallesHistorialClinicoDTO dto) {
        ModelMapper m = new ModelMapper();
        DetallesHistorialClinico detalles = m.map(dto, DetallesHistorialClinico.class);
        dS.update(detalles);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        dS.delete(id);
    }

    @GetMapping("/resumen")
    public List<ResumenDetalleHistorialClinicoDTO> ResumenHistorialClinico(@RequestParam long id) {
        List<ResumenDetalleHistorialClinicoDTO> dtoLista=new ArrayList<>();
        List<String[]> fila=dS.HistorialClinicoPorUsuario(id);
        for(String[]columna:fila){
            ResumenDetalleHistorialClinicoDTO dto=new ResumenDetalleHistorialClinicoDTO();
            dto.setIdDetalleHistorial(Integer.parseInt(columna[0]));
            dto.setFechaRegistro(columna[1]);
            dto.setNombreUsuario(columna[2]);
            dto.setTipoTratamiento(columna[3]);
            dto.setFechaInicio(columna[4]);
            dto.setFechaFin(columna[5]);
            dto.setTipoExamen(columna[6]);
            dto.setResultadoExamen(columna[7]);
            dto.setFechaExamen(columna[8]);
            dto.setNombreMedicamento(columna[9]);
            dto.setDescripcionMedicamento(columna[10]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}