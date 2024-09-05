package finalproject.com.Clinica_Odontologica.service;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public class IOdontologoService {
    Odontologo guardarOdontologo (Odontologo odontologo);
    List<Odontologo> buscarTodos();
    Optional<Odontologo> buscarId(Integer id);
    void modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Integer id);

    List<Odontologo> buscarApellidoNombre(String apellido, Stirng nombre);

    @Query("Select p from Odontologo p where p.nombre LIKE %:nombre%")
    List<Odontologo> buscarApellido(String apellido);
    List<Odontologo> buscarNombre(String nombre);
    Optional<Odontologo> buscarMatricula(String matricula);

}
