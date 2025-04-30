package pe.edu.upc.medih.dtos.queries;

public class CantidadDoctorEspecialidadDTO {
    private String nombreEspecialidad;
    private int CantidadDoctor;

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public int getCantidadDoctor() {
        return CantidadDoctor;
    }

    public void setCantidadDoctor(int cantidadDoctor) {
        CantidadDoctor = cantidadDoctor;
    }
}
