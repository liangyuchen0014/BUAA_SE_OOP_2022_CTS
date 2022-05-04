public class DelLine {
    public DelLine(String[] s){
        try{
            if(s.length!=2) {
                System.out.println("Arguments illegal");
                return;
            }
            String thisLineNo=s[1];
            for (Line i:Line.lines) {
                if(thisLineNo.equals(i.lineNo)){
                    Line.lines.remove(i);
                    System.out.println("Del Line success");
                    return;
                }
            }
            System.out.println("Line does not exist");
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }
    }
}
