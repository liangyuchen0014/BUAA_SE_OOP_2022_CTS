import java.util.ArrayList;
public class Train {
    static ArrayList<Train> Trains= new ArrayList<>();
    String TrainNo;
    String LineNo;
    char Type;
    double[] price=new double[3];
    int[] vacancySeat=new int[3];

    public Train(String s, String s1) {
        this.TrainNo=s;
        this.LineNo=s1;
        this.Type=TrainNo.charAt(0);
    }

    static boolean LineLegal(String s){
        for (Line i : Line.lines) {
            if(i.lineNo.equals(s)&&i.numOfTrain<i.capacity){
                return true;
            }
        }
        return false;
    }
    static void addTrain(String[] s) {
        Train tmp = new Train(s[1],s[2]);
        int argNum=2;
        switch (tmp.Type){
            case '0': case 'G':
                argNum=2;
                break;
            case 'K':
                argNum=1;
                break;
        }
        for (Train i : Trains)
            if (i.TrainNo.equals(tmp.TrainNo)){
                System.out.println("Train serial duplicate");
                return;
            }//添加列车时车次号不得重复
        if(!LineLegal(tmp.LineNo)) {
            System.out.println("Line illegal");
            return;
        }
        try{
            for(int i=0;i<=argNum;i++){
                tmp.price[i]=Double.parseDouble(s[2*i+3]);//票价赋值
                if(tmp.price[i]<=0)
                {
                    System.out.println("Price illegal");//票价具有实际意义
                    return;
                }
            }
        }
        catch (Exception e){
            System.out.println("Price illegal");
            return;
        }
        try{
            for(int i=0;i<=argNum;i++)//坐席张数赋值
                tmp.vacancySeat[i]=Integer.parseUnsignedInt(s[2*i+4]);
        }
        catch (Exception e){
            System.out.println("Ticket num illegal");//张数具有实际意义
            return;
        }
        Trains.add(tmp);
        for (Line i :Line.lines) {
            if(i.lineNo.equals(tmp.LineNo)&&i.numOfTrain<i.capacity){
                i.numOfTrain++;
                i.TrainsOnline.add(tmp);
            }
        }
        System.out.println("Add Train Success");
    }
    static void delTrain(String s){
        for (Train i : Trains) {
            if (i.TrainNo.equals(s)) {
                for (Line j : Line.lines) {
                    if(j.lineNo.equals(i.LineNo)){
                        for (Train k: j.TrainsOnline) {
                            if(i.TrainNo.equals(k.TrainNo)){
                                j.TrainsOnline.remove(k);
                                j.numOfTrain--;
                                Trains.remove(i);
                                System.out.println("Del Train Success");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Train does not exist");
    }
    static void checkTicket(String[] s){
        String iTrainNo=s[1];
        char iType=s[1].charAt(0);
        String start=s[2];
        int stkm=-1,endkm=-1;
        String end=s[3];
        String irate=s[4];
        int dist,ratenum = 0;
        for (Train i : Trains) {
            if(i.TrainNo.equals(iTrainNo)) {//i即为车次，下一步要找到线路
                for (Line j : Line.lines) {
                    if(j.lineNo.equals(i.LineNo)){//找到了线路
                        for (Station k : j.stations) {
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
                        else dist=2*j.maxDist-stkm-endkm;
                        System.out.printf("[%s: %s->%s] seat:%s remain:%d distance:%d price:%.2f\n",
                                iTrainNo,start,end,irate,i.vacancySeat[ratenum],dist,(double)dist*i.price[ratenum]);
                        return;
                    }
                }
            }
        }
        System.out.println("Train serial does not exist");
    }
}
//需要解决输出排序的问题