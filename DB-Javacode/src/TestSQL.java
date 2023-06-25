public class TestSQL {
    public static void main (String[] args) {
        //new OracleConL2("INSERT INTO SCHIFF (IMO_NR, TEU) VALUES ('IMO1234567', 42)");
        //new OracleConL2("DELETE FROM SCHIFF WHERE IMO_NR = 'IMO1234567'");
        new OracleConL2("SELECT * FROM REISE");
    }
}
