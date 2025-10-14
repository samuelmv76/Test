package EjercicioXML3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empleado")
public class Empleado {

    private String nombre;
    private int id;
    private String puesto;
    private double salario;

    public Empleado() {
    }

    public Empleado(String nombre, int id, String puesto, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.puesto = puesto;
        this.salario = salario;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @XmlElement
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
