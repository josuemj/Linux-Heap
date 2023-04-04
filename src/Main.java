import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lineaTXT = Reader.leer(); //Array del arhivo
        ArrayList<Proceso> procesosP = Controller.getProcedures(lineaTXT);
        Controller.iterator(procesosP);
    }
}