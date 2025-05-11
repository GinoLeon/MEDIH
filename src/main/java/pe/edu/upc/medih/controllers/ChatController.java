package pe.edu.upc.medih.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medih.dtos.ChatDTO;
import pe.edu.upc.medih.entities.Chat;
import pe.edu.upc.medih.servicesinterfaces.IChatService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Chat")
public class ChatController {
    @Autowired
    private IChatService cS;

    @GetMapping
    public List<ChatDTO> listar() {
        return cS.list().stream().map(x->{
            ModelMapper a =new ModelMapper();
            return a.map(x,ChatDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ChatDTO dto) {
        ModelMapper a =new ModelMapper();
        Chat m = a.map(dto,Chat.class);
        cS.insert(m);
    }

    @GetMapping("/{id}")
    public ChatDTO listarID(@PathVariable("id") int id) {
        ModelMapper a =new ModelMapper();
        ChatDTO dto = a.map(cS.searchbyId(id),ChatDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody ChatDTO dto) {
        ModelMapper a =new ModelMapper();
        Chat m = a.map(dto,Chat.class);
        cS.update(m);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }

}
