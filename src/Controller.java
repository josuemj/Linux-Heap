import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.PriorityQueue;

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
            showProcessinfo(procesos,processRemoved);
        }
    }

    /**
     * Realizar la implementacion del HEAP handmade
     * @param procesos
     */

    public static void HeapJava(ArrayList<Proceso> procesos){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < procesos.size(); i++) {
            minHeap.offer(procesos.get(i).getPR());
        }
        while (!minHeap.isEmpty()) {
            int processRemoved = minHeap.remove();
            showProcessinfo(procesos,processRemoved);
        }
    }

    /**
     * Muestra el procesos dado el PR
     * @param procesos
     * @param PR
     */
    public static void showProcessinfo(ArrayList<Proceso> procesos,int PR){
        for (int i = 0; i < procesos.size(); i++) {
            if(procesos.get(i).getPR()==PR){
                System.out.println("\n==============");
                System.out.println("P name: "+procesos.get(i).getProcessName());
                System.out.println("U name: "+procesos.get(i).getUserName());
                System.out.println("NIC : "+procesos.get(i).getNI());
                System.out.println("PR: "+procesos.get(i).getPR());
                procesos.remove(procesos.get(i));
            }
        }
    }
}
