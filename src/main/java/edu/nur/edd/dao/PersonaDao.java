package edu.nur.edd.dao;

import edu.nur.edd.listas.ListaDoble;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class PersonaDao {
    private static Logger logger = LogManager.getRootLogger();
    public PersonaDao() {

    }
    public PersonaDto getById(int id) {// obtener un dato especifico llamano al id_ llave perimaria
        String sql = "SELECT id,nombre,altura FROM persona where id=" + id;
        PersonaDto resultado = null;
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            ResultSet rs = con.ejecutar(sql, Statement.RETURN_GENERATED_KEYS);

            if (rs.next()) {
                int idsql = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int altura = rs.getInt("altura");

                resultado = new PersonaDto(idsql, nombre, altura);
            }
            logger.info("se obtiene la informacion de una dato en especifico");
        } catch (SQLException e) {
            // loggear
            // throw new DaoException(msg)
        }
        return resultado;
    }
    public boolean verificarIniciarSesion(int id, String text1) {
        String sql = "SELECT id, nombre FROM persona";//no captura el id
        boolean verificador = false;
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            ResultSet rs = con.ejecutar(sql, Statement.RETURN_GENERATED_KEYS);
            int idsql = rs.getInt("id");
            String nombre = rs.getString("nombre");
            while (rs.next()){
                if (idsql == id && nombre.equals(text1.toLowerCase())){
                    verificador = true;
                    break;
                }
            }
        } catch (SQLException e) {
            logger.info("error en la verificacion1");
            logger.warn("error en la verificacion2");
            logger.error("error en la verificacion3");
        }
        return verificador;
    }
    public boolean verificarIniciarSesion2(int id, String nombre) {
        String sql = "SELECT COUNT(*) AS count FROM persona WHERE id=? AND nombre=?";
        boolean verificador = false;

        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                verificador = count > 0;
            }

        } catch (SQLException e) {
            logger.error("Error en la verificación de inicio de sesión: " + e.getMessage());
        }

        return verificador;
    }
    public ListaDoble<PersonaDto> getAll() {//llamar a todos los datos | select * from ...
        ListaDoble<PersonaDto> resultado = null;
        String sql = "SELECT id,nombre,altura FROM persona";
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            ResultSet rs = con.ejecutar(sql, Statement.RETURN_GENERATED_KEYS);

            resultado = new ListaDoble<>();
            while (rs.next()) {
                int idsql = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int altura = rs.getInt("altura");

                resultado.insertar(new PersonaDto(idsql, nombre, altura));
            }
            logger.info("llamanos a todos los registros que tiene la tabla");
        } catch(SQLException q) {
            // loggear
            // throw new DaoException(msg)
        }
        return resultado;
    }
    public ListaDoble<PersonaDto> getAllInAscendingOrder() {
        ListaDoble<PersonaDto> resultado = null;
        String sql = "SELECT id, nombre, altura FROM persona ORDER BY id";
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            ResultSet rs = con.ejecutar(sql, Statement.RETURN_GENERATED_KEYS);

            resultado = new ListaDoble<>();
            while (rs.next()) {
                int idsql = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int altura = rs.getInt("altura");

                resultado.insertar(new PersonaDto(idsql, nombre, altura));
            }
            logger.info("Obtained all records from the table in ascending order.");
        } catch (SQLException q) {
            // loggear
            // throw new DaoException(msg)
        }
        return resultado;
    }

    public boolean isIdAlreadyExists(int id) {
        String sql = "SELECT COUNT(*) as count FROM persona WHERE id=?";
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            PreparedStatement ps = (PreparedStatement) con.ejecutarInsertErr(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            // loggear
            // throw a new DaoException(msg)
        }
        return false; // En caso de error o si el id no existe en la base de datos
    }
    public void insert(PersonaDto nuevo){
        if (isIdAlreadyExists(nuevo.getId())){
            logger.info("+acaba de suceder un error no puedes registrar dos datos con el mismo" +
                    "(ID)");
            System.out.println("+No puedes registrar un dato con el mismo (id)");

            return;
        }
        try {

            String numeroFilasAfect = "INSERT INTO persona (id, nombre, altura) VALUES ("+
                    nuevo.getId()+",'" +
                    nuevo.getNombre()+"',"+
                    nuevo.getAltura()+")";
            ConexionMySql con = ConexionMySql.getOrCreate();
            con.ejecutarInsert(numeroFilasAfect);
        } catch (SQLException e){
            logger.info("++acaba de suceder un error no puedes registrar dos datos con el mismo" +
                    "(ID): " + nuevo.getId() + " | " + nuevo.getNombre());
            System.out.println("No puedes registrar un dato con el mismo (id)" + e.getMessage());
        }
    }
    public boolean update(PersonaDto p) {//actualizar dato
        String sql = "UPDATE persona " +
                "SET nombre='" + p.getNombre() + "', " +
                "altura=" + p.getAltura() +
                " WHERE id=" + p.getId();
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            con.ejecutarUpdate(sql);
        } catch (SQLException e) {
            // loggear
            // throw new DaoException(msg)
            return false;
        }
        return true;
    }
    public void delete(int id) {
        String sql = "DELETE FROM persona WHERE id = " + id;
        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            con.ejecutarDelete(sql);
        }catch (SQLException e){
            e.getMessage();
        }
    }

    public ListaDoble<PersonaDto> personasMasAltas() {
        String sql = "SELECT id, nombre, altura FROM persona ORDER BY altura DESC LIMIT 2";
        return executeGetPersonas(sql);
    }

    public ListaDoble<PersonaDto> personasMasBajas() {
        String sql = "SELECT id, nombre, altura FROM persona ORDER BY altura ASC LIMIT 2";
        return executeGetPersonas(sql);
    }
    private ListaDoble<PersonaDto> executeGetPersonas(String sql) {
        ListaDoble<PersonaDto> personas = new ListaDoble<>();

        try {
            ConexionMySql con = ConexionMySql.getOrCreate();
            ResultSet rs = con.ejecutar(sql, Statement.RETURN_GENERATED_KEYS);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int altura = rs.getInt("altura");
                personas.insertar(new PersonaDto(id, nombre, altura));
            }
        } catch (SQLException e) {
            logger.error("Error executing query: " + e.getMessage());
        }

        return personas;
    }
}

