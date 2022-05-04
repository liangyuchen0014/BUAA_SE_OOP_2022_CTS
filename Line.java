import java.util.*;

public class Line {
    static ArrayList<Line> lines= new ArrayList<>();
    String lineNo;
    int numOfTrain=0;
    int capacity;
    ArrayList<NormalTrain> NTrainsOnline=new ArrayList<>();
    ArrayList<GatimaanTrain> GTrainsOnline=new ArrayList<>();
    ArrayList<KoyaTrain> KTrainsOnline=new ArrayList<>();
    Set<Station> stations=new TreeSet<>(new Comparator<Station>() {
        @Override
        public int compare(Station o1, Station o2) {
            int num = o1.getKm() - o2.getKm();
            if (num == 0) return o1.getNamest().compareTo(o2.getNamest());
            else return num;
        }
    });
    int maxDist=0;

    @Override
    public String toString() {
       String tmp= lineNo + ' ' + numOfTrain + '/'+ capacity + ' ' ;
        for (Station i :
                stations) {
            tmp += i + " ";
        }
        return tmp;
    }
}
