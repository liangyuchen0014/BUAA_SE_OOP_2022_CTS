public class AddStation {
    public AddStation(String[] s) {
        if(s.length!=4) {
            System.out.println("Arguments illegal");
            return;
        }
        String thisLineNo=s[1];
        String thisNameSt=s[2];
        int thisKm=Integer.parseInt(s[3]);

        for (Line i:Line.lines) {
            if(thisLineNo.equals(i.lineNo)){//加到line i 里面
                Station tmps;
                try {
                    tmps = new Station(thisNameSt, thisKm);
                } catch (NumberFormatException e) {
                    System.out.println("Arguments illegal");
                    return;
                }//里程不是int类型
                if (i.stations.contains(tmps)) {
                    System.out.println("Station duplicate");
                    return;
                }//站名重复
                i.stations.add(tmps);
                System.out.println("Add Station success");
                return;
            }
        }//线路编号必须存在

        System.out.println("Line does not exist");
    }
}
