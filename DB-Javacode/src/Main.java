import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UIL.init();
        while(true){
            UIL.printMenu();
            switch(UIL.waitForInput()){
                case 0:{
                    UIL.getNewSchiffFromUser();
                    System.out.println("Schiff eingefuegt");
                    break;
                }
                case 1:{
                    UIL.getAttributesFromUser();
                    System.out.println("Schiffe gefiltert");
                    break;
                }
                case 2:{
                    UIL.getSchiffForReise();
                    System.out.println("Reisen ausgegeben");
                    break;
                }
                case 3:{
                    UIL.closeUI();
                    System.exit(0);
                }
                default: {
                    System.out.println("ungueltige Eingabe");
                    break;
                }
            }
        }
    }
}
