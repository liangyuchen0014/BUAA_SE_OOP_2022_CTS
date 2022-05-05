public class ListOrder {
    public ListOrder(String[] s){
        if(s.length!=1) {
            System.out.println("Arguments illegal");
            return;
        }
        if(!Login.status){
            System.out.println("Please login first");
            return;
        }
        for (Ticket i : Login.loggedUser.myTicket) {
            System.out.printf("[%s: %s->%s] seat:%s num:%d price:%.2f\n",
                    i.trainTogo,i.startSt,i.endSt,i.seatType,i.ticketNum,i.price);
        }
    }
}
