package finalproject.com.Clinica_Odontologica.repository;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer>{

    @Query("SELECT P FROM ODONTOLOGO P WHERE P.NOMBRE LIKE %:NOMBRE%")
    List<Odontologo> buscarNombre(String nombre);

    @Query("SELECT P FROM ODONTOLOGO P WHERE P.APELLIDO LIKE %:APELLIDO%")
    List<Odontologo> buscarApellido(String apellido);

    Optional<Odontologo> buscarMatricula(String matricula); //FIX




}
