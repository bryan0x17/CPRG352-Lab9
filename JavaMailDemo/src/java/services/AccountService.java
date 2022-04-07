package services;

import dataaccess.UserDB;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

public class AccountService {
    
    public User login(String email, String password, String path) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);
                
                String to = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                
                GmailService.sendMail(to, subject, template, tags);
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public void resetPassword(String email, String path, String url) {
        String uuid = UUID.randomUUID().toString();
        UserDB userDB = new UserDB();
        String link = url + "?uuid=" + uuid;
        try {
            User user = userDB.get(email);
            if (user != null) {
                
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Reset password by {0}", email);
                
                String to = user.getEmail();
                String subject = "Notes App Reset Password";
                String template = path + "/emailtemplates/resetpassword.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstName());
                tags.put("lastname", user.getLastName());
                tags.put("date", (new java.util.Date()).toString());
                tags.put("link", link);
                
                GmailService.sendMail(to, subject, template, tags);
                
                //Add the uuid to the user database
                user.setResetPasswordUuid(uuid);
                userDB.update(user);
            }
            else {
                throw new Exception("No such user");
            }
        } catch (Exception e) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, "Unsuccesfull reset request by " + email, e);
        }
    }
}
