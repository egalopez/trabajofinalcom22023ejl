package data;

import static data.Conexion.*;
import java.sql.*;
import java.util.*;
import model.ActividadesClub;

public class DisciplinasDAO {
    private static final String SQL_CREATE="INSERT INTO disciplinas(deporte, dia, maximo, valorCuota, inscriptos) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_READ="SELECT * FROM disciplinas";
    private static final String SQL_READ_BY_ID= "SELECT * FROM disciplinas WHERE idActividad= ?";
    private static final String SQL_UPDATE_PRECIO="UPDATE disciplinas SET valorCuota = ? WHERE idActividad = ?";
    private static final String SQL_UPDATE_INSCRIPTOS="UPDATE disciplinas SET inscriptos = ? WHERE idActividad = ?";
    private static final String SQL_UPDATE="UPDATE disciplinas SET deporte = ?, dia = ?, maximo = ?, valorCuota = ?,inscriptos = ? WHERE idActividad = ?";
    private static final String SQL_DELETE="DELETE FROM disciplinas WHERE idActividad = ?";
    
    
    public List<ActividadesClub> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ActividadesClub disciplina ;
        List<ActividadesClub> disciplinas = new ArrayList();

        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int idActividad = rs.getInt(1);
                String deporte = rs.getString(2);
                String dia = rs.getString(3);
                int maximo = rs.getInt(4);
                double valorCuota = rs.getDouble(5);
                int inscriptos = rs.getInt(6);

                disciplina = new ActividadesClub(idActividad, deporte, dia, maximo, valorCuota, inscriptos);

                disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return disciplinas;
    }
    
    public ActividadesClub findById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ActividadesClub disciplina = null;
        
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int idActividad = rs.getInt(1);
                String deporte = rs.getString(2);
                String dia = rs.getString(3);
                int maximo = rs.getInt(4);
                double valorCuota = rs.getDouble(5);
                int inscriptos = rs.getInt(6);

                disciplina = new ActividadesClub(idActividad, deporte, dia, maximo, valorCuota, inscriptos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return disciplina;
    }
    
    
    
    public int insert(ActividadesClub disciplina){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, disciplina.getDeporte());
            stmt.setString(2, disciplina.getDia());
            stmt.setInt(3, disciplina.getMaximo());
            stmt.setDouble(4, disciplina.getValorCuota());
            stmt.setInt(5, disciplina.getInscriptos());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateValorCuota(ActividadesClub disciplina){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_PRECIO);
            stmt.setDouble(1, disciplina.getValorCuota());
            stmt.setInt(2, disciplina.getIdActividad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int updateInscriptos(ActividadesClub disciplina){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE_INSCRIPTOS);
            stmt.setInt(1, disciplina.getInscriptos());
            stmt.setInt(2, disciplina.getIdActividad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int update(ActividadesClub disciplina){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, disciplina.getDeporte());
            stmt.setString(2, disciplina.getDia());
            stmt.setInt(3, disciplina.getMaximo());
            stmt.setDouble(4, disciplina.getValorCuota());
            stmt.setInt(5, disciplina.getInscriptos());
            stmt.setInt(6, disciplina.getIdActividad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int deleteActividad(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int deleteDisciplina(int idActividad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
