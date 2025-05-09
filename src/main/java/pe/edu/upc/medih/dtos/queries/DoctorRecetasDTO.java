package pe.edu.upc.medih.dtos.queries;

public class DoctorRecetasDTO {
    private String name;
    private int doctorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }
}
