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
    void eliminarOdontologo(Integer id);

    @Query("Select o from Odontologo o where o.apellido like %:apellido%")
    List<Odontologo> buscarApellido(String apellido);

    @Query("Select o from Odontologo o where o.nombre like %:nombre%")
    List<Odontologo> buscarNombre(String nombre);

    @Query("Select o from Odontologo o where o.matricula like %:matricula%")
    Optional<Odontologo> buscarMatricula(String matricula);

    List<Odontologo> buscarPorApellidoyNombre(String apellido, String nombre);

}
