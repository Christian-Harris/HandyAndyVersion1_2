package user;

/**
 *
 * @author Christian Harris
 */
public enum UserType {
    USER (0, "User"),
    ADMIN (1, "Admin");
    
    private final int code;
    private final String name;
    
    UserType(int code, String name){
        this.code = code;
        this.name = name;
    }
    
    public int getCode(){
        return this.code;
    }
    
    public String getName(){
        return this.name;
    }  
}
