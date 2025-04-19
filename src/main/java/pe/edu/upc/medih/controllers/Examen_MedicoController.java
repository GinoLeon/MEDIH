package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.Examen_MedicoDTO;
import pe.edu.upc.medih.dtos.RolDTO;
import pe.edu.upc.medih.entities.Examen_Medico;
import pe.edu.upc.medih.entities.Rol;
import pe.edu.upc.medih.servicesinterfaces.IExamen_MedicoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ExamenMedico")
public class Examen_MedicoController {
    @Autowired
    private IExamen_MedicoService eS;

    @GetMapping
    public List<Examen_MedicoDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, Examen_MedicoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody Examen_MedicoDTO dto) {
        ModelMapper m = new ModelMapper();
        Examen_Medico a = m.map(dto, Examen_Medico.class);
        eS.insert(a);
    }

    @GetMapping("/{id}")
    public Examen_MedicoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Examen_MedicoDTO dto = m.map(eS.searchbyId(id), Examen_MedicoDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody Examen_MedicoDTO dto) {
        ModelMapper m = new ModelMapper();
        Examen_Medico a = m.map(dto, Examen_Medico.class);
        eS.update(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        eS.delete(id);
    }

}
