package finalproject.com.Clinica_Odontologica.service.impl;

import finalproject.com.Clinica_Odontologica.dto.request.*;
import finalproject.com.Clinica_Odontologica.dto.response.*;
import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.entity.Paciente;
import finalproject.com.Clinica_Odontologica.entity.Turno;
import finalproject.com.Clinica_Odontologica.repository.ITurnoRepository;
import finalproject.com.Clinica_Odontologica.service.ITurnoService;
import finalproject.com.Clinica_Odontologica.config.ModelMapperConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceTurno implements ITurnoService {
    private ITurnoRepository turnoRepository;
    private ServicePaciente servicePaciente;
    private ServiceOdontologo serviceOdontologo;
    @Autowired
    private ModelMapper modelMapper;

    public ServiceTurno(ITurnoRepository turnoRepository, ServicePaciente servicePaciente, ServiceOdontologo serviceOdontologo){
        this.turnoRepository = turnoRepository;
        this.servicePaciente = servicePaciente;
        this.serviceOdontologo = serviceOdontologo;
    }

    @Override
    public TurnoResponseDto guardarTurno(TurnoRequestDto turnoRequestDto){
        Optional<Paciente> paciente = servicePaciente.buscarId(turnoRequestDto.getPaciente_id());
        Optional<Odontologo> odontologo = serviceOdontologo.buscarId(turnoRequestDto.getOdontologo_id());
        Turno turno = new Turno();
        Turno turnoDB = null;
        TurnoResponseDto turnoReturn = null;
        if (paciente.isPresent() && odontologo.isPresent()){
            turno.setPaciente(paciente.get());
            turno.setOdontologo(odontologo.get());
            turno.setFecha(LocalDate.parse(turnoRequestDto.getFecha()));

            turnoDB = turnoRepository.save(turno);

            turnoReturn = turnoMappingResponse(turnoDB);
        }
        return turnoReturn;
    }

    @Override
    public Optional<TurnoResponseDto> buscarId(Integer id){
        Optional<Turno> turnoDB = turnoRepository.findById(id);
        TurnoResponseDto turnoResponseDto = null;
        if(turnoDB.isPresent()){
            turnoResponseDto = turnoMappingResponse(turnoDB.get());
        }
        return Optional.ofNullable(turnoResponseDto);
    }

    @Override
    public List<TurnoResponseDto> buscarTodos(){
        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoResponseDto> turnoReturn = new ArrayList<>();
        for (Turno t: turnos){
            TurnoResponseDto turnoAux = turnoMappingResponse(t);
            turnoReturn.add(turnoAux);
        }
        return turnoReturn;
    };

    @Override
    public void modificarTurno(TurnoModifyDto turnoModifyDto) {
        Optional<Paciente> paciente = servicePaciente.buscarId(turnoModifyDto.getPaciente_id());
        Optional<Odontologo> odontologo = serviceOdontologo.buscarId(turnoModifyDto.getOdontologo_id());
        Turno turno = null;
        if (paciente.isPresent() && odontologo.isPresent()) {
            turno = new Turno(turnoModifyDto.getId(), paciente.get(), odontologo.get(), LocalDate.parse(turnoModifyDto.getFecha()));
            turnoRepository.save(turno);
        }
    }

    @Override
    public void eliminarTurno(Integer id) {
        turnoRepository.deleteById(id);
    }

    private TurnoResponseDto transformTurnoToResponse(Turno turnoDB){
        OdontologoResponseDto odontologoResponseDto = new OdontologoResponseDto(
                turnoDB.getOdontologo().getId(), turnoDB.getOdontologo().getMatricula(),
                turnoDB.getOdontologo().getNombre(), turnoDB.getOdontologo().getApellido()
        );

        PacienteResponseDto pacienteResponseDto = new PacienteResponseDto(
                turnoDB.getPaciente().getId(), turnoDB.getPaciente().getNombre(),
                turnoDB.getPaciente().getApellido(), turnoDB.getPaciente().getDni()
        );

        TurnoResponseDto turnoReturn = new TurnoResponseDto(
                turnoDB.getId(), pacienteResponseDto, odontologoResponseDto,
                turnoDB.getFecha().toString()
        );
        return turnoReturn;
    };

    private TurnoResponseDto turnoMappingResponse(Turno turno){
        TurnoResponseDto turnoResponseDto = modelMapper.map(turno, TurnoResponseDto.class);
        turnoResponseDto.setOdontologoResponseDto(modelMapper.map(turno.getOdontologo(), OdontologoResponseDto.class));
        turnoResponseDto.setPacienteResponseDto(modelMapper.map(turno.getPaciente(), PacienteResponseDto.class));
        return turnoResponseDto;
    }

    @Override
    public List<Turno> buscarTurnoPaciente(String apellidoPacinte){
        return turnoRepository.buscarTurnoApellidoPaciente(apellidoPacinte);
    }

    @Override
    public List<Turno> buscarTurnoOdontologo(String matriculaOdontolo){
        return turnoRepository.buscarTurnoMatriculaOdontologo(matriculaOdontolo);
    }
}
