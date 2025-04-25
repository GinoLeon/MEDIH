package pe.edu.upc.medih.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.Usuario_Especialidad;
import pe.edu.upc.medih.repositories.IUsuario_EspecialidadRepository;
import pe.edu.upc.medih.servicesinterfaces.IUsuario_EspecialidadService;

import java.util.List;

@Service
public class Usuario_EspecialidadImplement implements IUsuario_EspecialidadService {
    @Autowired
    public IUsuario_EspecialidadRepository ueR;

    @Override
    public List<Usuario_Especialidad> findAll() {
        return ueR.findAll();
    }

    @Override
    public void insert(Usuario_Especialidad usuario_especialidad) {
        ueR.save(usuario_especialidad);
    }

    @Override
    public Usuario_Especialidad searchbyId(int id) {
        return ueR.findById(id).orElse(new Usuario_Especialidad());
    }

    @Override
    public void delete(int id) {
        ueR.deleteById(id);
    }

    @Override
    public void update(Usuario_Especialidad usuario_especialidad) {
        ueR.save(usuario_especialidad);
    }
}
