package finalproject.com.Clinica_Odontologica.controller;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.entity.Paciente;
import finalproject.com.Clinica_Odontologica.service.impl.ServicePaciente;
import finalproject.com.Clinica_Odontologica.service.impl.ServiceOdontologo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VistaController {
    private ServicePaciente servicePaciente;
    private ServiceOdontologo serviceOdontologo;

    public VistaController(ServicePaciente servicePaciente, ServiceOdontologo serviceOdontologo) {
        this.servicePaciente = servicePaciente;
        this.serviceOdontologo = serviceOdontologo;
    }

    // localhost:8080/20  -> @PathVariable
    // localhost:8080?id=1  -> @RequestParams
    @GetMapping("/index")
    public String mostrarPacientePorId(Model model, @RequestParam Integer id){
        Paciente paciente = servicePaciente.buscarId(id).get();
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "paciente";
    }

    @GetMapping("/index2/{id}")
    public String mostrarPacientePorId2(Model model, @PathVariable Integer id){
        Paciente paciente = servicePaciente.buscarId(id).get();
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "paciente";
    }

    @GetMapping("/odontologos")
    public String mostrarOdontologosPorId(Model model, @RequestParam Integer id){
        Odontologo odontologo = serviceOdontologo.buscarId(id).get();
        model.addAttribute("nombre", odontologo.getNombre());
        model.addAttribute("apellido", odontologo.getApellido());
        return "odontologo";
    }
}
