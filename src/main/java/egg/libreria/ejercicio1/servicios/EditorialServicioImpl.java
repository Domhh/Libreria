
package egg.libreria.ejercicio1.servicios;

import egg.libreria.ejercicio1.entidades.Editorial;
import egg.libreria.ejercicio1.errores.ErrorServicio;
import egg.libreria.ejercicio1.repositorios.EditorialRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServicioImpl{
    
    @Autowired
    private EditorialRepositorio repository;
    
    @Transactional
    public Editorial crearEditorial(String nombre) throws ErrorServicio{
        validar(nombre);
        Editorial editorial = new Editorial();
        
        editorial.setNombreEditorial(nombre);
        
        return repository.save(editorial);
        
    }
    
    public void consultarEditorial(String id, String nombre, Boolean alta) throws ErrorServicio{
        validar(nombre);
        Editorial editorial = repository.findById(id).get();
        
        editorial.getId();
        editorial.getNombreEditorial();
        editorial.getAlta();
        
        repository.save(editorial);
    }
    
    @Transactional
    public Editorial modificarEditorial(String id, String nombre) throws ErrorServicio{
        validar(nombre);
        
        Optional<Editorial>respuesta = repository.findById(id);
        if(respuesta.isPresent()){
            Editorial editorial = respuesta.get();
            
            editorial.setNombreEditorial(nombre);
            return repository.save(editorial);
        }else{
            throw new ErrorServicio("El editorial no está cargado en el sistema.");
        }
        
    }
    
    @Transactional
    public void darDeAlta(String id, String nombre, Boolean alta) throws ErrorServicio{
        Optional<Editorial>respuesta = repository.findById(id);
        if(respuesta.isPresent()){
            Editorial editorial = respuesta.get();
            editorial.setAlta(true);
            
            repository.save(editorial);
        }else{
            throw new ErrorServicio("El editorial no está cargado en el sistema.");
        }
        
    }
    
    @Transactional
    public void darDeBaja(String id, String nombre, Boolean alta) throws ErrorServicio{
        Optional<Editorial>respuesta = repository.findById(id);
        if(respuesta.isPresent()){
            Editorial editorial = respuesta.get();
            editorial.setAlta(false);
            
            repository.save(editorial);
        }else{
            throw new ErrorServicio("El editorial no está cargado en el sistema.");
        }
        
    }
    
    @Transactional
    public void eliminarEditorial(String id) throws ErrorServicio{
        Editorial editorial = repository.getById(id);
        repository.delete(editorial);
        repository.save(editorial);
    }
    
    public void validar(String nombre) throws ErrorServicio{
        if(nombre == null || nombre.isEmpty()){
            throw new ErrorServicio("No existe un editorial con ese nombre en el sistema.");
        }
//        if(alta == null || alta.equals(alta) == false){
//            throw new ErrorServicio("No está dado de alta.");
//        }
    }
}
