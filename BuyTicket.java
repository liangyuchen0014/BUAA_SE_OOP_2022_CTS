public class BuyTicket {
    public static Train FindTrain(String s){
        for (Train i: Train.Trains) {
            if(i.TrainNo.equals(s))return i;
        }
        return null;
    }
    public BuyTicket(String[] s){
        Train iTrain;
        char iType=s[1].charAt(0);
        String start=s[2];
        String end=s[3];
        String irate=s[4];
        int stkm=-1,endkm=-1;
        int dist = 0,ratenum = 0;
        int ticketNum=0;
        if(s.length!=6) {
            System.out.println("Arguments illegal");
            return;
        }
        if(!Login.status){
            System.out.println("Please login first");
            return;
        }
        if((iTrain=FindTrain(s[1]))==null){
            System.out.println("Train does not exist");
            return;
        }
        for (Line i : Line.lines) {
            if(i.lineNo.equals(iTrain.LineNo)){
                for (Station k : i.stations) {
                    if(k.namest.equals(start))
                        stkm=k.km;
                    if(k.namest.equals(end))
                        endkm=k.km;
                }
                if(stkm==-1||endkm==-1){
                    System.out.println("Station does not exist");
                    return;
                }
                switch (iType){
                    case '0':
                        switch (irate){
                            case "CC": ratenum=0;break;
                            case "SB": ratenum=1;break;
                            case "GG": ratenum=2;break;
                            default:
                                System.out.println("Seat does not match");
                                return;
                        }
                        break;
                    case 'G':
                        switch (irate){
                            case "SC": ratenum=0;break;
                            case "HC": ratenum=1;break;
                            case "SB": ratenum=2;break;
                            default:
                                System.out.println("Seat does not match");
                                return;
                        }
                        break;
                    case 'K':
                        switch (irate){
                            case "1A": ratenum=0;break;
                            case "2A": ratenum=1;break;
                            default:
                                System.out.println("Seat does not match");
                                return;
                        }
                        break;
                }
                if(stkm<=endkm) dist = endkm - stkm;
                else dist=2*i.maxDist-stkm-endkm;
            }
        }
        try {
            ticketNum =Integer.parseInt(s[5]);
        } catch (NumberFormatException e) {
            System.out.println("Ticket number illegal");
            return;
        }//张数不是int类型
        if(ticketNum<=0){
            System.out.println("Ticket number illegal");
            return;
        }
        if(ticketNum>iTrain.vacancySeat[ratenum]){
            System.out.println("Ticket does not enough");
            return;
        }
        double TotalPrice=(double)dist*iTrain.price[ratenum]*ticketNum;
        Ticket iTicket=new Ticket(s[1],s[2],s[3],s[4],ticketNum,TotalPrice);
        Login.loggedUser.myTicket.addFirst(iTicket);
        iTrain.vacancySeat[ratenum]-=ticketNum;
        System.out.println("Thanks for your order");
    }
}
