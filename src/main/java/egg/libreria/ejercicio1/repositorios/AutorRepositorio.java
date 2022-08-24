
package egg.libreria.ejercicio1.repositorios;

import egg.libreria.ejercicio1.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {
    
}
