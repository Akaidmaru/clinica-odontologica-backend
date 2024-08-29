package test;

import dao.impl.DaoEnMemoria;
import service.ServiceOdontologo;
import model.Odontologo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.apache.log4j.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.*;

class testOdontologoEnMemoria {
    static final Logger logger = Logger.getLogger(testOdontologoEnMemoria.class);


    @Test
    @DisplayName("Prueba listar todos los odontologos en memoria")
    void caso1() {
        DaoEnMemoria daoEnMemoria = new DaoEnMemoria();
        ServiceOdontologo serviceOdontologo = new ServiceOdontologo(daoEnMemoria);
        Odontologo odontologo1 = new Odontologo("1234567890", "MARIA", "PEREZ");
        Odontologo odontologo2 = new Odontologo("0987654321", "PEDRO", "BENJUMEA");
        Odontologo odontologo3 = new Odontologo("2468024680", "ANA", "ZARATE");
        Odontologo odontologo1Memoria = serviceOdontologo.save(odontologo1);
        Odontologo odontologo2Memoria = serviceOdontologo.save(odontologo2);
        Odontologo odontologo3Memoria = serviceOdontologo.save(odontologo3);
        assertNotNull(daoEnMemoria.findAll());
        logger.info(daoEnMemoria.findAll());

    }
}
