package bank;

import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;
    public conn(){
        try{
            // Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///bankManagementSystem","root","Chandan@2002");
            s=c.createStatement();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
