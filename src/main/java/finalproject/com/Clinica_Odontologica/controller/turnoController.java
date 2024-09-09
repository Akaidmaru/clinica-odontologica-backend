package finalproject.com.Clinica_Odontologica.controller;

import finalproject.com.Clinica_Odontologica.entity.Turno;
import finalproject.com.Clinica_Odontologica.service.impl.ServiceTurno;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class turnoController {

    private ServiceTurno serviceTurno;

    public turnoController(ServiceTurno serviceTurno) {
        this.serviceTurno = serviceTurno;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Turno> guardarPaciente(@RequestBody Turno turno){
        return ResponseEntity.ok(serviceTurno.guardarTurno(turno));
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<Turno> buscarId(@PathVariable Integer id){
        Optional<Turno> turno = serviceTurno.buscarId(id);
        if (turno.isPresent()){
            return ResponseEntity.ok(turno.get());
        }
        else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(serviceTurno.buscarTodos());
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarTurno(@RequestBody Turno turno) {
        Optional<Turno> turnoEncontrado = serviceTurno.buscarId(turno.getId());
        if (turnoEncontrado.isPresent()) {
            serviceTurno.modificarTurno(turnoEncontrado.get());
            String jsonResponse = "{\"mensaje\": \"El turno ha sido modificado\"}";
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Integer id)
    {Optional<Turno> turnoAEliminar = serviceTurno.buscarId(id);
        if (turnoAEliminar.isPresent()){
            serviceTurno.eliminarTurno(id);
            String jsonResponse = "{\"mensaje\": \"El turno ha sido eliminado\"}";
            return ResponseEntity.ok(jsonResponse);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    }

