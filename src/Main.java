import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<String> lineaTXT = Reader.leer(); //Array del arhivo
        ArrayList<Proceso> procesosP = Controller.getProcedures(lineaTXT);
        //Controller.iterator(procesosP);

        while (true){

            System.out.println("\n1. Simulacion con vector Heap");
            System.out.println("2. Simulacion con JC");
            System.out.println("3. Salir");
            String take = in.nextLine();

            switch (take){
                case "1":
                    System.out.println("Implementando HEAP");
                    Controller.runHeap(procesosP);
                    break;
                case "2":
                    break;
                case "3":
                    System.out.println("Adios");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }




    }
}