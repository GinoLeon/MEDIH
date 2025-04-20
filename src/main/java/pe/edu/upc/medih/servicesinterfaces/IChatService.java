package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Chat;

import java.util.List;

public interface IChatService {
    public List<Chat> list();
    public void insert(Chat chat);

    public Chat searchbyId(int id);
    public void update(Chat a);

    public void delete(int id);
}
