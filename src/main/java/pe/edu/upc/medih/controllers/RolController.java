package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<RolDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol a = m.map(dto, Rol.class);
        rS.insert(a);
    }

    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rS.searchbyId(id), RolDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol a = m.map(dto, Rol.class);
        rS.update(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rS.deleteRolById(id);
    }
}
