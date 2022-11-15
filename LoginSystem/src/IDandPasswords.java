import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPasswords() {
        loginInfo.put("Bro", "pizza");
        loginInfo.put("Brometheus", "PASSWORD");
        loginInfo.put("Chris", "abc123");
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
