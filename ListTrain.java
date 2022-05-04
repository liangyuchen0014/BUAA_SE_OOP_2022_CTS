import java.util.Collections;
import java.util.Comparator;

public class ListTrain {

    public void SortTrainOnline(Line i){
        try{
            i.TrainsOnline.sort(new Comparator<Train>() {
                @Override
                public int compare(Train o1, Train o2) {
                    char t1=o1.TrainNo.charAt(0);
                    char t2=o2.TrainNo.charAt(0);
                    if(t1==t2)  return o1.TrainNo.compareTo(o2.TrainNo);
                    else switch (t1){
                        case 'K':return -1;
                        case '0':return 1;
                        case 'G':
                            switch (t2){
                                case 'K':return 1;
                                case '0':return -1;
                            }
                    }
                    System.out.println("compare函数出错！");
                    return 0;
                }
            });

            int cnt=1;
            for (Train j : i.TrainsOnline)
                switch (j.Type){
                    case 'K':
                        System.out.printf("[%d] %s: %s [1A]%.2f:%d [2A]%.2f:%d\n",cnt,j.TrainNo,j.LineNo,
                            j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1]);
                        cnt++;
                        break;
                    case 'G':
                        System.out.printf("[%d] %s: %s [SC]%.2f:%d [HC]%.2f:%d [SB]%.2f:%d\n",
                                cnt,j.TrainNo,j.LineNo,
                                j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
                        cnt++;
                        break;
                    case '0':
                        System.out.printf("[%d] %s: %s [CC]%.2f:%d [SB]%.2f:%d [GG]%.2f:%d\n",
                                cnt,j.TrainNo,j.LineNo,
                                j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
                        cnt++;
                        break;
                }
            if(cnt==1) System.out.println("No Trains");
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }
    }
    public void SortAllTrain(){
        Train.Trains.sort(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                char t1=o1.TrainNo.charAt(0);
                char t2=o2.TrainNo.charAt(0);
                if(t1==t2)  return o1.TrainNo.compareTo(o2.TrainNo);
                else switch (t1){
                    case 'K':return -1;
                    case '0':return 1;
                    case 'G':
                        switch (t2){
                            case 'K':return 1;
                            case '0':return -1;
                        }
                }
                System.out.println("compare函数出错！");
                return 0;
            }
        });

        int cnt=1;
        for(Train j:Train.Trains){
            switch (j.Type){
                case 'K':
                    System.out.printf("[%d] %s: %s [1A]%.2f:%d [2A]%.2f:%d\n",cnt,j.TrainNo,j.LineNo,
                            j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1]);
                    cnt++;
                    break;
                case 'G':
                    System.out.printf("[%d] %s: %s [SC]%.2f:%d [HC]%.2f:%d [SB]%.2f:%d\n",
                            cnt,j.TrainNo,j.LineNo,
                            j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
                    cnt++;
                    break;
                case '0':
                    System.out.printf("[%d] %s: %s [CC]%.2f:%d [SB]%.2f:%d [GG]%.2f:%d\n",
                            cnt,j.TrainNo,j.LineNo,
                            j.price[0],j.vacancySeat[0],j.price[1],j.vacancySeat[1],j.price[2],j.vacancySeat[2]);
                    cnt++;
                    break;
            }
        }
        if(cnt==1) System.out.println("No Trains");
    }
    public ListTrain(String[] s){
        try{
            if(s.length>2){
                System.out.println("Arguments illegal");
            }
            else if(s.length==2){
                for (Line i : Line.lines) {
                    if (i.lineNo.equals(s[1])) {
                        SortTrainOnline(i);
                        return;
                    }
                }
                System.out.println("Line does not exist");
            }
            else SortAllTrain();
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }
    }
}
