package DataM;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    Statement s1;               //

    public conn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_mart1", "root", "admin");
            s = c.createStatement();
            s1 = c.createStatement();               //
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
