package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;

/**
 * 代码标记
 * @author Conan
 *
 */
public class CodeMark extends BaseMark {
    
    /**
     * 代码语言
     */
    private String language = "";

    public CodeMark(String text, String language) {
        super(text);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public void mark() {
        this.translated = MarkDown.CODE_THREE + this.language + MarkDown.NEXT +
                this.text + MarkDown.CODE_THREE;

    }

}
