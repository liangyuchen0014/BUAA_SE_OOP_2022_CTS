public class AddUser {

    public static boolean name_legal(String s){
        for(int i=0;i<s.length();i++) {
            if (!Character.isLowerCase(s.charAt(i)) && !Character.isUpperCase(s.charAt(i)) && s.charAt(i) != '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean id_legal(String s){
        if(s.length()!=12)
            return false;
        long id=Long.parseLong(s);
        if(id%10>2||((id%10000)/10>100)||((id/10000)%10000>460)||((id/10000)%10000<20)||(id/100000000)>1237||(id/100000000)==0)
            return false;
        return true;
    }

    public static boolean id_exist(User user){
        for(User i: User.myUser)
            if(i.equals(user))
                return true;
        return false;
    }

    public AddUser(String[] s){
        if(s.length!=4){
            System.out.println("Arguments illegal");

        }
        else if(!name_legal(s[1])){
            System.out.println("Name illegal");

        }
        else if(s[2].charAt(0)!='F'&&s[2].charAt(0)!='M'&&s[2].charAt(0)!='O') {
            System.out.println("Sex illegal");
        }
        else if(!id_legal(s[3])){
            System.out.println("Aadhaar number illegal");
        }
        else {
            User newUser= new User(s[1],s[2].charAt(0),Long.parseLong(s[3]));
            if(id_exist(newUser)){
                System.out.println("Aadhaar number exist");
            }
            else {
                User.myUser.add(newUser);
                System.out.println(newUser);
            }
        }
    }
}
