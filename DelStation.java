public class DelStation {
    public DelStation(String[] s) {
        try{
            if(s.length!=3) {
                System.out.println("Arguments illegal");
                return;
            }
            String thisLineNo=s[1];
            String thisNameSt=s[2];
            for (Line i:Line.lines) {
                if(thisLineNo.equals(i.lineNo)){//从line i 里面删除
                    for (Station j:i.stations)
                        if(thisNameSt.equals(j.namest)){
                            i.stations.remove(j);
                            System.out.println("Delete Station success");
                            return;
                        }
                    System.out.println("Station does not exist");
                    return;
                }
            }//线路编号必须存在

            System.out.println("Line does not exist");
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }


    }
}
