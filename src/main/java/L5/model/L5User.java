package L5.model;

import java.util.List;

public class L5User {
    private String user;
    private String pass;
    private String name;
    private String mail;
    private List<L5Post> posts;

    public L5User(String user, String pass, String name, String mail) {
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

    public List<L5Post> getPosts() {
        return posts;
    }

    public void addPost(L5Post post) {
        posts.add(post);
    }

    public boolean checkPassword(String password) {
        return this.pass.equals(pass);
    }
}
