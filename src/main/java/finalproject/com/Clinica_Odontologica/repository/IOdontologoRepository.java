package finalproject.com.Clinica_Odontologica.repository;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer>{

    @Query("SELECT p FROM Odontologo p WHERE p.nombre LIKE %:nombre%")
    List<Odontologo> findByNombre(String nombre);

    @Query("SELECT p FROM Odontologo p WHERE p.apellido LIKE %:apellido%")
    List<Odontologo> findByApellido(String apellido);

    Optional<Odontologo> findByMatricula(String matricula); //FIX




}
