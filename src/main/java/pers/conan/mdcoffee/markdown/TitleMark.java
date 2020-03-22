package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.text.Type;

public class TitleMark extends BaseMark {
    
    /**
     * 标记类型
     */
    protected int type = Type.TITLE;

    /**
     * 标题等级
     */
    private int level;

    public TitleMark(String text, int level) {
        super(text);
        this.level = level;
    }

    @Override
    public void mark() {
        switch (this.level) {
            case Type.TITLE_ONE :  // 一级标题
                this.text = MarkDown.TITLE_H1 + MarkDown.SPACE + (this.nextMark == null ? "" : this.nextMark.translate());
                break;
            case Type.TITLE_TWO :  // 一级标题
                this.text = MarkDown.TITLE_H2 + MarkDown.SPACE + (this.nextMark == null ? "" : this.nextMark.translate());
                break;
            case Type.TITLE_THREE :  // 一级标题
                this.text = MarkDown.TITLE_H3 + MarkDown.SPACE + (this.nextMark == null ? "" : this.nextMark.translate());
                break;
            case Type.TITLE_FOUR :  // 一级标题
                this.text = MarkDown.TITLE_H4 + MarkDown.SPACE + (this.nextMark == null ? "" : this.nextMark.translate());
                break;
            case Type.TITLE_FIVE :  // 一级标题
                this.text = MarkDown.TITLE_H5 + MarkDown.SPACE + (this.nextMark == null ? "" : this.nextMark.translate());
                break;
            case Type.TITLE_SIX :  // 一级标题
                this.text = MarkDown.TITLE_H6 + MarkDown.SPACE + (this.nextMark == null ? "" : this.nextMark.translate());
                break;
            default :  // 默认(一级标题)
                this.text = MarkDown.TITLE_H1 + MarkDown.SPACE + (this.nextMark == null ? "" : this.nextMark.translate());
        }
    }

    @Override
    public String translate() {
        return this.text + MarkDown.NEXT + this.nextMark.translate();
    }

}
