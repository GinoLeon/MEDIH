package pe.edu.upc.medih.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.medih.entities.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM roles WHERE id_rol = :id", nativeQuery = true)
    public int deleteRolById(@Param("id") Long id);
}
