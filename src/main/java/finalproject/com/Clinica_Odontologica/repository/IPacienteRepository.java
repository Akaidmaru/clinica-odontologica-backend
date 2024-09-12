package finalproject.com.Clinica_Odontologica.repository;

import finalproject.com.Clinica_Odontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPacienteRepository extends  JpaRepository<Paciente, Integer>{

    List<Paciente> buscarApellidoNombre(String apellido, String nombre);

    @Query("SELECT P FROM PACIENTE P WHERE P.NOMBRE LIKE %:NOMBRE%")
    List<Paciente> buscarNombre(String nombre);

    @Query("SELECT P FROM PACIENTE P WHERE P.APELLIDO LIKE %:APELLIDO%")
    List<Paciente> buscarApellido(String apellido);

    Optional<Paciente> buscarDni(String matricula);

}
