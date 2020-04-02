package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.Type;

/**
 * 粗斜体标记
 * @author Conan
 */
public class BoldItalicsMark extends TextMark {
    
    /**
     * 构造方法
     * @param text
     */
    public BoldItalicsMark(String text) {
        super(text, Type.BOLD_ITALICS);
    }
    
    public BoldItalicsMark() {
    }
}
