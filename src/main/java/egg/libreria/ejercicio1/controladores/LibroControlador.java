
package egg.libreria.ejercicio1.controladores;

import egg.libreria.ejercicio1.entidades.Autor;
import egg.libreria.ejercicio1.entidades.Editorial;
//import egg.libreria.ejercicio1.entidades.Libro;
import egg.libreria.ejercicio1.errores.ErrorServicio;
import egg.libreria.ejercicio1.servicios.LibroServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libreria/libros")
public class LibroControlador {
    
    @Autowired
    private LibroServicioImpl libroServicioImpl;
    
    @PostMapping("/libreria/libros/nuevo")
    public String NuevoLibro(@RequestParam Long isbn,@RequestParam String titulo,@RequestParam Integer anio,@RequestParam String nombreAutor,@RequestParam String nombreEditorial) throws ErrorServicio{
        try {
            libroServicioImpl.NuevoLibro(isbn, titulo, anio, nombreAutor, nombreEditorial);
            return "NuevoLibro";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, Faltan parámetros o formato inválido.");
        }
    }
    
    @GetMapping("/libreria/libros/consultar")
    public String ConsultarLibros(@RequestParam String id,@RequestParam Long isbn,@RequestParam String titulo,@RequestParam Integer anio,@RequestParam Integer ejemplares,@RequestParam Integer ejemplaresPrestados,@RequestParam Integer ejemplaresRestantes,@RequestParam Boolean alta,@RequestParam Autor autor,@RequestParam Editorial editorial) throws ErrorServicio{
        try {
            libroServicioImpl.ConsultarLibros(id, isbn, titulo, anio, ejemplares, ejemplaresPrestados, ejemplaresRestantes, alta, autor, editorial);
            return "mostrarLibros";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, No se encuentra el libro.");
        }  
    }
    
    @PutMapping("/libreria/libros/modificar")
    public String ModificarLibros(@RequestParam String id, @RequestParam Long isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Boolean alta) throws ErrorServicio{
        try {
            libroServicioImpl.ModificarLibro(id, isbn, titulo, anio, ejemplares, alta);
            return "ModificarLibro";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, No se modificó correctamente.");
        }
    }
    
    @DeleteMapping("/libreria/libros/eliminar")
    public String EliminarLibro(@RequestParam String id) throws ErrorServicio{
        try {
            libroServicioImpl.eliminarLibro(id);
            return "eliminarLibro";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, no se eliminó el libro.");
        }
    }
}
