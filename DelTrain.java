public class DelTrain {
    public boolean TrainNoIllegal(String s){//列车号需符合规范，
        try{
            if(s.length()!=5||
                    !(s.charAt(0)=='G'||s.charAt(0)=='K'||s.charAt(0)=='0')||
                    !Character.isDigit(s.charAt(1))||
                    !Character.isDigit(s.charAt(2))||
                    !Character.isDigit(s.charAt(3))||
                    !Character.isDigit(s.charAt(4)))
                return true;
            else return false;
        }
        catch (Exception e){
            System.out.println("Unknown error");
            return false;
        }
    }
    public DelTrain(String[] s){
        try{
            if(s.length!=2) {
                System.out.println("Arguments illegal");
                return;
            }
            if(TrainNoIllegal(s[1])){
                System.out.println("Train serial illegal");
                return;
            }//列车号需符合规范
            switch (s[1].charAt(0)){
                case '0':
                case 'G':
                case 'K':
                    Train.delTrain(s[1]);
                    break;
                default:
                    System.out.println("Train serial illegal");
            }
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }
    }
}
