package pe.edu.upc.medih.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.HistorialClinicoDTO;
import pe.edu.upc.medih.entities.HistorialClinico;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.servicesinterfaces.IHistorialClinicoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historial")
@Slf4j
public class HistorialClinicoController {

    @Autowired
    private IHistorialClinicoService hcS;

    @GetMapping
    public List<HistorialClinicoDTO> listar() {
        log.info("Listado de todo el historial médico registradas");
        return hcS.list().stream().map(hc -> {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(hc, HistorialClinicoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody HistorialClinicoDTO dto) {
        ModelMapper mapper = new ModelMapper();
        HistorialClinico historial = mapper.map(dto, HistorialClinico.class);
        hcS.insert(historial);
    }

    @GetMapping("/{id}")
    public HistorialClinicoDTO obtenerPorId(@PathVariable("id") int id) {
        ModelMapper mapper = new ModelMapper();
        HistorialClinicoDTO dto = mapper.map(hcS.searchById(id), HistorialClinicoDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody HistorialClinicoDTO dto) {
        ModelMapper mapper = new ModelMapper();
        HistorialClinico historial = mapper.map(dto, HistorialClinico.class);
        hcS.update(historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        hcS.delete(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<HistorialClinicoDTO> listarPorUsuario(@PathVariable("idUsuario") int idUsuario) {
        log.info("Listado de historiales clínicos del usuario con ID: {}", idUsuario);
        return hcS.listByUsuarioId(idUsuario).stream().map(hc -> {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(hc, HistorialClinicoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping
    public void eliminarPorPaciente(@PathVariable("idPaciente") Long idPaciente) {
        hcS.eliminarPorPaciente(idPaciente);
    }
}
