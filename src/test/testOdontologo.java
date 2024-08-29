package test;

import dao.impl.DaoH2Odontologo;
import org.junit.jupiter.api.BeforeAll;
import service.ServiceOdontologo;
import model.Odontologo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class testOdontologo {

    static final Logger logger = Logger.getLogger(testOdontologo.class);
    ServiceOdontologo serviceOdontologo = new ServiceOdontologo(new DaoH2Odontologo());

    @BeforeAll
    static void createTables(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./examen.database;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("Prueba listar todos BD")
    void caso1(){
        Odontologo odontologo1 = new Odontologo("1234567890","MARIA","PEREZ");
        Odontologo odontologo2 = new Odontologo("0987654321","PEDRO","BENJUMEA");
        Odontologo odontologo3 = new Odontologo("2468024680","ANA","ZARATE");
        Odontologo odontologo1DB = serviceOdontologo.save(odontologo1);
        Odontologo odontologo2DB = serviceOdontologo.save(odontologo2);
        Odontologo odontologo3DB = serviceOdontologo.save(odontologo3);
        List<Odontologo> odontologos;
        odontologos = serviceOdontologo.findAll();
        assertNotNull(odontologos);
        logger.info(odontologos);
    }


}
