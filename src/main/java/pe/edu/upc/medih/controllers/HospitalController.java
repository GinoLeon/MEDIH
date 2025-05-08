package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.HospitalDTO;
import pe.edu.upc.medih.dtos.RolDTO;
import pe.edu.upc.medih.dtos.queries.DistanciaHospitalDTO;
import pe.edu.upc.medih.dtos.queries.ResumenDetalleHistorialClinicoDTO;
import pe.edu.upc.medih.entities.Hospital;
import pe.edu.upc.medih.entities.Rol;
import pe.edu.upc.medih.servicesinterfaces.IHospitalService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Hospital")
public class HospitalController {
    @Autowired
    private IHospitalService hS;

    @GetMapping
    public List<HospitalDTO> listar() {
        return hS.list().stream().map(h -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(h, HospitalDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody HospitalDTO dto) {
        ModelMapper m = new ModelMapper();
        Hospital h = m.map(dto, Hospital.class);
        hS.insert(h);
    }

    @GetMapping("/{id}")
    public HospitalDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        HospitalDTO dto = m.map(hS.searchById(id), HospitalDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody HospitalDTO dto) {
        ModelMapper m = new ModelMapper();
        Hospital a = m.map(dto, Hospital.class);
        hS.update(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        hS.delete(id);
    }

    @GetMapping("/distancia")
    public List<DistanciaHospitalDTO> ResumenHistorialClinico(@RequestParam double latitud, @RequestParam double longitud) {
        List<DistanciaHospitalDTO> dtoLista=new ArrayList<>();
        List<String[]> fila=hS.getDistanciaKm(latitud, longitud);
        for(String[]columna:fila){
            DistanciaHospitalDTO dto=new DistanciaHospitalDTO();
            dto.setNombreHospital(columna[0]);
            dto.setDistancia_km(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
