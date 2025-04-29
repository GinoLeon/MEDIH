package pe.edu.upc.medih.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.DiagnosticoDTO;
import pe.edu.upc.medih.entities.Diagnostico;
import pe.edu.upc.medih.servicesinterfaces.IDiagnosticoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private IDiagnosticoService diagnosticoService;

    @PostMapping
    public void insert(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setDescripcion(diagnosticoDTO.getDescripcion());
        diagnosticoService.insert(diagnostico);
    }

    @GetMapping
    public List<DiagnosticoDTO> list() {
        return diagnosticoService.list().stream().map(d -> {
            DiagnosticoDTO dto = new DiagnosticoDTO();
            dto.setId(d.getId());
            dto.setDescripcion(d.getDescripcion());
            return dto;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        diagnosticoService.delete(id);
    }

    @GetMapping("/{id}")
    public DiagnosticoDTO findById(@PathVariable("id") int id) {
        Diagnostico diagnostico = diagnosticoService.findById(id);
        DiagnosticoDTO dto = new DiagnosticoDTO();
        dto.setId(diagnostico.getId());
        dto.setDescripcion(diagnostico.getDescripcion());
        return dto;
    }

    @PutMapping
    public void update(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(diagnosticoDTO.getId());
        diagnostico.setDescripcion(diagnosticoDTO.getDescripcion());
        diagnosticoService.update(diagnostico);
    }
}
