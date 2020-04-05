package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.Type;

/**
 * 删除线标记
 * @author Conan
 */
public class DeleteMark extends TextMark {
    
    /**
     * 构造方法
     * @param text
     */
    public DeleteMark(String text) {
        super(text, Type.DELETE);
    }
    
    public DeleteMark() {
    }
}
