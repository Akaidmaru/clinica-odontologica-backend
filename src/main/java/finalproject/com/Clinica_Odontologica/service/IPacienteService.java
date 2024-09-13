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
    Paciente eliminarPaciente(Integer id);

    @Query("Select p from Paciente p where p.nombre like %:nombre%")
    List<Paciente> buscarNombre(String nombre);

    @Query("Select p from Paciente p where p.apellido like %:apellido%")
    List<Paciente> buscarApellido(String apellido);

}
