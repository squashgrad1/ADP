import java.sql.*;


public class OracleConL2 {

    String url = "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521/inf.informatik.haw-hamburg.de";
    String user = "db_2652458";
    String pass = "kYed0lVB_jrmlNWjsNhr";
    String command;

    public  OracleConL2(String command){
         this.command = command;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }


        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(this.command);
            ResultSetMetaData meta   = rs.getMetaData();
            int size = meta.getColumnCount();


            while (rs.next()) {
                String outputString = "";
                for(int i = 1; i <= size; i++){outputString = outputString + rs.getString(i) + " ";}
                System.out.println(outputString);
            }

            rs.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}