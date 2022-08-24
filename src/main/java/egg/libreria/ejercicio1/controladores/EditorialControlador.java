
package egg.libreria.ejercicio1.controladores;

import egg.libreria.ejercicio1.errores.ErrorServicio;
import egg.libreria.ejercicio1.servicios.EditorialServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libreria/editoriales")
public class EditorialControlador {
    @Autowired
    private EditorialServicioImpl editorialServicio;
    
    @PostMapping("/libreria/editoriales/nuevo")
    public String crearEditorial(@RequestParam String nombre) throws ErrorServicio{
        try {
            editorialServicio.crearEditorial(nombre);
            return "crearEditorial";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error al cargar la editorial.");
        }
    }
    
    @GetMapping("/libreria/editoriales/consultar")
    public String mostrarEditorial(@RequestParam String id, @RequestParam String nombre, @RequestParam Boolean alta) throws ErrorServicio{
        try {
            editorialServicio.consultarEditorial(id, nombre, alta);
            return "mostrarEditoriales";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, No se encuentra el editorial.");
        }
    }
    
    @PutMapping("/libreria/editoriales/modificar")
    public String modificarEditorial(@RequestParam String id, @RequestParam String nombre)throws ErrorServicio{
        editorialServicio.modificarEditorial(id, nombre);
        return "modificarEditorial";
    }
    
    @DeleteMapping("/libreria/editoriales/eliminar")
    public String eliminarEditorial(@RequestParam String id) throws ErrorServicio{
        try {
            editorialServicio.eliminarEditorial(id);
            return "eliminarEditorial";
        } catch (ErrorServicio e) {
            throw new ErrorServicio("Error, No se eliminó correctamente.");
        }
    }
}
