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
        odontologoRepository.save(odontologo);  //FIX: MAYBE RETURN NEEDED
    }

    @Override
    public void eliminarOdontologo(Integer id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public List<Odontologo> buscarApellido(String apellido) {
        return odontologoRepository.buscarApellido(apellido);
    }

    @Override
    public List<Odontologo> buscarNombre(String nombre) {
        return odontologoRepository.buscarNombre(nombre);
    }

    @Override
    public List<Odontologo> buscarApellidoNombre(String apellido, String nombre) {
        return odontologoRepository.buscarApellidoNombre(apellido, nombre);
    }

    @Override
    public Optional<Odontologo> buscarMatricula(String matricula) {
        return odontologoRepository.buscarMatricula(matricula);
    }
}
