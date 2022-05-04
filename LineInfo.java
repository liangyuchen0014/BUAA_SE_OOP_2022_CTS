public class LineInfo {
    public LineInfo(String[] s){
        try{
            if(s.length!=2) {
                System.out.println("Arguments illegal");
                return;
            }
            String thisLineNo=s[1];
            for (Line i:Line.lines) {
                if(thisLineNo.equals(i.lineNo)){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("Line does not exist");
        }
        catch (Exception e){
            System.out.println("Unknown error");
            return;
        }

    }
}
