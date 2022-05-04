import java.util.HashSet;
import java.util.Set;

public class User {
    static Set<User> myUser=new HashSet<User>();

    private String name;
    private char gender;
    private long id;
    public User(String name,char gender,long id){
        super();
        this.name=name;
        this.gender=gender;
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
}
