import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db_connection {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the club management system");
        Statement sqlst;
        String output;
        ResultSet result;
        String sql="select * from employee order by eid";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dburl="jdbc:mysql://localhost:3306/club_management";
            Connection dbconn = DriverManager.getConnection(dburl,"root","");
            sqlst = dbconn.createStatement( );
            result=sqlst.executeQuery(sql);
            //Print table
            System.out.println("EID    | ENAME | ENATIONALITY | EJOINDATE | ESAL | EDOB | EPHNNO | ADDRESS | CLICNO ");
            while(result.next())
            {
                output=result.getString("eid")+
                " | "+result.getString("ename")+
                " | "+result.getString("enationality")+
                " | "+result.getString("ejoindate")+
                " | "+result.getString("esal")+
                " | "+result.getString("edob")+
                " | "+result.getString("ephnno")+
                " | "+result.getString("address")+
                " | "+result.getString("clicno");
                System.out.println(output);
            }
            sqlst.close();
        }
        catch(ClassCastException ex)
        {
            Logger.getLogger(Db_connection.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("class not found, check the JAR");
        }
        catch(SQLException ex){
            Logger.getLogger(Db_connection.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("Sql is bad!!"+ex.getMessage());
        }
    }
}