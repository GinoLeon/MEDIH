package pe.edu.upc.medih.controllers;

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
public class HistorialClinicoController {

    @Autowired
    private IHistorialClinicoService hcS;

    @GetMapping
    public List<HistorialClinicoDTO> listar() {
        return hcS.list().stream().map(hc -> {
            ModelMapper mapper = new ModelMapper();
            HistorialClinicoDTO dto = mapper.map(hc, HistorialClinicoDTO.class);
            dto.setIdUsuario(hc.getUsuario().getIdUsuario());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody HistorialClinicoDTO dto) {
        ModelMapper mapper = new ModelMapper();
        HistorialClinico historial = mapper.map(dto, HistorialClinico.class);
        historial.setUsuario(new Usuario());
        historial.getUsuario().setIdUsuario(dto.getIdUsuario());
        hcS.insert(historial);
    }

    @GetMapping("/{id}")
    public HistorialClinicoDTO obtenerPorId(@PathVariable("id") int id) {
        ModelMapper mapper = new ModelMapper();
        HistorialClinico hc = hcS.searchById(id);
        HistorialClinicoDTO dto = mapper.map(hc, HistorialClinicoDTO.class);
        dto.setIdUsuario(hc.getUsuario().getIdUsuario());
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody HistorialClinicoDTO dto) {
        ModelMapper mapper = new ModelMapper();
        HistorialClinico historial = mapper.map(dto, HistorialClinico.class);
        historial.setUsuario(new Usuario());
        historial.getUsuario().setIdUsuario(dto.getIdUsuario());
        hcS.update(historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        hcS.delete(id);
    }
}
