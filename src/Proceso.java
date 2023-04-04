public class Proceso {

    private String processName;
    private String userName;
    private int NI;
    private int PR;

    public Proceso(String processName,String userName, int NI){
        this.processName = processName;
        this.userName = userName;
        this.NI = NI;
        this.PR = 20+NI;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNI() {
        return NI;
    }

    public void setNI(int NI) {
        this.NI = NI;
    }

    public int getPR() {
        return PR;
    }

    public void setPR(int PR) {
        this.PR = PR;
    }
}
