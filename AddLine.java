public class AddLine {
   public AddLine(String[] s){
       try{
           if(s.length<=4||s.length%2==0) {
               System.out.println("Arguments illegal");
               return;
           }
           Line iline=new Line();
           iline.lineNo=s[1];
           try {
               iline.capacity=Integer.parseInt(s[2]);
               if(iline.capacity<=0){
                   System.out.println("Capacity illegal");
                   return;
               }
           } catch (NumberFormatException e) {
               System.out.println("Capacity illegal");
               return;
           }

           iline.capacity=Integer.parseInt(s[2]);
           for (Line i:Line.lines) {
               if(iline.lineNo.equals(i.lineNo)){
                   System.out.println("Line already exists");
                   return;
               }
           }//线路编号不得重复

           for(int i=1;2*i+3<=s.length;i++) {
               if (s[2 * i + 2] == null) {
                   System.out.println("Arguments illegal");
                   return;
               }//参数个数不是偶数

               Station tmps;
               try {
                   tmps = new Station(s[2 * i + 1], Integer.parseInt(s[2 * i + 2]));
               } catch (NumberFormatException e) {
                   System.out.println("Arguments illegal");
                   return;
               }//里程不是int类型

               if (iline.stations.contains(tmps)) {
                   System.out.println("Station duplicate");
                   return;
               }//站名重复

               iline.stations.add(tmps);
               if(iline.maxDist<tmps.km)iline.maxDist=tmps.km;
           }
           Line.lines.add(iline);
           System.out.println("Add Line success");
       }
       catch (Exception e){
           System.out.println("Unknown error");
       }

    }
}
