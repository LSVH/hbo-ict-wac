package L5.model;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

public class L5BlogService {
    private ArrayList<L5User> users = new ArrayList<L5User>();
    private ArrayList<L5Post> posts = new ArrayList<L5Post>();

    public void addPostForUser(String subject, String text, L5User user) throws IllegalArgumentException {
        if (subject != null || "".equals(subject) || text != null || "".equals(text)) {
            throw new IllegalArgumentException("Unable to continue with empty argument");
        } else {
            this.posts.add(new L5Post(subject, text));
        }
    }

    public boolean confirmPassword(String pass, String passConfirm) {
        return pass.equals(passConfirm);
    }

    public boolean registerUser(String user, String name, String mail, String pass) {
        L5User u = searchUser(user);
        if (u == null) {
            L5User newUser = new L5User(user, pass, name, mail);
            this.users.add(newUser);
        }
        return u == null;
    }

    public L5User searchUser(String user) {
        for (L5User u : this.users) {
            if (u.getUser().equals(user)) {
                return u;
            }
        }
        return null;
    }

    public L5User loginUser(String user, String pass) {
        L5User u = searchUser(user);
        return u != null ? u.checkPassword(pass) ? u : null : null;
    }

    public L5User getLoggedInUser(HttpServletRequest request) throws ServletException, IOException {
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

        L5User u = null;
        if (!("".equals(user) || "".equals(pass))) {
            u = loginUser(user, pass);
        }
        return u;
    }
}