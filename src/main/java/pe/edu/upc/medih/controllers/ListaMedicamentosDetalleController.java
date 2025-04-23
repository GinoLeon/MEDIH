package pe.edu.upc.medih.controllers;

import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.ListaMedicamentosDetalleDTO;
import pe.edu.upc.medih.entities.ListaMedicamentosDetalle;
import pe.edu.upc.medih.servicesinterfaces.IListaMedicamentosDetalleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ListaMedicamentosDetalle")
public class ListaMedicamentosDetalleController {
    @Autowired
    private IListaMedicamentosDetalleService lmS;

    @GetMapping
    public List<ListaMedicamentosDetalleDTO> listar() {
        return lmS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,ListaMedicamentosDetalleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ListaMedicamentosDetalleDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ListaMedicamentosDetalle a = modelMapper.map(dto, ListaMedicamentosDetalle.class);
        lmS.insert(a);
    }
    @GetMapping("/{id}")
    public ListaMedicamentosDetalleDTO listarId(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        ListaMedicamentosDetalleDTO dto = modelMapper.map(lmS.searchbyid(id),ListaMedicamentosDetalleDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody ListaMedicamentosDetalleDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ListaMedicamentosDetalle a = modelMapper.map(dto, ListaMedicamentosDetalle.class);
        lmS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        lmS.delete(id);
    }
}
