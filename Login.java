public class Login {
    static boolean status=false;
    static User loggedUser;
    public Login(String[] s){
        if(s.length!=3){
            System.out.println("Arguments illegal");
            return;
        }
        if(status){
            System.out.println("You have logged in");
            return;
        }
        User iUser=new User(s[2],Long.parseLong(s[1]));
        if(!AddUser.id_exist(iUser) || !AddUser.id_legal(s[1])){//卡号不合法或不存在
            System.out.println("User does not exist");
            return;
        }
        if(User.wrongName(iUser)){
            System.out.println("Wrong name");
            return;
        }
        status=true;
        loggedUser=User.FindUser(iUser);
        System.out.println("Login success");
    }
}
