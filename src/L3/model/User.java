package L3.model;

public class User {
    private String user;
    private String pass;
    private String mail;
    private String name;

    public User(String user, String pass, String mail, String name) {
        this.user = user;
        this.pass = pass;
        this.mail = mail;
        this.name = name;
    }



    public String getUser() {
        return user;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String password) {
        return this.pass.equals(pass);
    }
}
