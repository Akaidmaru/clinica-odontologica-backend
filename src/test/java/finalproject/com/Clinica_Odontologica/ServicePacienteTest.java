package finalproject.com.Clinica_Odontologica;
import finalproject.com.Clinica_Odontologica.service.impl.ServicePaciente;
import finalproject.com.Clinica_Odontologica.entity.Domicilio;
import finalproject.com.Clinica_Odontologica.entity.Paciente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
class ServicePacienteTest {
    @Autowired
    ServicePaciente servicePaciente;

    Paciente paciente;
    Paciente pacienteDB;

    @BeforeEach
    void crearPaciente(){
        Domicilio domicilio = new Domicilio(null,"Bonita", 679, "Wagne", "Medellin");
        paciente = new Paciente();
        paciente.setApellido("Tirado");
        paciente.setNombre("LAura");
        paciente.setDni("9787984");
        paciente.setFechaIngreso(LocalDate.of(2024, 6, 15));
        paciente.setDomicilio(domicilio);
        pacienteDB = servicePaciente.guardarPaciente(paciente);
    }


    @Test
    @DisplayName("Testear que un paciente se guarde en la base de datos con su domicilio")
    void caso1(){
        //dado
        // cuando
        // entonces
        assertNotNull(pacienteDB.getId());
    }

    @Test
    @DisplayName("Testear que un paciente pueda ser obtenido cuando se envia el id")
    void caso2(){
        //dado
        Integer id = pacienteDB.getId();
        // cuando
        Paciente pacienteEncontrado = servicePaciente.buscarId(id).get();
        // entonces
        assertEquals(id, pacienteEncontrado.getId());
    }

}