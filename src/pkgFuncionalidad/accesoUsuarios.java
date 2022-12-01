/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgFuncionalidad;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class accesoUsuarios {
    
    static Connection con = conectorBD.getConnection();
    
    public static String Acceso(String user, String passw){
        String nombre = "";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idUser, nombre, contrasena FROM usuarios where idUser ="+user+";");
            if (rs.next()) {
                if(passw.equals(rs.getObject("contrasena"))){
                    nombre = String.valueOf(rs.getObject("nombre"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto, por favor verifique");
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return nombre;
    }
    
}
