import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class User {
    static Set<User> myUser= new HashSet<>();
    LinkedList<Ticket> myTicket=new LinkedList<>();
    private String name;
    private char gender;
    private long id;
    public User(String name,char gender,long id){
        super();
        this.name=name;
        this.gender=gender;
        this.id=id;
    }
    public User(String name,long id){
        super();
        this.name=name;
        this.id=id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public char getGender(){
        return this.gender;
    }
    public void setGender(char gender){
        this.gender=gender;
    }
    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id=id;
    }
    @Override
    public String toString(){

        return "Name:"+name+'\n'+"Sex:"+gender+'\n'+"Aadhaar:"+String.format("%012d",id);
    }
    @Override
    public int hashCode(){

        return (int)(this.id%Integer.MAX_VALUE);
    }
    @Override
    public boolean equals(Object obj){
        return this.id==((User)obj).id;
    }
    public static User FindUser(User user){//查询是否存在用户与参数的name，id均相同
        for(User i: User.myUser)
            if(i.equals(user)&&i.getName().equals(user.getName()))//equals只检查id是否相等
                return i;
        return null;
    }
    public static boolean wrongName(User user){//查询是否存在用户，id与参数中的id相同，但是name参数的name不同
        for(User i: User.myUser)
            if(i.equals(user)&&!i.getName().equals(user.getName()))//equals只检查id是否相等
                return true;
            else if(i.equals(user)&&i.getName().equals(user.getName())) return false;
        return false;
    }
}
