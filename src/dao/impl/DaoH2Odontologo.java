package dao.impl;
import dao.IDao;
import db.H2Connection;
import model.Odontologo;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class DaoH2Odontologo implements IDao<Odontologo>{
    public static final Logger logger = Logger.getLogger(DaoH2Odontologo.class);
    public static final String SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    public static final String INSERT = "INSERT INTO ODONTOLOGOS VALUES(DEFAULT, ?,?,?)";

    @Override
    public Odontologo save(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoGuardado = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,odontologo.getNumeroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.executeUpdate();
            connection.commit();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()){
                Integer idDB = resultSet.getInt(1);
                odontologoGuardado = new Odontologo(idDB, odontologo.getNumeroMatricula(), odontologo.getNombre(), odontologo.getApellido());

            }
            logger.info("Odontologo guardado: " + odontologoGuardado);

        }catch(Exception e){
            if (connection != null){
                try {
                    connection.rollback();
                } catch(SQLException ex){
                    logger.error(e.getMessage());
                } finally {
                    try {
                        connection.setAutoCommit(true);
                    } catch (SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }
            }
            logger.error(e.getMessage());
            e.printStackTrace();

        }finally {
            try {
                connection.close();
            } catch(SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();

            }
        }
        return odontologoGuardado;
        }


    @Override
    public List<Odontologo> findAll() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologosDeBD = null;
        try{
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while(resultSet.next()){
                Integer id = resultSet.getInt(1);
                String numeroLicenciaOdontologo = resultSet.getString(2);
                String nombreOdontologo = resultSet.getString(3);
                String apellidoOdontologo = resultSet.getString(4);
                odontologosDeBD = new Odontologo(id,numeroLicenciaOdontologo,nombreOdontologo,apellidoOdontologo);
                odontologos.add(odontologosDeBD);
                logger.info("Odontologo agregado a la lista: " + odontologosDeBD);
            }
        } catch (Exception e){
            logger.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch(SQLException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        //logger.info("Esta es la lista de odontologos" + odontologos);
        return odontologos;
    }
}
