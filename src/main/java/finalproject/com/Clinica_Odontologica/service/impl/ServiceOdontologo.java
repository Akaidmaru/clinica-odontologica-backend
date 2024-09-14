package finalproject.com.Clinica_Odontologica.service.impl;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.repository.IOdontologoRepository;
import finalproject.com.Clinica_Odontologica.service.IOdontologoService;
import finalproject.com.Clinica_Odontologica.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOdontologo implements IOdontologoService {
    private final Logger logger = LoggerFactory.getLogger(ServiceOdontologo.class);
    private IOdontologoRepository odontologoRepository;

    public ServiceOdontologo(IOdontologoRepository IOdontologoRepository) {
        this.odontologoRepository = IOdontologoRepository;
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo){
        logger.info("Odontólogo guardado corréctamente.");
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarId(Integer id) {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(id);
        if (odontologoEncontrado.isPresent()){
            logger.info("Odontólogo encontrado: " + odontologoEncontrado);
            return odontologoEncontrado;
        } else {
            logger.info("No se encontró el odontólogo: " + id + " Not Found.");
            throw new ResourceNotFoundException("No se encontró el odontólogo: " + id + " not found");
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        if (odontologos.isEmpty()){
            logger.info("No se encontraron odontólogos.");
            throw new ResourceNotFoundException("No se encontraron odontólogos.");
        } else {
            logger.info("Número de odontólogos encontrados: " + odontologos.size());
            return odontologos;
        }
    }

    @Override
    public void modificarOdontologo(Odontologo odontologo){
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(odontologo.getId());
        if(odontologoEncontrado.isPresent()){
            logger.info("Odontólogo modificado satisfactoriamente.");
            odontologoRepository.save(odontologo);
        }else{
            logger.info("El odontólogo no fue encontrad. Id: " + odontologo.getId() + " Not found.");
            throw new ResourceNotFoundException("El odontólogo no fue encontrado. Id: " + odontologo.getId() + " Not found.");
        }

    }

    @Override
    public void eliminarOdontologo(Integer id) {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findById(id);
        if(odontologoEncontrado.isPresent()){
            logger.info("Odontólogo eliminado satisfactoriamente.");
            odontologoRepository.deleteById(id);

        }else{
            logger.info("El odontólogo no fue encontrado. Id: " + id + " Not found.");
            throw new ResourceNotFoundException("El odontólogo no fue encontrado. Id: " + id + " Not found.");
        }

    }

    @Override
    public List<Odontologo> buscarApellido(String apellido) {
        List<Odontologo> odontologos = odontologoRepository.findByApellido(apellido);
        if(odontologos.isEmpty()){
            logger.info("No se encontraron odontólogos.");
            throw new ResourceNotFoundException("No se encontraron odontólogos.");
        }else{
            logger.info("Número de odontólogos encontrados: " + odontologos.size());
            return odontologos;
        }
    }

    @Override
    public List<Odontologo> buscarNombre(String nombre) {
        List<Odontologo> odontologos = odontologoRepository.findByNombre(nombre);
        if(odontologos.isEmpty()){
            logger.info("No se encontraron odontólogos.");
            throw new ResourceNotFoundException("No se encontraron odontólogos.");
        }else{
            logger.info("Número de odontólogos encontrados: " + odontologos.size());
            return odontologos;
        }
    }

    @Override
    public List<Odontologo> buscarPorApellidoyNombre(String apellido, String nombre) {
        List<Odontologo> odontologos = odontologoRepository.findByApellidoAndNombre(apellido, nombre);
        if(odontologos.isEmpty()){
            logger.info("No se encontraron odontólogos.");
            throw new ResourceNotFoundException("No se encontraron odontólogos.");
        }else {
            return odontologos;
        }
    }

    @Override
    public Optional<Odontologo> buscarMatricula(String matricula) {
        Optional<Odontologo> odontologoEncontrado = odontologoRepository.findByMatricula((matricula));
        if(odontologoEncontrado.isPresent()) {
            logger.info("Odontólogo encontrado: " + odontologoEncontrado);
            return odontologoEncontrado;
        }else{
        logger.info("El odontólogo no fue encontrado. Matrícula: " + matricula + " Not found");
        throw new ResourceNotFoundException("El odontólogo no fue encontrado. Matrícula: " + matricula + " not found.");
        }
    }
}
