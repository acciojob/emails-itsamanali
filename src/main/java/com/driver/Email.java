package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){

        if(oldPassword.equals(password)){
            if(Authenticity(newPassword)){
                password = newPassword;
                System.out.println("Password changed successfully!");
            }
            else{
                System.out.println("The new password is not valid!");
            }
        }
        else{
            System.out.println("The given password does not match current password!");
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
    public boolean Authenticity(String newPassword){
        if(newPassword.length() < 8) return false;
        char arr [] = newPassword.toCharArray();
         boolean isCapital = false;
         boolean isSmall = false;
         boolean isSpecial = false;
         boolean isDigit = false;
         for(char ch : arr){
               if(isCapital == false && ch >= 'A' && ch <= 'Z'){
                 isCapital = true;
             } else if (isSmall == false && ch >= 'a' && ch <= 'z') {
                 isSmall = true;
             } else if (isDigit == false && ch >= '0' && ch <= '9') {
                 isDigit = true;
             }
             else {
                 isSpecial = true;
             }
         }
         return (isSmall && isDigit && isCapital && isSpecial);
    }
}
