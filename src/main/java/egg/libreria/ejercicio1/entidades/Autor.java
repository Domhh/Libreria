
package egg.libreria.ejercicio1.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Autor {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String nombreAutor;
    private Boolean alta;

    public Autor() {
    }

    public Autor(String id, String nombreAutor, Boolean alta) {
        this.id = id;
        this.nombreAutor = nombreAutor;
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
    public String getNombreAutor() {
        return nombreAutor;
    }

    /**
     * @param nombreAutor the nombreAutor to set
     */
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
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
        return "Autor{" + "id=" + getId() + ", nombreAutor=" + nombreAutor + ", alta=" + getAlta() + '}';
    }  
        
}
