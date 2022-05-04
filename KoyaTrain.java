import java.util.ArrayList;

public class KoyaTrain {
    static ArrayList<KoyaTrain> koyaTrains= new ArrayList<>();

    String TrainNo;
    String LineNo;
    double[] price=new double[2];
    int[] vacancySeat=new int[2];

    static boolean LineLegal(String s){
        for (Line i : Line.lines) {
            if(i.lineNo.equals(s)&&i.numOfTrain<i.capacity){
                return true;
            }
        }
        return false;
    }
    static void addTrain(String[] s) {
        KoyaTrain tmp = new KoyaTrain();
        tmp.TrainNo=s[1];
        tmp.LineNo=s[2];
        for (KoyaTrain i : koyaTrains)
            if (i.TrainNo.equals(tmp.TrainNo)){
                System.out.println("Train serial duplicate");
                return;
            }//添加列车时车次号不得重复

        if(!LineLegal(tmp.LineNo)) {
            System.out.println("Line illegal");
            return;
        }

        try{
            for(int i=0;i<=1;i++){
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
            for(int i=0;i<=1;i++)
                tmp.vacancySeat[i]=Integer.parseUnsignedInt(s[2*i+4]);
        }
        catch (Exception e){
            System.out.println("Ticket num illegal");//张数具有实际意义
            return;
        }
        koyaTrains.add(tmp);
        for (Line i :Line.lines) {
            if(i.lineNo.equals(tmp.LineNo)&&i.numOfTrain<i.capacity){
                i.numOfTrain++;
                i.KTrainsOnline.add(tmp);
            }
        }
        System.out.println("Add Train Success");
    }
    static void delTrain(String s){

        for (KoyaTrain i : koyaTrains) {
            if (i.TrainNo.equals(s)) {
                for (Line j : Line.lines) {
                    if(j.lineNo.equals(i.LineNo)){
                        for (KoyaTrain k: j.KTrainsOnline) {
                            if(i.TrainNo.equals(k.TrainNo)){
                                j.numOfTrain--;
                                j.KTrainsOnline.remove(k);
                                koyaTrains.remove(i);
                                System.out.println("Del Train Success");
                                return;
                            }
                        }
                    }
                }

                return;
            }
        }
        System.out.println("Train does not exist");
    }
    static void checkTicket(String[] s){
        String iTrainNo=s[1];
        String start=s[2];
        int stkm=-1,endkm=-1;
        String end=s[3];
        String irate=s[4];
        int dist,ratenum;
        for (KoyaTrain i : koyaTrains) {
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
                        switch (irate){
                            case "1A": ratenum=0;break;
                            case "2A": ratenum=1;break;
                            default:
                                System.out.println("Seat does not match");
                                return;
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
