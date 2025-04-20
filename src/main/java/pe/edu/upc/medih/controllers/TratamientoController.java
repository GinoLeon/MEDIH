package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.TratamientoDTO;
import pe.edu.upc.medih.entities.Tratamiento;
import pe.edu.upc.medih.servicesinterfaces.ITratamientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Tratamiento")
public class TratamientoController {

    @Autowired
    private ITratamientoService tS;

    @GetMapping
    public List<TratamientoDTO> listar() {
        return tS.list().stream().map(t -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(t, TratamientoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody TratamientoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Tratamiento tratamiento = modelMapper.map(dto, Tratamiento.class);
        tS.insert(tratamiento);
    }

    @GetMapping("/{id}")
    public TratamientoDTO listarId(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tS.searchById(id), TratamientoDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody TratamientoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Tratamiento tratamiento = modelMapper.map(dto, Tratamiento.class);
        tS.update(tratamiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        tS.delete(id);
    }
}