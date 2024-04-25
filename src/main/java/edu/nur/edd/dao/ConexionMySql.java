package edu.nur.edd.dao;

import java.sql.*;

public class ConexionMySql {
    private static String URL_CONEXION =
            "jdbc:mysql://localhost:3306/ed?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USER = "root";
    private static String PASSWORD = "root";
    private Connection conexion;

    private static ConexionMySql instancia;

    public static ConexionMySql getOrCreate() throws SQLException {
        if (instancia == null)
            instancia = new ConexionMySql();
        return instancia;
    }

    private ConexionMySql() throws SQLException {
        conexion =
                DriverManager.getConnection(
                        URL_CONEXION, USER, PASSWORD);
    }
    public Connection getConnection(){
        return conexion;
    }

    public ResultSet ejecutarr(String sql, int returnGeneratedKeys) throws SQLException {
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet ejecutar(String sql, int returnGeneratedKeys) throws SQLException {
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet ejecutarInsertErr(String sql) throws  SQLException{
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ResultSet rs = ps.getGeneratedKeys();
        return rs;
    }
    public void ejecutarInsert(String sql) throws SQLException {
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ps.executeUpdate();
    }
    public void ejecutarUpdate(String sql) throws SQLException {
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ps.executeUpdate();
    }
    public void ejecutarDelete(String sql) throws SQLException{
        PreparedStatement ps =
                conexion.prepareStatement(sql);
        ps.executeUpdate();
    }
}
