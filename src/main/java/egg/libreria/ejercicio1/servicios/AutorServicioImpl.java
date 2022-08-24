
package egg.libreria.ejercicio1.servicios;

import egg.libreria.ejercicio1.entidades.Autor;
import egg.libreria.ejercicio1.errores.ErrorServicio;
import egg.libreria.ejercicio1.repositorios.AutorRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServicioImpl{
    
    @Autowired
    private AutorRepositorio repository;
    
    @Transactional
    public Autor crearAutor(String nombre) throws ErrorServicio{
        validar(nombre);
        Autor autor = new Autor();
        autor.setNombreAutor(nombre);
// Para el siguiente bloque de código descomentar y editar Metodo LibrosEditorial
//        Libro libro = libroServicio.LibrosEditorial(nombre); 
        
        return repository.save(autor);
    }
    @Transactional(readOnly = true)
    public void consultarAutor(String id, String nombre, Boolean alta) throws ErrorServicio{
        validar(nombre);
        
        Autor autor = repository.findById(id).get();
        
        autor.getId();
        autor.getNombreAutor();
        autor.getAlta();
        
        repository.save(autor);
        
    }
    @Transactional
    public Autor modificarAutor(String id, String nombre) throws ErrorServicio{
        
        Optional<Autor>respuesta = repository.findById(id);
        if(respuesta.isPresent()){
            Autor autor = respuesta.get();
            
            autor.setNombreAutor(nombre);
            
            return repository.save(autor);
        }else{
            throw new ErrorServicio("No se encontró el autor.");
        }

    }
    @Transactional
    public void darDeAlta(String id, String nombre, Boolean alta) throws ErrorServicio{
        Optional<Autor>respuesta = repository.findById(id);
        if(respuesta.isPresent()){
            Autor autor = respuesta.get();
            
            autor.setAlta(true);
            repository.save(autor);
        }else{
            throw new ErrorServicio("No se encontró el autor.");
        }  
    }
    @Transactional
    public void darDeBaja(String id, String nombre, Boolean alta) throws ErrorServicio{
        Optional<Autor>respuesta = repository.findById(id);
        if(respuesta.isPresent()){
            Autor autor = respuesta.get();
            
            autor.setAlta(false);
            repository.save(autor);
        }else{
            throw new ErrorServicio("No se encontró el autor.");
        }
    }
    @Transactional
    public void eliminarAutor(String id)throws ErrorServicio{
        Autor autor=repository.getById(id);
        repository.delete(autor);
        repository.save(autor);
    }
    
    private void validar(String nombre) throws ErrorServicio{
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("El nombre no existe o caracteres mal ingresados");
        }
        
    }
//    private void validarAlta(Boolean alta) throws ErrorServicio{
//        if(alta == null || alta.equals(alta) == false){
//            throw new ErrorServicio("No está dado de alta.");
//        }
//    }
}
