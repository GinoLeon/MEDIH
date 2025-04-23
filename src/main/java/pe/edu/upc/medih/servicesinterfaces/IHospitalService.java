package pe.edu.upc.medih.servicesinterfaces;

import pe.edu.upc.medih.entities.Hospital;

import java.util.List;

public interface IHospitalService {
    public void  insert(Hospital hospital);
    public List<Hospital> list();
    public Hospital searchById(int id);
    public void  delete(int id);
    public void update(Hospital hospital);
}
