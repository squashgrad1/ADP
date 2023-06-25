import java.sql.*;


public class OracleCon {
    public static void main(String[] args){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        String url = "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521/inf.informatik.haw-hamburg.de";
        String user = "db_2652458";
        String pass = "kYed0lVB_jrmlNWjsNhr";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM SCHIFF");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " +
                        rs.getString(2) + " " +
                        rs.getString(3) + " " +
                        rs.getString(4));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
