package service;

import dao.IDao;
import model.Odontologo;

import java.util.List;

public class ServiceOdontologo {
    private IDao<Odontologo> odontologoIDao;
    public ServiceOdontologo(IDao<Odontologo> odontologoIDao){
        this.odontologoIDao = odontologoIDao;
    }
    public Odontologo save(Odontologo odontologo){
        return odontologoIDao.save(odontologo);
    }

    public List<Odontologo> findAll(){
        return odontologoIDao.findAll();
    }
}
