package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.UsuarioDTO;
import pe.edu.upc.medih.dtos.UsuarioListDTO;
import pe.edu.upc.medih.dtos.queries.CantidadRolDTO;
import pe.edu.upc.medih.dtos.queries.EdadUsuarioDTO;
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
    public List<UsuarioListDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioListDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario a = m.map(dto, Usuario.class);
        uS.insert(a);
    }

    @GetMapping("/{id}")
    public UsuarioListDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        UsuarioListDTO dto = m.map(uS.searchbyId(id), UsuarioListDTO.class);
        return dto;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioActualizado = uS.update(id, usuarioDTO);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
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
    @GetMapping("/CalcularEdad")
    public List<EdadUsuarioDTO> calcularEdad(@RequestParam Long idUsuario) {
        List<EdadUsuarioDTO> dtolista = new ArrayList<>();
        List<String[]> fila= uS.calcularEdad(idUsuario);
        for (String[]columna : fila) {
            EdadUsuarioDTO dto = new EdadUsuarioDTO();
            dto.setId(Long.parseLong(columna[0]));
            dto.setName(columna[1]);
            dto.setEdad(Double.parseDouble(columna[2]));
            dtolista.add(dto);
        }
        return dtolista;
    }
}
