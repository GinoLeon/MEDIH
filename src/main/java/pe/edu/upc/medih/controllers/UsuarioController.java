package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.UsuarioDTO;
import pe.edu.upc.medih.dtos.queries.CantidadRolDTO;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario a = m.map(dto, Usuario.class);
        uS.insert(a);
    }

    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.searchbyId(id), UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario a = m.map(dto, Usuario.class);
        uS.update(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }

    @GetMapping("/Cantidad")
    public List<CantidadRolDTO> listarRol() {
        List<CantidadRolDTO> dtolista = new ArrayList<>();
        List<String[]> fila= uS.ListarCantidadRoles();
        for (String[]columna : fila) {
            CantidadRolDTO dto = new CantidadRolDTO();
            dto.setNameRol(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            dtolista.add(dto);
        }
        return dtolista;
    }

    // Calcular Edad
    @GetMapping("/CalcularEdad/{id}")
    public int calcularEdad(@PathVariable("id") long id) {
        return uS.calcularEdad(id);
    }
}
