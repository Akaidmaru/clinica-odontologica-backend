package finalproject.com.Clinica_Odontologica.service;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo (Odontologo odontologo);

    List<Odontologo> buscarTodos();

    Optional<Odontologo> buscarId(Integer id);
    void modificarOdontologo(Odontologo odontologo);
    Odontologo eliminarOdontologo(Integer id);

    @Query("Select p from Odontologo p where p.apellido like %:apellido%")
    List<Odontologo> buscarApellido(String apellido);

    @Query("Select p from Odontologo p where p.nombre like %:nombre%")
    List<Odontologo> buscarNombre(String nombre);

    Optional<Odontologo> buscarMatricula(String matricula);

    List<Odontologo> buscarPorApellidoyNombre(String apellido, String nombre);

}
