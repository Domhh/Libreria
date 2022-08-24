
package egg.libreria.ejercicio1.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String nombreEditorial;
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(String id, String nombreEditorial, Boolean alta) {
        this.id = id;
        this.nombreEditorial = nombreEditorial;
        this.alta = alta;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombreEditorial() {
        return nombreEditorial;
    }

    /**
     * @param nombreEditorial the nombre to set
     */
    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    /**
     * @return the alta
     */
    public Boolean getAlta() {
        return alta;
    }

    /**
     * @param alta the alta to set
     */
    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombreEditorial=" + nombreEditorial + ", alta=" + alta + '}';
    }

    
}
