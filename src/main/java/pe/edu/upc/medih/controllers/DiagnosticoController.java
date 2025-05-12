package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.DetallesHistorialClinicoDTO;
import pe.edu.upc.medih.dtos.DiagnosticoDTO;
import pe.edu.upc.medih.dtos.queries.DistanciaHospitalDTO;
import pe.edu.upc.medih.entities.DetallesHistorialClinico;
import pe.edu.upc.medih.entities.Diagnostico;
import pe.edu.upc.medih.servicesinterfaces.IDiagnosticoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private IDiagnosticoService diagnosticoService;

    @GetMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public List<DiagnosticoDTO> listar() {
        return diagnosticoService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, DiagnosticoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody DiagnosticoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diagnostico a = m.map(dto, Diagnostico.class);
        diagnosticoService.insert(a);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public DiagnosticoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(diagnosticoService.findById(id), DiagnosticoDTO.class);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody DiagnosticoDTO dto) {
        ModelMapper m = new ModelMapper();
        Diagnostico a = m.map(dto, Diagnostico.class);
        diagnosticoService.update(a);
    }

    @GetMapping("/descripcion/{descripcion}")
    @PreAuthorize("hasAuthority('PACIENTE') or hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public ResponseEntity<List<DiagnosticoDTO>> findByDescripcion(@PathVariable("descripcion") String descripcion) {
        List<DiagnosticoDTO> diagnosticos = diagnosticoService.findByDescripcionContaining(descripcion).stream().map(d -> {
            DiagnosticoDTO dto = new DiagnosticoDTO();
            dto.setIdDiagnostico(d.getIdDiagnostico());
            dto.setDescripcion(d.getDescripcion());
            dto.setUsuarioId(d.getUsuario().getId());
            dto.setFecha(d.getFecha());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(diagnosticos);
    }

    @GetMapping("/recientes")
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public List<DiagnosticoDTO> findRecentDiagnosticos(@RequestParam LocalDate fecha) {
        List<DiagnosticoDTO> dtoLista=new ArrayList<>();
        List<String[]> fila=diagnosticoService.findRecentDiagnosticos(fecha);
        for(String[]columna:fila){
            DiagnosticoDTO dto=new DiagnosticoDTO();
            if (columna[0] != null && !columna[0].isEmpty()) {
                dto.setIdDiagnostico(Integer.parseInt(columna[0]));
            } else {
                dto.setIdDiagnostico(0);
            }
            if (columna[1] != null && !columna[1].isEmpty()) {
                dto.setIdDiagnosticoComparado(Integer.parseInt(columna[1]));
            } else {
                dto.setIdDiagnosticoComparado(null);
            }
            dto.setFecha(LocalDate.parse(columna[2]));
            dto.setUsuarioId(Long.parseLong(columna[3]));
            dto.setDescripcion(columna[4]);
            dto.setEstado(columna[5]);

            dtoLista.add(dto);
        }
        return dtoLista;
    }

}