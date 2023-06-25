import java.util.Scanner;

public class UIL {
    private static final String MENU =
            """
            [0]Schiff einfuegen
            [1]Schiffe nach max. 3 Attributen filtern
            [2]Reisen eines Schiffes Ausgeben
            [3]Programm schliessen
            """;
    private static Scanner scanner;
    private static boolean scannerRunning;

    static public void init(){
        if(!scannerRunning){
            scanner = new Scanner(System.in);
            scannerRunning = true;
        }
    }

    static public void printMenu(){
        System.out.print(MENU);
    }

    static public int waitForInput(){
            String input = scanner.nextLine();
            return Integer.parseInt(input);
    }

    static public void closeUI(){
        if(scannerRunning){
            scanner.close();
            scannerRunning = false;
        }
    }

    static public void getNewSchiffFromUser(){

        String IMO_NR;
        Integer TEU;
        Integer Baujahr;
        Integer Brz;
        Integer Nrz;
        String Hafen;

        System.out.print("Imo-Nr: \n");
        if (scanner.nextLine().length() != 10){
            System.out.print("ungültige Eingabe\n");
            return;
        }
        else{
            IMO_NR = scanner.nextLine();
        }

        System.out.print("Teu: ");
            TEU = Integer.parseInt(scanner.nextLine());

        System.out.println("Ist das Baujahr bekannt?[y/n]");
        if(scanner.nextLine().equals("y")) {
            System.out.print("Baujahr: ");
            Baujahr = Integer.parseInt(scanner.nextLine());
        }
        else{
            Baujahr = null;
            System.out.print("Baujahr wird auf null gesetzt\n");
        }

        System.out.println("Ist die Bruttoraumzahl bekannt?[y/n]");
        if(scanner.nextLine().equals("y")) {
            System.out.print("Bruttoraumzahl: ");
            Brz = Integer.parseInt(scanner.nextLine());
        }
        else{
            Brz = null;
            System.out.print("Bruttoraumzahl wird auf null gesetzt\n");
        }

        System.out.println("Ist die Nettoraumzahl bekannt?[y/n]");
        if(scanner.nextLine().equals("y")) {
            System.out.print("Nettoraumzahl: ");
            Nrz = Integer.parseInt(scanner.nextLine());;
        }
        else{
            Nrz = null;
            System.out.print("Nettoraumzahl wird auf null gesetzt\n");
        }

        System.out.println("Ist der Heimathafen bekannt?[y/n]");
        if(scanner.nextLine().equals("y")) {
            System.out.print("Heimathafen: ");
            if (scanner.nextLine().length() > 255 || scanner.nextLine().length() < 1){
                System.out.print("ungültige Eingabe\n");
                return;
            }
            else{
                Hafen = scanner.nextLine();
            }
        }
        else{
            Hafen = null;
            System.out.print("Hafen wird auf null gesetzt\n");
        }

        String command = ("INSERT INTO SCHIFF (IMO_NR, TEU, BAUJAHR, BRUTTORAUMZAHL, NETTORAUMZAHL, HAFEN)" +
                "VALUES ('"+IMO_NR+"',"+TEU+","+Baujahr+","+Brz+","+Nrz+", (SELECT LOCODE FROM HAFEN WHERE HAFEN_NAME = '"+Hafen+"'))");
        //System.out.println(command);
        new OracleConL2(command);
        //new OracleConL2("SELECT * FROM SCHIFF");
        System.out.println("Schiff eingefuegt");
        return;
    }

    static public void getAttributesFromUser() {
        String attribute;
        String value;
        String command = "SELECT * FROM SCHIFF";

        System.out.print("1. Attribut: ");
        attribute = scanner.nextLine();
        System.out.print("1. Wert: ");
        value = scanner.nextLine();
        command = command+" WHERE "+attribute+ " = '" +value+ "'";

        System.out.println("Soll mit einem zweiten Attribut gefiltert werden?[y/n]");
        if (scanner.nextLine().equals("y")) {
            System.out.print("2. Attribut: ");
            attribute = scanner.nextLine();
            System.out.print("2. Wert: ");
            value = scanner.nextLine();
            command = command+" AND "+attribute+ " = '" +value+ "'";

            System.out.println("Soll mit einem drittem Attribut gefiltert werden?[y/n]");
            if (scanner.nextLine().equals("y")) {
                System.out.print("3. Attribut: ");
                attribute = scanner.nextLine();
                System.out.print("3. Wert: ");
                value = scanner.nextLine();
                command = command+" AND "+attribute+ " = '" +value+ "'";
            }
        }

        System.out.println(command + "\n");
        System.out.println("Ausgabe:");
        new OracleConL2(command);
        System.out.println("\n");
        //new OracleConL2("SELECT * FROM SCHIFF");
        return;
    }



    static public void getSchiffForReise(){
            String command = "SELECT * FROM REISE";
            System.out.print("Imo-Nr: ");
             command = command+ " WHERE SCHIFF = '" +scanner.nextLine()+ "'";
            System.out.println(command + "\n");
            System.out.println("Ausgabe:");
            new OracleConL2(command);
             System.out.println("\n");
            return;
        }
    }
