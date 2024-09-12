package finalproject.com.Clinica_Odontologica.service;

import finalproject.com.Clinica_Odontologica.dto.request.TurnoModifyDto;
import finalproject.com.Clinica_Odontologica.dto.request.TurnoRequestDto;
import finalproject.com.Clinica_Odontologica.dto.response.TurnoResponseDto;
import finalproject.com.Clinica_Odontologica.entity.Paciente;
import finalproject.com.Clinica_Odontologica.entity.Turno;

import java.util.List;
import java.util.Optional;


public interface ITurnoService {
    TurnoResponseDto guardarTurno(TurnoRequestDto turnoRequestDto);

    Optional<TurnoResponseDto> buscarId(Integer id);

    List<TurnoResponseDto> buscarTodos();

    void modificarTurno(TurnoModifyDto turnoModificarDto);
    void eliminarTurno(Integer id);
    List<Turno> buscarTurnoPaciente(String apellidoPaciente);
    List<Turno> buscarTurnoOdontologo(String matriculaOdontologo);
}
