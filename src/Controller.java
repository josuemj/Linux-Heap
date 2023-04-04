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

    /**
     * Correr el sistema en base a vector HEAP.
     */
    public static void runHeap(ArrayList<Proceso> procesos) {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>(procesos.size());
        for (int i = 0; i < procesos.size(); i++) {
            pq.add(procesos.get(i).getPR());
        }
        while (!pq.isEmpty()) {
            int processRemoved = pq.remove();
            for (int i = 0;i<procesos.size();i++){
                try{
                    if(procesos.get(i).getPR() == processRemoved){
                        System.out.println("Process name: "+procesos.get(i).getProcessName()+" User Name: "+procesos.get(i).getUserName()+" NI: "+procesos.get(i).getNI()+" PR: "+processRemoved);
                        break;
                    }
                }catch (Exception e){
                }
            }
        }
    }

}
