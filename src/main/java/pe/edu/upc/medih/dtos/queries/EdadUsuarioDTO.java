package pe.edu.upc.medih.dtos.queries;

public class EdadUsuarioDTO {
    private Long id;
    private String name;
    private Double edad;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
