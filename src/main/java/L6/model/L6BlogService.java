package L6.model;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L6BlogService {
    private ArrayList<L6User> users = new ArrayList<L6User>();

    public List<L6Post> getPosts() {
        ArrayList<L6Post> dePosts = new ArrayList<L6Post>();
        for(L6User us : users){
            dePosts.addAll(us.getPosts());
        }

        return Collections.unmodifiableList(dePosts);
    }

    public void addPostForUser(String subject, String text, L6User user) throws IllegalArgumentException {
        if (subject == null || "".equals(subject) || text == null || "".equals(text) || user == null) {
            throw new IllegalArgumentException("Unable to continue with empty argument");
        } else {
            user.addPost(new L6Post(subject, text));
        }
    }

    public boolean confirmPassword(String pass, String passConfirm) {
        return pass.equals(passConfirm);
    }

    public boolean registerUser(String user, String name, String mail, String pass) {
        L6User u = searchUser(user);
        if (u == null) {
            L6User newUser = new L6User(user, pass, name, mail);
            this.users.add(newUser);
        }
        return u == null;
    }

    public L6User searchUser(String user) {
        for (L6User u : this.users) {
            if (u.getUser().equals(user)) {
                return u;
            }
        }
        return null;
    }

    public L6User loginUser(String user, String pass) {
        L6User u = searchUser(user);
        return u != null ? u.checkPassword(pass) ? u : null : null;
    }

    public L6User getLoggedInUser(HttpServletRequest request) throws ServletException, IOException {
        // Prepare variables to store the user
        String user = "";
        String pass = "";

        // Iterate through all cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("user".equals(c.getName())) {
                    user = c.getValue();
                }
                if ("pass".equals(c.getName())) {
                    pass = c.getValue();
                }
            }
        }

        L6User u = null;
        if (!("".equals(user) || "".equals(pass))) {
            u = loginUser(user, pass);
        }
        return u;
    }
}