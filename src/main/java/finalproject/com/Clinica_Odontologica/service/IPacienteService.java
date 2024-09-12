package finalproject.com.Clinica_Odontologica.service;

import finalproject.com.Clinica_Odontologica.entity.Paciente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {
    Paciente guardarPaciente(Paciente paciente);
    Optional<Paciente> buscarId(Integer id);
    Optional<Paciente> buscarDni(String dni);

    List<Paciente> buscarTodos();

    void modificarPaciente(Paciente paciente);
    void eliminarPaciente(Integer id);

    @Query("SELECT P FROM PACIENTE P WHERE P.NOMBRE LIKE %:NOMBRE%")
    List<Paciente> buscarNombre(String nombre);

    @Query("SELECT P FROM PACIENTE P WHERE P.APELLIDO LIKE %:APELLIDO%")
    List<Paciente> buscarApellido(String apellido);

    List<Paciente> buscarApellidoNombre(String apellido, String nombre);


}
