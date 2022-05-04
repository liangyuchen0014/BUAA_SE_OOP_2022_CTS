import java.util.Comparator;

public class ListLine {
    public ListLine(String[] s){
        if(s.length!=1) {
            System.out.println("Arguments illegal");
            return;
        }
        Line.lines.sort(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.lineNo.compareTo(o2.lineNo);
            }
        });
        int cnt=1;
        for (Line i : Line.lines) {
            System.out.println("["+cnt+"] "+i);
            cnt++;
        }
        if(Line.lines.isEmpty())
            System.out.println("No Lines");
    }
}
