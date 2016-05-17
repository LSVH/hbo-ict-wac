package L4.model;

public class User {
    private String user;
    private String pass;
    private String name;
    private String mail;

    public User(String user, String pass, String name, String mail) {
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.mail = mail;
    }



    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public boolean checkPassword(String password) {
        return this.pass.equals(pass);
    }
}
