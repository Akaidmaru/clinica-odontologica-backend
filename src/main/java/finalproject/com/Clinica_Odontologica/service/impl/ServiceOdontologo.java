package finalproject.com.Clinica_Odontologica.service.impl;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.respository.IOdontologoRepository;
import finalproject.com.Clinica_Odontologica.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOdontologo implements IOdontologoService {

    private IOdontologoService odontologoService;

    public ServiceOdontologo(IOdontologoRepository IOdontologoRepository) {
        this.odontologoService = IOdontologoService;
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
        return odontologoRepository.findByFullName(appelido);
    }

    @Override
    public List<Odontologo> buscarNombre(String nombre) {
        return odontologoRepository.findByFullName(nombre);
    }

    @Override
    public List<Odontologo> buscarApellidoNombre(String apellido, String nombre) {
        return odontologoRepository.findByFullName(appelido, nombre);
    }

    @Override
    public Optional<Odontologo> buscarMatricula(String matricula) {
        return odontologoRepository.findByMatricula(matricula);
    }
}
