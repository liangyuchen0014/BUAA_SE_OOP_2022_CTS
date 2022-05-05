public class Ticket {
    String trainTogo;
    String startSt,endSt;
    String seatType;
    int ticketNum;
    double price;

    public Ticket(String trainTogo, String startSt, String endSt, String seatType, int ticketNum, double price) {
        this.trainTogo = trainTogo;
        this.startSt = startSt;
        this.endSt = endSt;
        this.seatType = seatType;
        this.ticketNum = ticketNum;
        this.price = price;
    }
}
