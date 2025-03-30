package main.najah.code;

public class UserService {
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "1234".equals(password);
    }
}
