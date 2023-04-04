import java.util.ArrayList;

public class Controller {

    /**
     * Retorna un array list de los procesos del txt
     * @param procesos
     * @return
     */
    public static ArrayList<Proceso> getProcedures(ArrayList<String> procesos){
        ArrayList<Proceso> procedures = new ArrayList<Proceso>();
        for(int i = 0;i<procesos.size();i++){
            System.out.println(procesos.get(i));
            String[] separados = procesos.get(i).split(",");
            try{
                int NI = Integer.parseInt(separados[2]);
                Proceso nuvoProceso = new Proceso(separados[0],separados[1],NI); //Creating message
                procedures.add(nuvoProceso);
            }catch (Exception n){
                System.out.println(n.getMessage());
            }
        }
        return procedures;
    }

    public static void iterator(ArrayList<Proceso> procesos){
        for(int i = 0;i<procesos.size();i++){
            System.out.println("\n==============================");
            System.out.println("Nombre del procesos: "+procesos.get(i).getProcessName());
            System.out.println("Nombre del Usuario: "+procesos.get(i).getUserName());
            System.out.println("NICE: "+procesos.get(i).getNI());
            System.out.println("PR: "+procesos.get(i).getPR());
        }
    }

}
