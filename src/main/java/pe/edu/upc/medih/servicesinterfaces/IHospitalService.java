package pe.edu.upc.medih.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.medih.entities.Hospital;

import java.util.List;

public interface IHospitalService {
    public void  insert(Hospital hospital);
    public List<Hospital> list();
    public Hospital searchById(int id);
    public void  delete(int id);
    public void update(Hospital hospital);
    public List<String[]> getDistanciaKm(double latitud,double longitud);

}
