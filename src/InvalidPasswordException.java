import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InvalidPasswordException extends Exception{
    public InvalidPasswordException(){
        super("Invalid Password Exception");
    }
    public InvalidPasswordException(String errMsg){
        super(errMsg);
    }
}