package pe.edu.upc.medih.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medih.entities.HistorialClinico;
import pe.edu.upc.medih.entities.Hospital;
import pe.edu.upc.medih.repositories.IHospitalRepository;
import pe.edu.upc.medih.servicesinterfaces.IHospitalService;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalImplement implements IHospitalService {

    @Autowired
    private IHospitalRepository hR;

    @Override
    public void insert(Hospital hospital) {
        hR.save(hospital);
    }

    @Override
    public List<Hospital> list() {
        return hR.findAll();
    }

    @Override
    public Hospital searchById(int id) {
        return hR.findById(id).orElse(new Hospital());

    }

    @Override
    public void delete(int id) {
        hR.deleteById(id);
    }

    @Override
    public void update(Hospital hospital) {
        hR.save(hospital);
    }

    @Override
    public List<String[]> getDistanciaKm(double latitud, double longitud) {
        return hR.getDistanciaKm(latitud, longitud);
    }
}
