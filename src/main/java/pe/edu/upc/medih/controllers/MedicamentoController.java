package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.MedicamentoDTO;
import pe.edu.upc.medih.entities.Medicamento;
import pe.edu.upc.medih.servicesinterfaces.IMedicamentoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Medicamento")
public class MedicamentoController {
    @Autowired
    private IMedicamentoService mS;

    @GetMapping
    public List<Medicamento> listar() {
        return mS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,Medicamento.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody MedicamentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Medicamento a = m.map(dto, Medicamento.class);
        mS.insert(a);
    }
    @GetMapping("/{id}")
    public MedicamentoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MedicamentoDTO dto = m.map(mS.searchbyid(id), MedicamentoDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody MedicamentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Medicamento a = m.map(dto, Medicamento.class);
        mS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        mS.delete(id);
    }

}
