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

    @Query("SELECT P FROM ODONTOLOGO P WHERE P.APELLIDO LIKE %:APELLIDO%");
    List<Odontologo> buscarApellido(String apellido);

    @Query("SELECT P FROM ODONTOLOGO P WHERE P.NOMBRE LIKE %:NOMBRE%");
    List<Odontologo> buscarNombre(String nombre);

    List<Odontologo> buscarApellidoNombre(String apellido, String nombre);

    Optional<Odontologo> buscarMatricula(String matricula);
}