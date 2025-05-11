package pe.edu.upc.medih.dtos;


import java.time.LocalDate;

public class ChatDTO {
    private int chatId;
    private String mensaje;
    private LocalDate fechaEnvio;
    private String tipoMensaje;
    private Long  PacienteID;
    private Long DoctorID;
    private boolean leido;

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public Long getPacienteID() {
        return PacienteID;
    }

    public void setPacienteID(Long pacienteID) {
        PacienteID = pacienteID;
    }

    public Long getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(Long doctorID) {
        DoctorID = doctorID;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
