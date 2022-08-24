
package egg.libreria.ejercicio1.repositorios;

import egg.libreria.ejercicio1.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String>{
//    @Query("SELECT c FROM Libro c WHERE c.ejemplares.id = :id")
//    public List<Libro>buscarPorEjemplares(@Param("id")String id);
//    
//    @Query("SELECT c FROM Libro c WHERE c.ejemplaresPrestados.id = :id")
//    public List<Libro>buscarPorEjemplaresPrestados(@Param("id")String id);
//    
//    @Query("SELECT c FROM Libro c WHERE c.ejemplaresRestantes.id = :id")
//    public List<Libro>buscarPorEjemplaresRestantes(@Param("id")String id);
}
