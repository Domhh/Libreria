
package egg.libreria.ejercicio1.servicios;

import egg.libreria.ejercicio1.entidades.Autor;
import egg.libreria.ejercicio1.entidades.Editorial;
import egg.libreria.ejercicio1.entidades.Libro;
import egg.libreria.ejercicio1.errores.ErrorServicio;
import egg.libreria.ejercicio1.repositorios.LibroRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroServicioImpl{
    
    @Autowired
    private LibroRepositorio repository;
    @Autowired
    private AutorServicioImpl autorServicio;
    @Autowired
    private EditorialServicioImpl editorialServicio;
    
    @Transactional
    public void NuevoLibro( Long isbn, String titulo, Integer anio, String nombreAutor, String nombreEditorial) throws ErrorServicio{
        
        
        //persistencia
        
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        Autor autor = autorServicio.crearAutor(nombreAutor);
        libro.setAutor(autor);
        Editorial editorial = editorialServicio.crearEditorial(nombreEditorial);
        libro.setEditorial(editorial);
        
        repository.save(libro);
        
    }
    //metodo creado para autorServicio
//    public Libro LibrosEditorial(String id){
//        Libro libro= repository.findById(id).get();
//        if(libro.getEditorial().getId() == null)
//        libro.getId();
//        libro.getIsbn();
//        libro.getTitulo();
//        libro.getAnio();
//        return repository.save(libro);
//    }
    @Transactional(readOnly = true)
    public void ConsultarLibros(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) throws ErrorServicio{
            Libro libro = repository.findById(id).get();
        libro.getId();
        libro.getIsbn();
        libro.getTitulo();
        libro.getAnio();
        libro.getEditorial();
        libro.getEjemplares();
        libro.getEjemplaresPrestados();
        libro.getEjemplaresRestantes();
        
        repository.save(libro);
        
    }
    
    @Transactional
    public void ModificarLibro(String id, Long isbn, String titulo, Integer anio, Integer ejemplares, Boolean alta) throws ErrorServicio{
        
        validar(isbn, titulo, anio, ejemplares, ejemplares, ejemplares, alta);
        
        Optional<Libro> respuesta = repository.findById(id);
        if(respuesta.isPresent()){
        Libro libro = respuesta.get();
        
        libro.setAlta(alta);
        String idAutor = null;
            if (libro.getAutor() != null) {
                idAutor = libro.getAutor().getId();
            }
        Autor autor = autorServicio.modificarAutor(idAutor, titulo);
        libro.setAutor(autor);
        libro.setAnio(anio);
        String idEditorial = null;
            if (libro.getEditorial() != null) {
                idEditorial = libro.getEditorial().getId();
            }
        Editorial editorial = editorialServicio.modificarEditorial(idEditorial, titulo);
        libro.setEditorial(editorial);
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        
        repository.save(libro);
        }else{
            throw new ErrorServicio("No se encontró el libro ");
        }
        
    }
    
    @Transactional
    public void darDeAlta(String id, Boolean alta) throws ErrorServicio{
        Optional<Libro> respuesta = repository.findById(id);
        if(respuesta.isPresent()){
        Libro libro = respuesta.get();
            libro.setAlta(true);
        repository.save(libro);
        }else{
            throw new ErrorServicio("No se encontró el libro ");
        }
        
    }
    
    @Transactional
    public void darDeBaja(String id, Boolean alta) throws ErrorServicio{
        Optional<Libro> respuesta = repository.findById(id);
        if(respuesta.isPresent()){
        Libro libro = respuesta.get();
            libro.setAlta(false);
        repository.save(libro);
        }else{
            throw new ErrorServicio("No se encontró el libro ");
        }
        
    }
    
    @Transactional
    public void eliminarLibro(String id) throws ErrorServicio{
        Libro libro = repository.getById(id);
        repository.delete(libro);
        repository.save(libro);
        
    }
    
    private void validar(Long isbn, String titulo, Integer anio, Integer ejemplares,  Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta) throws ErrorServicio{
        if(isbn == null || isbn.equals(isbn) == false){
            throw new ErrorServicio("No se encuentran libros con este isbn.");
        }
        if(titulo == null || titulo.isEmpty()){
            throw new ErrorServicio("No se encuentran libros con este título.");
        }
        if(anio == null || anio.equals(anio) == false){
            throw new ErrorServicio("No se encuentran libros de este anio.");
        }
        if(ejemplares == null || ejemplares <= 0){
            throw new ErrorServicio("No se encuentran ejemplares disponibles en el sistema.");
        }
//        if(editorial == null || editorial.equals(editorial) == false){ //Comprobar si esta forma funciona, sino modificar el equals
//            throw new ErrorServicio("No se encuentran libros de esta editorial en el sistema.");
//        }
        if(ejemplaresPrestados == null || ejemplaresPrestados.equals(ejemplaresPrestados)==false){
            throw new ErrorServicio("No se registraron libros prestados en el sistema.");
        }
        if(ejemplaresRestantes == null || ejemplaresRestantes.equals(ejemplaresRestantes)==false){
            throw new ErrorServicio("No se encuentran libros disponibles para prestar.");
        }
//        if(autor == null || autor.equals(autor) == false){
//            throw new ErrorServicio("No se encuentran libros de este autor en el sistema.");
//        }
        if(alta == null || alta.equals(alta) == false){
            throw new ErrorServicio("No está dado de alta.");
                    
        }
    }
    
    
    
}
