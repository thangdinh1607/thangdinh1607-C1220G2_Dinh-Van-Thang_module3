package model.bean;

public class Login {
    private String account;
    private String passwords;

    public Login() {
    }

    public Login(String account, String passwords) {
        this.account = account;
        this.passwords = passwords;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
}
