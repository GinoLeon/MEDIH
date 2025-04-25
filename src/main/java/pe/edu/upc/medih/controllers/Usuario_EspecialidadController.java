package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Usuario_Especialidad> listar() {
        return ueS.findAll().stream().map(u -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(u, Usuario_Especialidad.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody Usuario_EspecialidadDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario_Especialidad u = modelMapper.map(dto, Usuario_Especialidad.class);
        ueS.insert(u);
    }
    @GetMapping("/{id}")
    public Usuario_EspecialidadDTO listarPorId(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(ueS.searchbyId(id), Usuario_EspecialidadDTO.class);
    }
    @PutMapping
    public void modificar(@RequestBody Usuario_EspecialidadDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario_Especialidad u = modelMapper.map(dto, Usuario_Especialidad.class);
        ueS.update(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        ueS.delete(id);
    }
}
