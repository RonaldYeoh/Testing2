public class Password{
    String password;
    
    public Password(String pwd) throws InvalidPasswordException{
        String errMsg = "";
        
        if(pwd == null || pwd.equals("")){
            errMsg = "Invalid password: password cannot be null or an empty string";
            throw new InvalidPasswordException(errMsg);
        }
        else{
            int countDigits = 0;
            int countLetters = 0;
            
            for(int i = 0; i<pwd.length();i++){
                char ch = pwd.charAt(i);
                if(Character.isDigit(ch)){
                    countDigits++;
                }
                else if(Character.isLetter(ch)){
                    countLetters++;
                }
            }
                int countAlphaNumeric = countDigits + countLetters;
                
                if(countDigits == 0)
                    errMsg += "Your password should have at least 1 digit.\n";
                if(countLetters == 0)
                    errMsg += "Your password should have at least 1 letter.\n";
                if(countAlphaNumeric < 7)
                    errMsg += countAlphaNumeric + "Your password should have at least 7 alpha-numeric characters.";
                if(!errMsg.equals(""))
                    throw new InvalidPasswordException(errMsg);
            }
            this.password = pwd;  
        }

          

    }
    
    
