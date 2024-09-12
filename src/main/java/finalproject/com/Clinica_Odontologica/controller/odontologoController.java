package finalproject.com.Clinica_Odontologica.controller;

import finalproject.com.Clinica_Odontologica.entity.Odontologo;
import finalproject.com.Clinica_Odontologica.service.impl.ServiceOdontologo; //FIX
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class odontologoController {

    private ServiceOdontologo serviceOdontologo;
    public odontologoController(ServiceOdontologo serviceOdontologo) {
        this.serviceOdontologo = serviceOdontologo;

    }
    @PostMapping("/guardar")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(serviceOdontologo.guardarOdontologo(odontologo));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscarId(@PathVariable Integer id){
        Optional<Odontologo> odontologo = serviceOdontologo.buscarId(id);
        if (odontologo.isPresent()){
            return ResponseEntity.ok(odontologo.get());
        }
        else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    @GetMapping("/buscartodos")
    public ResponseEntity<List<Odontologo>> buscartodos(){
        return ResponseEntity.ok(serviceOdontologo.buscarTodos());
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarOdontologo(@RequestBody Odontologo odontologo) {
        Optional<Odontologo> odontologoEncontrado = serviceOdontologo.buscarId(odontologo.getId());
        if (odontologoEncontrado.isPresent()) {
            serviceOdontologo.modificarOdontologo(odontologoEncontrado.get());
            String jsonResponse = "{\"mensaje\": \"El odontólogo ha sido modificado\"}";
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Integer id)
    {Optional<Odontologo> odontologoAEliminar = serviceOdontologo.buscarId(id);
        if (odontologoAEliminar.isPresent()){
            serviceOdontologo.eliminarOdontologo(id);
            String jsonResponse = "{\"mensaje\": \"El odontólogo ha sido eliminado\"}";
            return ResponseEntity.ok(jsonResponse);
            }
        else {
            return ResponseEntity.notFound().build();
            }
        }

    @GetMapping("/buscarApellido/{apellido}")
    public ResponseEntity<List<Odontologo>> buscarApellido(@PathVariable String apellido){
        return ResponseEntity.ok(serviceOdontologo.buscarApellido(apellido));

    }

    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<List<Odontologo>> buscarNombre(@PathVariable String nombre){
        return ResponseEntity.ok(serviceOdontologo.buscarNombre(nombre));

    }

    @GetMapping("/buscar/{matricula}")
    public ResponseEntity<Optional<Odontologo>> buscarMatricula(@PathVariable String matricula){
        Optional<Odontologo> odontologoEncontrado = serviceOdontologo.buscarMatricula(matricula);
        if (odontologoEncontrado.isPresent()){
            return ResponseEntity.ok(serviceOdontologo.buscarMatricula(matricula));
        }
        else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }
    }

