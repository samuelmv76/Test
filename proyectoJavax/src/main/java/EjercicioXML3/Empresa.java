package EjercicioXML3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "empresa")
public class Empresa {

    private List<Departamento> departamentos;

    public Empresa() {
    }

    public Empresa(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @XmlElement(name = "departamento")
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
