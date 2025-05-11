package pe.edu.upc.medih.controllers;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.Cita_MedicaDTO;
import pe.edu.upc.medih.entities.Cita_Medica;
import pe.edu.upc.medih.servicesinterfaces.ICita_MedicaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cita_Medica")
@Slf4j
public class Cita_MedicaController {

    @Autowired
    private ICita_MedicaService cS;

    @GetMapping
    public List<Cita_MedicaDTO> listar() {
        log.info("Listado de todas las citas médicas registradas");
        return cS.list().stream().map(cita -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(cita, Cita_MedicaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody Cita_MedicaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cita_Medica citaMedica = modelMapper.map(dto, Cita_Medica.class);
        cS.insert(citaMedica);
    }

    @GetMapping("/{id}")
    public Cita_MedicaDTO listarID(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Cita_MedicaDTO dto = modelMapper.map(cS.searchById(id), Cita_MedicaDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody Cita_MedicaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cita_Medica citaMedica = modelMapper.map(dto, Cita_Medica.class);
        cS.update(citaMedica);
    }

    @GetMapping("/buscarPorEstado/{estado}")
    public List<Cita_MedicaDTO> buscarPorEstado(@PathVariable("estado") String estado) {
        return cS.findByEstado(estado).stream().map(cita -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(cita, Cita_MedicaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }
}