import java.util.Collections;
import java.util.Comparator;

public class ListTrain {
    public void SortTrainOnline(Line i){
        try{
            i.KTrainsOnline.sort(new Comparator<KoyaTrain>() {
                @Override
                public int compare(KoyaTrain o1, KoyaTrain o2) {
                    return o1.TrainNo.compareTo(o2.TrainNo);
                }
            });
            i.GTrainsOnline.sort(new Comparator<GatimaanTrain>() {
                @Override
                public int compare(GatimaanTrain o1, GatimaanTrain o2) {
                    return o1.TrainNo.compareTo(o2.TrainNo);
                }
            });
            i.NTrainsOnline.sort(new Comparator<NormalTrain>() {
                @Override
                public int compare(NormalTrain o1, NormalTrain o2) {
                    return o1.TrainNo.compareTo(o2.TrainNo);
                }
            });
            int cnt=1;
            for (KoyaTrain j : i.KTrainsOnline) {
                System.out.printf("[%d] %s: %s [1A]%.2f:%d [2A]%.2f:%d\n",cnt,j.TrainNo,j.LineNo,
                        j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1]);
                cnt++;
            }
            for (GatimaanTrain j : i.GTrainsOnline) {
                System.out.printf("[%d] %s: %s [SC]%.2f:%d [HC]%.2f:%d [SB]%.2f:%d\n",
                        cnt,j.TrainNo,j.LineNo,
                        j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
                cnt++;
            }
            for (NormalTrain j : i.NTrainsOnline) {
                System.out.printf("[%d] %s: %s [CC]%.2f:%d [SB]%.2f:%d [GG]%.2f:%d\n",
                        cnt,j.TrainNo,j.LineNo,
                        j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
                cnt++;
            }
            if(cnt==1) System.out.println("No Trains");
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }
    }
    public void SortAllTrain(){
        KoyaTrain.koyaTrains.sort(new Comparator<KoyaTrain>() {
            @Override
            public int compare(KoyaTrain o1, KoyaTrain o2) {
                return o1.TrainNo.compareTo(o2.TrainNo);
            }
        });
        GatimaanTrain.gatimaanTrains.sort(new Comparator<GatimaanTrain>() {
            @Override
            public int compare(GatimaanTrain o1, GatimaanTrain o2) {
                return o1.TrainNo.compareTo(o2.TrainNo);
            }
        });
        NormalTrain.normalTrains.sort(new Comparator<NormalTrain>() {
            @Override
            public int compare(NormalTrain o1, NormalTrain o2) {
                return o1.TrainNo.compareTo(o2.TrainNo);
            }
        });
        int cnt=1;
        for (KoyaTrain j : KoyaTrain.koyaTrains) {
            System.out.printf("[%d] %s: %s [1A]%.2f:%d [2A]%.2f:%d\n",cnt,j.TrainNo,j.LineNo,
                    j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1]);
            cnt++;
        }
        for (GatimaanTrain j : GatimaanTrain.gatimaanTrains) {
            System.out.printf("[%d] %s: %s [SC]%.2f:%d [HC]%.2f:%d [SB]%.2f:%d\n",
                    cnt,j.TrainNo,j.LineNo,
                    j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
            cnt++;
        }
        for (NormalTrain j : NormalTrain.normalTrains) {
            System.out.printf("[%d] %s: %s [CC]%.2f:%d [SB]%.2f:%d [GG]%.2f:%d\n",
                    cnt,j.TrainNo,j.LineNo,
                    j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
            cnt++;
        }
        if(cnt==1) System.out.println("No Trains");
    }
    
    public ListTrain(String[] s){
        try{
            if(s.length>2){
                System.out.println("Arguments illegal");
                return;
            }
            else if(s.length==2){
                for (Line i : Line.lines) {
                    if (i.lineNo.equals(s[1])) {
                        SortTrainOnline(i);
                        return;
                    }
                }
                System.out.println("Line does not exist");
                return;
            }
            else SortAllTrain();
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }
    }
}
