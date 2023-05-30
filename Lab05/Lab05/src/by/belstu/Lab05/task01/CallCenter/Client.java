package by.belstu.Lab05.task01.CallCenter;

public class Client extends Thread {
    private String clientName;
    private CallCenter callCenter;

    public Client(String clientName, CallCenter callCenter) {
        this.clientName = clientName;
        this.callCenter = callCenter;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public CallCenter getCallCenter() {
        return callCenter;
    }

    public void setCallCenter(CallCenter callCenter) {
        this.callCenter = callCenter;
    }


    @Override
    public void run() {
        callCenter.acceptClient(this);
    }
}
