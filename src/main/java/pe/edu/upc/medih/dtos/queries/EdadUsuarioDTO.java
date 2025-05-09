package pe.edu.upc.medih.dtos.queries;

public class EdadUsuarioDTO {
    private long id;
    private String name;
    private Double edad;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEdad() {
        return edad;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }
}
