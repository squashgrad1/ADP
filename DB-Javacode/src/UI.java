import java.sql.Time;
import java.util.Scanner;
import java.time.*;

public class UI {
    private static final String MENU =  "[0]Schiff einfuegen\n" +
                                        "[1]Schiffe nach max. 3 Attributen filtern\n" +
                                        "[2]Reise eines Schiffes Ausgeben\n" +
                                        "[3]Programm schliessen\n";
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

    static public Schiff getSchiffFromUser(){
        Schiff schiff = new Schiff();

        System.out.print("Imo-Nr: ");
        schiff.setImoNr(scanner.nextLine());

        System.out.print("Teu: ");
        schiff.setTeu(scanner.nextLine());

        System.out.println("Ist Baujahr null?[y/n]");
        if(scanner.nextLine().equals("n")) {
            System.out.print("Baujahr: ");
            schiff.setBaujahr(scanner.nextLine());
        }

        System.out.println("Ist Bruttoraumzahl null?[y/n]");
        if(scanner.nextLine().equals("n")) {
            System.out.print("Bruttoraumzahl: ");
            schiff.setBruttoraumzahl(scanner.nextLine());
        }

        System.out.println("Ist Nettoraumzahl null?[y/n]");
        if(scanner.nextLine().equals("n")) {
            System.out.print("Nettoraumzahl: ");
            schiff.setNettoraumzahl(scanner.nextLine());
        }

        System.out.println("Ist Hafen null?[y/n]");
        if(scanner.nextLine().equals("n")) {
            System.out.print("Hafen Name: ");
            schiff.setHafen_name(scanner.nextLine());
        }
        return schiff;
    }

}
