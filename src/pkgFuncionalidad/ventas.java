/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgFuncionalidad;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class ventas {
    
    static Connection con = conectorBD.getConnection();
    static Statement st;
    static ResultSet rs;
    static Date fecha;
    
    public static Object[] buscar(int codigoProducto){    
        Object[] datos = new Object[4];
        try{
            st =  con.createStatement();
            rs = st.executeQuery("SELECT * FROM productos where codigoProducto ="+codigoProducto+";");
            if (rs.next()) {
                datos[0] = rs.getObject("codigoProducto");
                datos[1] = rs.getObject("nombre");
                datos[2] = rs.getObject("marca");
                datos[3] = rs.getObject("precio");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el producto");
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return datos;
    }
    
    public static void AgregarVenta(Object codigo, Object nombre, Object marca, Object cantidad, Object precio, String usuario, Date fecha) {
        try {
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("insert into ventas(codigoProducto,nombre,marca,precio,cantidad,vendedor,fecha) values(?,?,?,?,?,?,?)");
            ps.setObject(1, codigo);
            ps.setObject(2, nombre);
            ps.setObject(3, marca);
            ps.setObject(4, precio);
            ps.setObject(5, cantidad);
            ps.setObject(6, usuario);
            ps.setObject(7, fecha);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
