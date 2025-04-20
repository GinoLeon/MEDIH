package pe.edu.upc.medih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.medih.entities.Chat;

public interface IChatRepository extends JpaRepository<Chat, Integer> {
}
