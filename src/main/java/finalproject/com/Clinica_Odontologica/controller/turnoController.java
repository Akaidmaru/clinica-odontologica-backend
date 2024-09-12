package finalproject.com.Clinica_Odontologica.controller;

import finalproject.com.Clinica_Odontologica.dto.request.TurnoModifyDto;
import finalproject.com.Clinica_Odontologica.dto.request.TurnoRequestDto;
import finalproject.com.Clinica_Odontologica.dto.response.TurnoResponseDto;
import finalproject.com.Clinica_Odontologica.entity.Turno;
import finalproject.com.Clinica_Odontologica.service.impl.ServiceTurno;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> guardarTurno(@RequestBody TurnoRequestDto turnoRequestDto){
        TurnoResponseDto turnoNuevo = serviceTurno.guardarTurno(turnoRequestDto);
        if (turnoNuevo!= null){
        return ResponseEntity.ok(turnoNuevo);}
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El paciente/odontologo no fueron encontrados");
        }
    }


    @GetMapping("/buscartodos")
    public ResponseEntity<List<TurnoResponseDto>> buscarTodos(){
        return ResponseEntity.ok(serviceTurno.buscarTodos());
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoModifyDto turnoModifyDto) {
        serviceTurno.modificarTurno(turnoModifyDto);
        String jsonResponse = "{\"mensaje\": \"El turno ha sido modificado\"}";
        return ResponseEntity.ok(jsonResponse);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Integer id){
        serviceTurno.eliminarTurno(id);
        return ResponseEntity.ok("{\"mensaje\": \"El turno fue eliminado\"}");
    }
    }


