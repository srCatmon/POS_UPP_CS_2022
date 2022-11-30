/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgFuncionalidad;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class ventas {
    
    static Connection con = conectorBD.getConnection();
    private static Object[] datos = new Object[4];
    
    public static Object[] buscar(int codigoProducto){    
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM productos where codigoProducto ="+codigoProducto+";");
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
    
    public static void AgregarVenta(String[] Codigos) {
        try {
            for (int i = 0; i < Codigos.length; i++) {
                
            }
        } catch (Exception e) {

        }
    }
    
}
