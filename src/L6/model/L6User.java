package L6.model;

import java.util.List;

public class L6User {
    private String user;
    private String pass;
    private String name;
    private String mail;
    private List<L6Post> posts;

    public L6User(String user, String pass, String name, String mail) {
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

    public List<L6Post> getPosts() {
        return posts;
    }

    public void addPost(L6Post post) {
        posts.add(post);
    }

    public boolean checkPassword(String password) {
        return this.pass.equals(pass);
    }
}
