package Messenger;

public class Client {

    public Client (String name, String email) {
        this.email = email;
        this.name = name;

    }
    private String email;
    private String name;

    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
}
