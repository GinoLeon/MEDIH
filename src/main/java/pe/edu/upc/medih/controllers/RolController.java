package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.RolDTO;
import pe.edu.upc.medih.entities.Rol;
import pe.edu.upc.medih.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/Rol")
public class RolController {
    @Autowired
    private IRolService rS;


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RolDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")

    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol a = m.map(dto, Rol.class);
        rS.insert(a);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public RolDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rS.searchbyId(id), RolDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")

    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol a = m.map(dto, Rol.class);
        rS.update(a);
    }

    @DeleteMapping("/idrol")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@RequestParam Long id) {
        boolean deleted = rS.deleteRolById(id);
        if (deleted) {
            return ResponseEntity.ok("Rol eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el rol con ID: " + id);
        }
    }
}
