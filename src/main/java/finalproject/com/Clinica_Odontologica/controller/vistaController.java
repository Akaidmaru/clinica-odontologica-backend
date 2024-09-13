package finalproject.com.Clinica_Odontologica.controller;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.entity.Paciente;
import finalproject.com.Clinica_Odontologica.service.impl.ServicePaciente;
import finalproject.com.Clinica_Odontologica.service.impl.ServiceOdontologo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class vistaController {

    private ServicePaciente servicePaciente;

    private ServiceOdontologo serviceOdontologo;

    public vistaController(ServicePaciente servicePaciente, ServiceOdontologo serviceOdontologo){
        this.servicePaciente = servicePaciente;
        this.serviceOdontologo = serviceOdontologo;
    }

    @GetMapping("/indexPaciente")
    public String buscarPaciente(Model model, @RequestParam Integer id) {
        Paciente paciente = servicePaciente.buscarId(id).get();
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "vista/paciente";
    }

    @DeleteMapping("/deletePaciente")
    public String borrarPaciente(Model model, @RequestParam Integer id){
        Paciente paciente = servicePaciente.eliminarPaciente(id);
        return "El paciente ha sido eliminado";
    }

    @GetMapping("/newPacienteForm")
    public String nuevoPaciente(Model model){
        model.addAttribute("paciente", new Paciente());
        return "vista/nuevoPaciente";
    }

    @PostMapping("/savePaciente")
    public String guardarPaciente(@ModelAttribute Paciente paciente, Model model){
        Paciente nuevoPaciente = servicePaciente.guardarPaciente(paciente);
        model.addAttribute(nuevoPaciente);
        return "vista/pacienteGuardado";
    }

    @GetMapping("/editPacienteForm")
    public String editPacienteForm(@RequestParam Integer id, Model model){
        Optional<Paciente> paciente = servicePaciente.buscarId(id);
        model.addAttribute(paciente);
        return "vista/editPacienteForm";
    }

    @PutMapping("/modificarPaciente")
    public String modificarPaciente(@ModelAttribute Paciente paciente, Model model){
        servicePaciente.modificarPaciente(paciente);
        model.addAttribute(paciente);
        return "vista/pacienteModificado";
    }

    @GetMapping("/buscarNombrePaciente")
    public String buscarNombrePaciente(@RequestParam String nombre, Model model) {
        List<Paciente> pacientes = servicePaciente.buscarNombre(nombre);
        model.addAttribute("pacientes", pacientes);
        return "vista/nombresPacienteEncontrados";
    }

    @GetMapping("/buscarApellidoPaciente")
    public String buscarApellidoPaciente(@RequestParam String apellido, Model model) {
        List<Paciente> pacientes = servicePaciente.buscarApellido(apellido);
        model.addAttribute("pacientes", pacientes);
        return "vista/apellidosEncontrados";
    }

    @GetMapping("/buscarDni")
    public String buscarDni(@RequestParam String dni, Model model) {
        Optional<Paciente> pacientes = servicePaciente.buscarDni(dni);
        model.addAttribute("dni", pacientes);
        return "vista/dni";
    }

    @GetMapping("/indexOdontologo")
    public String buscarOdontologo(Model model, @RequestParam Integer id) {
        Odontologo odontologo = serviceOdontologo.buscarId(id).get();
        model.addAttribute("nombre", odontologo.getNombre());
        model.addAttribute("apellido", odontologo.getApellido());
        return "vista/paciente";
    }

    @DeleteMapping("/deleteOdontologo")
    public String borrarOdontologo(Model model, @RequestParam Integer id){
        Odontologo odontologo = serviceOdontologo.eliminarOdontologo(id);
        return "El odontologo ha sido eliminado";
    }

    @GetMapping("/newOdontologoForm")
    public String nuevoOdontologo(Model model){
        model.addAttribute("odontologo", new Odontologo());
        return "vista/nuevoOdontologo";
    }

    @PostMapping("/saveOdontologo")
    public String guardarOdontologo(@ModelAttribute Odontologo odontologo, Model model){
        Odontologo nuevoOdontologo = serviceOdontologo.guardarOdontologo(odontologo);
        model.addAttribute(nuevoOdontologo);
        return "vista/odontologoGuardado";
    }

    @GetMapping("/editOdontologoForm")
    public String editOdontologoForm(@RequestParam Integer id, Model model){
        Optional<Odontologo> odontologo = serviceOdontologo.buscarId(id);
        model.addAttribute(odontologo);
        return "vista/editOdontologoForm";
    }

    @PutMapping("/modificarOdontologo")
    public String modificarOdontologo(@ModelAttribute Odontologo odontologo, Model model){
        serviceOdontologo.modificarOdontologo(odontologo);
        model.addAttribute(odontologo);
        return "vista/odontologoModificado";
    }

    @GetMapping("/buscarNombreOdontologo")
    public String buscarNombreOdontologo(@RequestParam String nombre, Model model) {
        List<Odontologo> odontologos = serviceOdontologo.buscarNombre(nombre);
        model.addAttribute("pacientes", odontologos);
        return "vista/nombresOdontologoEncontrados";
    }

    @GetMapping("/buscarApellidoOdontologo")
    public String buscarApellidoOdontologo(@RequestParam String apellido, Model model) {
        List<Odontologo> odontologos = serviceOdontologo.buscarApellido(apellido);
        model.addAttribute("pacientes", odontologos);
        return "vista/apellidosOdontologoEncontrados";
    }

    @GetMapping("/buscarMatricula")
    public String buscarMatricula(@RequestParam String matricula, Model model) {
        Optional<Odontologo> odontologos = serviceOdontologo.buscarMatricula(matricula);
        model.addAttribute("matricula", odontologos);
        return "vista/matricula";
    }
}
