public class MainL {
   public static void main(String[] args) {
        UIL.init();
        while(true){
            UIL.printMenu();
            switch(UIL.waitForInput()){
                case 0:{
                    UIL.getNewSchiffFromUser();
                    break;
                }
                case 1:{
                    UIL.getAttributesFromUser();
                    break;
                }
                case 2:{
                    UIL.getSchiffForReise();
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
