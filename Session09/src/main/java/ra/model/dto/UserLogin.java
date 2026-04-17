package ra.model.dto;

public class UserLogin {
    private String username;
    private String password;
    private String savePass;

    public UserLogin() {
    }

    public UserLogin(String username, String password , String savePass) {
        this.username = username;
        this.password = password;
        this.savePass = savePass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSavePass() {
        return savePass;
    }

    public void setSavePass(String savePass) {
        this.savePass = savePass;
    }
}
