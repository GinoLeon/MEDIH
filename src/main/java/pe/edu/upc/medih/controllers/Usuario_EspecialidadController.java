package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.Usuario_EspecialidadDTO;
import pe.edu.upc.medih.entities.Usuario_Especialidad;
import pe.edu.upc.medih.servicesinterfaces.IUsuario_EspecialidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/UsuarioEspecialidad")
public class Usuario_EspecialidadController {
    @Autowired
    private IUsuario_EspecialidadService ueS;

    @GetMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public List<Usuario_EspecialidadDTO> listar() {
        return ueS.findAll().stream().map(u -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(u, Usuario_EspecialidadDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public void insertar(@RequestBody Usuario_EspecialidadDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario_Especialidad u = modelMapper.map(dto, Usuario_Especialidad.class);
        ueS.insert(u);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public Usuario_EspecialidadDTO listarPorId(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ueS.searchbyId(id), Usuario_EspecialidadDTO.class);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('DOCTOR')or hasAuthority('ADMIN')")
    public void modificar(@RequestBody Usuario_EspecialidadDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario_Especialidad u = modelMapper.map(dto, Usuario_Especialidad.class);
        ueS.update(u);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") int id) {
        ueS.delete(id);
    }
}
