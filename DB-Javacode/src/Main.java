import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UI.init();
        while(true){
            UI.printMenu();
            switch(UI.waitForInput()){
                case 0:{
                    Schiff schiff = UI.getNewSchiffFromUser();
                    System.out.println("Schiff eingefuegt");
                    break;
                }
                case 1:{
                    System.out.println("Schiffe gefiltert");
                    break;
                }
                case 2:{
                    String imoNr = UI.getSchiffForReise();
                    System.out.println("Reisen ausgegeben");
                    break;
                }
                case 3:{
                    UI.closeUI();
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
