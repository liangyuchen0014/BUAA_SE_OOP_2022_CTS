public class Logout {
    public Logout(String[] s){
        if(s.length!=1){
            System.out.println("Arguments illegal");
            return;
        }
        if(!Login.status){
            System.out.println("No user has logged in");
            return;
        }
        Login.status=false;
        System.out.println("Logout success");

    }
}
