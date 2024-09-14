package finalproject.com.Clinica_Odontologica.service.impl;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.entity.Paciente;
import finalproject.com.Clinica_Odontologica.repository.IPacienteRepository;
import finalproject.com.Clinica_Odontologica.service.IPacienteService;
import finalproject.com.Clinica_Odontologica.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePaciente implements IPacienteService {
    private final Logger logger = LoggerFactory.getLogger(ServicePaciente.class);
    private final IPacienteRepository pacienteRepository;

    public ServicePaciente(IPacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente){
        logger.info("Paciente guardado correctamente.");
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscarId(Integer id){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(id);
        if (pacienteEncontrado.isPresent()){
            logger.info("Paciente encontrado: " + pacienteEncontrado);
            return pacienteEncontrado;
        } else {
            logger.info("No se encontró el paciente: " + id + " Not Found.");
            throw new ResourceNotFoundException("No se encontró el paciente: " + id + " not found");
        }
    }

    @Override
    public Optional<Paciente> buscarDni(String dni){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findByDni((dni));
        if(pacienteEncontrado.isPresent()) {
            logger.info("Paciente encontrado: " + pacienteEncontrado);
            return pacienteEncontrado;
        }else{
            logger.info("El paciente no fue encontrado. DNI: " + dni + " Not found");
            throw new ResourceNotFoundException("El paciente no fue encontrado. DNI: " + dni + " not found.");
        }
    }


    @Override
    public List<Paciente> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        if (pacientes.isEmpty()){
            logger.info("No se encontraron pacientes.");
            throw new ResourceNotFoundException("No se encontraron pacientes.");
        } else {
            logger.info("Número de pacientes encontrados: " + pacientes.size());
            return pacientes;
        }
    }

    @Override
    public void modificarPaciente(Paciente paciente){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(paciente.getId());
        if(pacienteEncontrado.isPresent()){
            logger.info("Paciente modificado satisfactoriamente.");
            pacienteRepository.save(paciente);
        }else{
            logger.info("El paciente no fue encontrado. Id: " + paciente.getId() + " Not found.");
            throw new ResourceNotFoundException("El paciente no fue encontrado. Id: " + paciente.getId() + " Not found.");
        }
    }

    @Override
    public void eliminarPaciente(Integer id){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(id);
        if(pacienteEncontrado.isPresent()){
            logger.info("Paciente eliminado satisfactoriamente.");
            pacienteRepository.deleteById(id);
        }else{
            logger.info("El paciente no fue encontrado. Id: " + id + " Not found.");
            throw new ResourceNotFoundException("El paciente no fue encontrado. Id: " + id + " Not found.");
        }
    }

    @Override
    public List<Paciente> buscarNombre(String nombre){
        List<Paciente> pacientes = pacienteRepository.findByNombre(nombre);
        if(pacientes.isEmpty()){
            logger.info("No se encontraron pacientes.");
            throw new ResourceNotFoundException("No se encontraron pacientes.");
        }else{
            logger.info("Número de pacientes encontrados: " + pacientes.size());
            return pacientes;
        }
    }

    @Override
    public List<Paciente> buscarApellido(String apellido){
        List<Paciente> pacientes = pacienteRepository.findByApellido(apellido);
        if(pacientes.isEmpty()){
            logger.info("No se encontraron pacientes.");
            throw new ResourceNotFoundException("No se encontraron pacientes.");
        }else{
            logger.info("Número de pacientes encontrados: " + pacientes.size());
            return pacientes;
        }
    }


    @Override
    public List<Paciente> buscarPorApellidoyNombre(String apellido, String nombre) {
        List<Paciente> pacientes = pacienteRepository.findByApellidoAndNombre(apellido, nombre);
        if(pacientes.isEmpty()){
            logger.info("no se encontraron pacientes que coincidan con la busqueda");
            throw new ResourceNotFoundException("No se encontraron pacientes con ese nombre y apellido.");
        }else {
            return pacientes;
        }
    }
}
