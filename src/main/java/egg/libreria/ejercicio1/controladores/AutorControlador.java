
package egg.libreria.ejercicio1.controladores;

import egg.libreria.ejercicio1.errores.ErrorServicio;
import egg.libreria.ejercicio1.servicios.AutorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libreria/autores")
public class AutorControlador {
    
    @Autowired
    private AutorServicioImpl autorServicio;
    
    @GetMapping("/libreria/autores/consultar")
    public String consultarAutor(@RequestParam String id,@RequestParam String nombre,@RequestParam Boolean alta) throws ErrorServicio{
        try {
            autorServicio.consultarAutor(id, nombre, alta);
            return "mostrarAutores";    
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, No se encuentra el autor.");
        }
        
    }
    
    @PostMapping("/libreria/autores/nuevo")
    public String crearAutor(@RequestParam String nombre) throws ErrorServicio{
        try {
            autorServicio.crearAutor(nombre);
            return "guardarAutores";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, No se cargó el autor, revise los parámetros solicitados.");
        }
    }
    
    @PutMapping("/libreria/autores/modificar")
    public String modificarAutor(@RequestParam String id, @RequestParam String nombre) throws ErrorServicio{
        try {
            autorServicio.modificarAutor(id, nombre);
            return "modificarAutor";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error al modificar los datos del autor.");
        }
    }
    
    @DeleteMapping("/libreria/autores/eliminar")
    public String borrarAutor(@RequestParam String id) throws ErrorServicio{
        try {
            autorServicio.eliminarAutor(id);
            return "eliminarAutor";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, No se borró el editorial.");
        }
        
    }
    
}
