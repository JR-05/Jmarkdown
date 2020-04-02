package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.Type;

/**
 * 斜体文本标记
 * @author Conan
 */
public class ItalicsMark extends TextMark {
    
    /**
     * 构造方法
     * @param text
     */
    public ItalicsMark(String text) {
        super(text, Type.ITALICS);
    }
    
    public ItalicsMark() {
    }
}
