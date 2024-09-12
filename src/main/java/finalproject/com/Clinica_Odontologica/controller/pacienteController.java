package finalproject.com.Clinica_Odontologica.controller;

import finalproject.com.Clinica_Odontologica.entity.Paciente;
import finalproject.com.Clinica_Odontologica.service.impl.ServicePaciente;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class pacienteController {

    private ServicePaciente servicePaciente;

    public pacienteController(ServicePaciente servicePaciente) {
        this.servicePaciente = servicePaciente;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(servicePaciente.guardarPaciente(paciente));
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente> buscarId(@PathVariable Integer id){
        Optional<Paciente> paciente = servicePaciente.buscarId(id);
        if (paciente.isPresent()){
            return ResponseEntity.ok(paciente.get());
        }
        else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(servicePaciente.buscarTodos());
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarPaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> pacienteEncontrado = servicePaciente.buscarId(paciente.getId());
        if (pacienteEncontrado.isPresent()) {
            servicePaciente.modificarPaciente(pacienteEncontrado.get());
            String jsonResponse = "{\"mensaje\": \"El paciente ha sido modificado\"}";
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id)
    {Optional<Paciente> pacienteAEliminar = servicePaciente.buscarId(id);
        if (pacienteAEliminar.isPresent()){
            servicePaciente.eliminarPaciente(id);
            String jsonResponse = "{\"mensaje\": \"El paciente ha sido eliminado\"}";
            return ResponseEntity.ok(jsonResponse);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarApellido/{apellido}")
    public ResponseEntity<List<Paciente>> buscarApellido(@PathVariable String apellido){
        return ResponseEntity.ok(servicePaciente.buscarApellido(apellido));

    }

    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<List<Paciente>> buscarNombre(@PathVariable String nombre){
        return ResponseEntity.ok(servicePaciente.buscarNombre(nombre));

    }

    @GetMapping("/buscarApellidoNombre/{apellido}/{nombre}")
    public ResponseEntity<List<Paciente>> buscarApellidoNombre(@RequestParam String apellido, String nombre){
        return ResponseEntity.ok(servicePaciente.buscarApellidoNombre(apellido,nombre));

    }

    @GetMapping("/buscar/{dni}")
    public ResponseEntity<Optional<Paciente>> buscarDni(@PathVariable String dni){
        Optional<Paciente> pacienteEncontrado = servicePaciente.buscarDni(dni);
        if (pacienteEncontrado.isPresent()){
            return ResponseEntity.ok(servicePaciente.buscarDni(dni));
        }
        else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }


}
