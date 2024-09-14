package finalproject.com.Clinica_Odontologica.repository;

import finalproject.com.Clinica_Odontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer>{

    @Query("Select p from Paciente p where p.nombre like %:nombre%")
    List<Paciente> findByNombre(String nombre);

    @Query("Select p from Paciente p where p.apellido like %:apellido%")
    List<Paciente> findByApellido(String apellido);

    List<Paciente> findByApellidoAndNombre(String apellido, String nombre);

    Optional<Paciente> findByDni(String matricula);

}
