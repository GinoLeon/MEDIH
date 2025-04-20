package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Chat;
import pe.edu.upc.medih.repositories.IChatRepository;
import pe.edu.upc.medih.servicesinterfaces.IChatService;

import java.util.List;
@Service
public class ChatImplement implements IChatService {
    @Autowired
    private IChatRepository cR;
    @Override
    public List<Chat> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Chat chat) {
        cR.save(chat);
    }

    @Override
    public Chat searchbyId(int id) {
        return cR.findById(id).orElse(new Chat());
    }

    @Override
    public void update(Chat a) {
        cR.save(a);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }
}
