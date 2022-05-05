import java.util.Scanner;

public class Test {
    static boolean sudo_status=false;

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        String argStr;
        try{
            while (true) {
                argStr = in.nextLine();
                String[] arr1=argStr.split(" ");
                if(sudo_status){//超级管理员模式
                    try{
                        switch (arr1[0]){
                            case "QUIT":
                                System.out.println("----- Good Bye! -----");
                                return;
                            case "addUser":
                                new AddUser(arr1);
                                break;
                            case "TunakTunakTun":
                                System.out.println("WanNiBa");
                                break;
                            case "NutKanutKanut":
                                sudo_status=false;
                                System.out.println("DaDaDa");
                                break;
                            case "addLine":
                                new AddLine(arr1);
                                break;
                            case "delLine":
                                new DelLine(arr1);
                                break;
                            case "addStation":
                                new AddStation(arr1);
                                break;
                            case "delStation":
                                new DelStation(arr1);
                                break;
                            case "lineInfo":
                                new LineInfo(arr1);
                                break;
                            case "listLine":
                                new ListLine(arr1);
                                break;
                            case "addTrain":
                                new AddTrain(arr1);
                                break;
                            case "delTrain":
                                new DelTrain(arr1);
                                break;
                            case "listTrain":
                                new ListTrain(arr1);
                                break;
                            case "login":
                                new Login(arr1);
                                break;
                            case "logout":
                                new Logout(arr1);
                                break;
                            case "buyTicket":
                                new BuyTicket(arr1);
                                break;
                            case "listOrder":
                                new ListOrder(arr1);
                                break;
                            default:
                                System.out.println("Command does not exist");
                                break;
                        }
                    }
                    catch (Exception e ){
                        System.out.println("Arguments illegal");
                    }
                }


                else{
                    try{
                        switch (arr1[0]){
                            case "QUIT":
                                System.out.println("----- Good Bye! -----");
                                return;
                            case "addUser":
                                new AddUser(arr1);
                                break;
                            case "TunakTunakTun":
                                System.out.println("DuluDulu");
                                sudo_status=true;
                                break;
                            case "NutKanutKanut":
                                System.out.println("WanNiBa");
                                break;
                            case "lineInfo":
                                new LineInfo(arr1);
                                break;
                            case "listLine":
                                new ListLine(arr1);
                                break;
                            case "checkTicket":
                                new CheckTicket(arr1);
                                break;
                            case "listTrain":
                                new ListTrain(arr1);
                                break;
                            case "login":
                                new Login(arr1);
                                break;
                            case "logout":
                                new Logout(arr1);
                                break;
                            case "buyTicket":
                                new BuyTicket(arr1);
                                break;
                            case "listOrder":
                                new ListOrder(arr1);
                                break;
                            default:
                                System.out.println("Command does not exist");
                                break;
                        }
                    }
                    catch (Exception e){
                        System.out.println("Arguments illegal");
                    }

                }

            }
        }
        catch (Exception e){
            System.out.println("Unknown error");
        }




    }
}
