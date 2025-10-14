package ejercicio3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Empresa {
    private List<Departamento> departamentos;

    // Constructor sin argumentos
    public Empresa() {}

    public Empresa(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @XmlElement(name="departamento")
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
