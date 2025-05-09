package pe.edu.upc.medih.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/descripcion/{descripcion}")
    public ResponseEntity<List<DiagnosticoDTO>> findByDescripcion(@PathVariable("descripcion") String descripcion) {
        List<DiagnosticoDTO> diagnosticos = diagnosticoService.findByDescripcionContaining(descripcion).stream().map(d -> {
            DiagnosticoDTO dto = new DiagnosticoDTO();
            dto.setId(d.getIdDiagnostico());
            dto.setDescripcion(d.getDescripcion());
            dto.setUsuarioId(d.getUsuario().getId());
            dto.setFecha(d.getFecha());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(diagnosticos);
    }

    @GetMapping("/recientes/{fecha}")
    public ResponseEntity<List<DiagnosticoDTO>> findRecentDiagnosticos(@PathVariable("fecha") String fecha) {
        List<DiagnosticoDTO> diagnosticos = diagnosticoService.findRecentDiagnosticos(fecha).stream().map(d -> {
            DiagnosticoDTO dto = new DiagnosticoDTO();
            dto.setId(d.getIdDiagnostico());
            dto.setDescripcion(d.getDescripcion());
            dto.setUsuarioId(d.getUsuario().getId());
            dto.setFecha(d.getFecha());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(diagnosticos);
    }

    @DeleteMapping("/estado/{estado}")
    public ResponseEntity<String> deleteByEstado(@PathVariable("estado") String estado) {
        diagnosticoService.deleteByEstado(estado);
        return ResponseEntity.ok("Diagnósticos con estado '" + estado + "' eliminados correctamente.");
    }
}