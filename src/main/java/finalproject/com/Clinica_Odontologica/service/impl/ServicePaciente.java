package finalproject.com.Clinica_Odontologica.service.impl;

import finalproject.com.Clinica_Odontologica.entity.Paciente;
import finalproject.com.Clinica_Odontologica.repository.IPacienteRepository;
import finalproject.com.Clinica_Odontologica.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePaciente implements IPacienteService {
    private final IPacienteRepository pacienteRepository;

    public ServicePaciente(IPacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscarId(Integer id){
        return pacienteRepository.findById(id);
    }

    @Override
    public Optional<Paciente> buscarDni(String dni){
        return pacienteRepository.findByDni(dni);
    }


    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public void modificarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Integer id){
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<Paciente> buscarNombre(String nombre){
        return pacienteRepository.findByNombre(nombre);
    }

    @Override
    public List<Paciente> buscarApellido(String apellido){
        return pacienteRepository.findByApellido(apellido);
    }

}
