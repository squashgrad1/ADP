import java.util.Scanner;

public class UI {
    private static final String MENU =  "[1]Schiff einfuegen\n" +
                                        "[2]Schiffe nach max. 3 Attributen filtern\n" +
                                        "[3]Reise eines Schiffes Ausgeben\n" +
                                        "[4]Programm schliessen\n";
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
        return scanner.nextInt();
    }

    static public void closeUI(){
        if(scannerRunning){
            scanner.close();
            scannerRunning = false;
        }
    }

}
