package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.Type;

/**
 * 粗体文本标记
 * @author Conan
 */
public class BoldMark extends TextMark {
    
    /**
     * 构造方法
     * @param text
     */
    public BoldMark(String text) {
        super(text, Type.BOLD);
    }
    
    public BoldMark() {
    }
}
