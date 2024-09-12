package finalproject.com.Clinica_Odontologica.repository;

import finalproject.com.Clinica_Odontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer>{
    @Query("SELECT T FROM TURNO T JOIN T.PACIENTE P WHERE P.APELLIDO = :APELLIDOPACIENTE")
    List<Turno> buscarTurnoApellidoPaciente(String apellidoPaciente);

    @Query("SELECT T FROM TURNO T JOIN T.ODONTOLOGO P WHERE P.MATRICULA = :MATRICULAODONTOLOGO")
    List<Turno> buscarTurnoMatriculaOdontologo(String apellidoPaciente);
}
