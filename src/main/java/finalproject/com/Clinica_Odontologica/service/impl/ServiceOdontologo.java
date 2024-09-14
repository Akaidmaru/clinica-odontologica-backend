package finalproject.com.Clinica_Odontologica.service.impl;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.repository.IOdontologoRepository;
import finalproject.com.Clinica_Odontologica.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOdontologo implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;

    public ServiceOdontologo(IOdontologoRepository IOdontologoRepository) {
        this.odontologoRepository = IOdontologoRepository;
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarId(Integer id) {
        return odontologoRepository.findById(id);
    }

        @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public void modificarOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo eliminarOdontologo(Integer id) {
        odontologoRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Odontologo> buscarApellido(String apellido) {
        return odontologoRepository.findByApellido(apellido);
    }

    @Override
    public List<Odontologo> buscarNombre(String nombre) {
        return odontologoRepository.findByNombre(nombre);
    }

    @Override
    public List<Odontologo> buscarPorApellidoyNombre(String apellido, String nombre) {
        List<Odontologo> odontologos = odontologoRepository.findByApellidoAndNombre(apellido, nombre);
        if(odontologos.isEmpty()){
            return null;
            // logger.info("no se encontraron odontologos que coincidan con la busqueda");
            //throw new ResourceNotFoundException("No se encontraron odontologos con ese nombre y apellido");
        }else {
            return odontologos;
        }
    }

    @Override
    public Optional<Odontologo> buscarMatricula(String matricula) {
        return odontologoRepository.findByMatricula(matricula);
    }
}
