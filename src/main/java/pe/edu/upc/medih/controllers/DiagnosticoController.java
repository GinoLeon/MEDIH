package pe.edu.upc.medih.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.DiagnosticoDTO;
import pe.edu.upc.medih.entities.Diagnostico;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.servicesinterfaces.IDiagnosticoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private IDiagnosticoService diagnosticoService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setDescripcion(diagnosticoDTO.getDescripcion());
        diagnostico.setUsuario(new Usuario(diagnosticoDTO.getUsuarioId()));
        diagnosticoService.insert(diagnostico);
        return ResponseEntity.ok("Diagnóstico registrado correctamente.");
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticoDTO>> list() {
        List<DiagnosticoDTO> diagnosticos = diagnosticoService.list().stream().map(d -> {
            DiagnosticoDTO dto = new DiagnosticoDTO();
            dto.setId(d.getId());
            dto.setDescripcion(d.getDescripcion());
            dto.setUsuarioId(d.getUsuario().getId());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(diagnosticos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        diagnosticoService.delete(id);
        return ResponseEntity.ok("Diagnóstico eliminado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticoDTO> findById(@PathVariable("id") int id) {
        Diagnostico diagnostico = diagnosticoService.findById(id);
        if (diagnostico == null) {
            return ResponseEntity.notFound().build();
        }
        DiagnosticoDTO dto = new DiagnosticoDTO();
        dto.setId(diagnostico.getId());
        dto.setDescripcion(diagnostico.getDescripcion());
        dto.setUsuarioId(diagnostico.getUsuario().getId());
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(diagnosticoDTO.getId());
        diagnostico.setDescripcion(diagnosticoDTO.getDescripcion());
        diagnostico.setUsuario(new Usuario(diagnosticoDTO.getUsuarioId()));
        diagnosticoService.update(diagnostico);
        return ResponseEntity.ok("Diagnóstico actualizado correctamente.");
    }

    @DeleteMapping("/estado/{estado}")
    public ResponseEntity<String> deleteByEstado(@PathVariable("estado") String estado) {
        diagnosticoService.deleteByEstado(estado);
        return ResponseEntity.ok("Diagnósticos con estado '" + estado + "' eliminados correctamente.");
    }
}