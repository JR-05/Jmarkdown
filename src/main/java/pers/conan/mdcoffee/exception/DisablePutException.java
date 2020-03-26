package pers.conan.mdcoffee.exception;

public class DisablePutException extends Exception {

    /**
     * ID
     */
    private static final long serialVersionUID = 7673564348353792573L;
    
    /**
     * Message
     */
    private static String message = "This is an object that can not be put in the mark.";

    /**
     * 构造方法
     */
    public DisablePutException() {
        super(message);
    }
}
