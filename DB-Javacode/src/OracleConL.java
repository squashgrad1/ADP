import java.sql.*;

public class OracleConL {
    private final String url = "jdbc:oracle:thin:@oracle.informatik.haw-hamburg.de:1521/inf.informatik.haw-hamburg.de";
    private String user = "db_2652458";
    private String password = "kYed0lVB_jrmlNWjsNhr";
    private String table = "Schiff";
    private String command;


    public OracleConL() {
        //this.setCommand(command);
        this.setCommand("SELECT * FROM SCHIFF");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection con = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword());
            Statement stm = con.createStatement();
            stm.execute("USE"+" "+this.getTable());

            String rsString = "";
            ResultSet rs = stm.executeQuery("SELECT * FROM SCHIFF");
            int i = 0;
            while (rs.next()) {
                rsString = rsString+"/n"+rs.getString(i);
                i++;
            }
            System.out.println(rsString);

            rs.close();
            stm.close();
            con.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }


    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getTable() {
        return table;
    }

    public String getCommand() {
        return command;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
