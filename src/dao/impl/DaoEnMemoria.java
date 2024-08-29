package dao.impl;
import dao.IDao;
import model.Odontologo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class DaoEnMemoria implements IDao<Odontologo> {
    public static final Logger logger = Logger.getLogger(DaoEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo save(Odontologo odontologo) {
        odontologo.setId(odontologos.size()+1);
        odontologos.add(odontologo);
        logger.info("Odontologo guardado en memoria: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> findAll() {
        logger.info("Odontologos encontrados en memoria: " + odontologos);
        return new ArrayList<>(odontologos);
    }
}
