package ejercicio6.dto;

import java.io.Serializable;

public class CitasDTO  implements Serializable {

    private String nombrePaciente;

    private Integer id;
    private String fecha;

    private String medico;

    public CitasDTO(String nombrePaciente, Integer id, String fecha, String medico) {
        this.nombrePaciente = nombrePaciente;
        this.id = id;
        this.fecha = fecha;
        this.medico = medico;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "CitasDTO{" +
                "nombrePaciente='" + nombrePaciente + '\'' +
                ", id=" + id +
                ", fecha='" + fecha + '\'' +
                ", medico='" + medico + '\'' +
                '}';
    }
}
