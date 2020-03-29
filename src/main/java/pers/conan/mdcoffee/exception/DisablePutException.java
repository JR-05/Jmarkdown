package pers.conan.mdcoffee.exception;

/**
 * 自定义异常
 * 表示目标标记不能作为元素被添加到内含标记里去
 * @author Conan
 */
public class DisablePutException extends Exception {

    /**
     * ID
     */
    private static final long serialVersionUID = 7673564348353792573L;
    
    /**
     * Message
     */
    private static String message = "This is Mark Object that can not be put in the mark as inclusion element.";

    /**
     * 构造方法
     */
    public DisablePutException() {
        super(message);
    }
}
