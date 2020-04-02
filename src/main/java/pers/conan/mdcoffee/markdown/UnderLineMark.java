package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.Type;

/**
 * 下划线标记
 * @author Conan
 */
public class UnderLineMark extends TextMark {
    
    /**
     * 构造方法
     * @param text
     */
    public UnderLineMark(String text) {
        super(text, Type.BOLD_ITALICS);
    }
    
    public UnderLineMark() {
    }
}
