package pe.edu.upc.medih.serviceimplements;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upc.medih.entities.Especialidad;
import pe.edu.upc.medih.entities.Usuario;
import pe.edu.upc.medih.entities.Usuario_Especialidad;
import pe.edu.upc.medih.repositories.IUsuario_EspecialidadRepository;
import pe.edu.upc.medih.servicesimplements.Usuario_EspecialidadImplement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Usuario_EspecialidadImplementTest {
    @Mock
    private IUsuario_EspecialidadRepository ueR;

    @InjectMocks
    private Usuario_EspecialidadImplement usuarioEspecialidadService;

    private Usuario_Especialidad usuarioMock;

    @BeforeEach
    public void setUp() {
        usuarioMock = new Usuario_Especialidad();
        usuarioMock.setIdUsuarioEspecialidad(1);

        Usuario usuario = new Usuario();
        usuario.setId(null);
        usuarioMock.setUsuario(usuario);

        Especialidad especialidad = new Especialidad();
        especialidad.setIdEspecialidad(-2);
        usuarioMock.setEspecialidad(especialidad);

        usuarioMock.setFechaDeRegistro(LocalDate.now());
    }

    @Test
    public void testInsert() {
        usuarioEspecialidadService.insert(usuarioMock);
        verify(ueR, times(1)).save(usuarioMock);
    }

    @Test
    public void testFindAll() {
        List<Usuario_Especialidad> lista = new ArrayList<>();
        lista.add(usuarioMock);
        when(ueR.findAll()).thenReturn(lista);

        List<Usuario_Especialidad> result = usuarioEspecialidadService.findAll();

        assertEquals(1, result.size());
        verify(ueR).findAll();
    }

}
