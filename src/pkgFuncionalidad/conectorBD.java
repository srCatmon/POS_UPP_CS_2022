package pkgFuncionalidad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */

public class conectorBD {

    public static Connection getConnection() {
        Connection con = null;
        try {
            //driver para la conexion con mysql
            Class.forName("org.gjt.mm.mysql.Driver");
            //
            con = DriverManager.getConnection("jdbc:mysql://192.168.8.89:3308/upp_pos_cs_2022?user=POS_SIS&password=159753123");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }

}
