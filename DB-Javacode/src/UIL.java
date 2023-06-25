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
        int TEU;
        int Baujahr;
        int Brz;
        int Nrz;
        String Hafen;

        System.out.print("Imo-Nr: ");
        if (scanner.nextLine().length() > 10 || scanner.nextLine().length() < 1){
            System.out.print("ungültige Eingabe");
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
            Baujahr = Integer.parseInt(null);
        }

        System.out.println("Ist die Bruttoraumzahl bekannt?[y/n]");
        if(scanner.nextLine().equals("y")) {
            System.out.print("Bruttoraumzahl: ");
            Brz = Integer.parseInt(scanner.nextLine());
        }
        else{
            Brz = Integer.parseInt(null);
        }

        System.out.println("Ist die Nettoraumzahl bekannt?[y/n]");
        if(scanner.nextLine().equals("y")) {
            System.out.print("Nettoraumzahl: ");
            Nrz = Integer.parseInt(scanner.nextLine());;
        }
        else{
            Nrz = Integer.parseInt(null);
        }

        System.out.println("Ist der Heimathafen bekannt?[y/n]");
        if(scanner.nextLine().equals("y")) {
            System.out.print("Locode des Heimathafens: ");
            if (scanner.nextLine().length() > 6 || scanner.nextLine().length() < 1){
                System.out.print("ungültige Eingabe");
                return;
            }
            else{
                Hafen = scanner.nextLine();
            }
        }
        else{
            Hafen = null;
        }

        new OracleConL("INSERT INTO SCHIFF (IMO_NR, TEU, BAUJAHR, BRUTTORAUMZAHL, NETTORAUMZAHL, HAFEN)\n" +
                "VALUES ("+IMO_NR+","+TEU+","+Baujahr+","+Brz+","+Nrz+","+Hafen+"));\n");
    }

    static public String getSchiffForReise(){
        System.out.print("Imo-Nr: ");
        return scanner.nextLine();
    }
}
