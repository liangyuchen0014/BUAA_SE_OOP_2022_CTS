public class AddTrain {
    public boolean TrainNoIllegal(String s){//列车号需符合规范，
        if(s.length()!=5||
            !(s.charAt(0)=='G'||s.charAt(0)=='K'||s.charAt(0)=='0')||
            !Character.isDigit(s.charAt(1))||
            !Character.isDigit(s.charAt(2))||
            !Character.isDigit(s.charAt(3))||
            !Character.isDigit(s.charAt(4)))
            return true;
        else return false;
    }
    public AddTrain(String[] s){
        if(TrainNoIllegal(s[1])){
            System.out.println("Train serial illegal");
            return;
        }
        //添加列车时车次号不得重复

        switch (s[1].charAt(0)){
            case '0':
                if(s.length!=9){
                    System.out.println("Arguments illegal");
                    return;
                }
                NormalTrain.addTrain(s);
                break;
            case 'G':
                if(s.length!=9){
                    System.out.println("Arguments illegal");
                    return;
                }
                GatimaanTrain.addTrain(s);
                break;
            case 'K':
                if(s.length!=7){
                    System.out.println("Arguments illegal");
                    return;
                }
                KoyaTrain.addTrain(s);
                break;

        }
    }
}
