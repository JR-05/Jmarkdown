package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.text.Type;

public class TextMark extends BaseMark {

    public TextMark(String text, int type) {
        super(text);
        this.type = type;
    }
    
    public TextMark(BaseMark mark, int type) {
        super(mark);
        this.type = type;
    }
    
    public TextMark(String text) {
        super();
        this.type = Type.OTHER;
    }
    
    public TextMark() {
        super();
    }

    @Override
    public void mark() {
        if (this.inclusions != null) {  // 有内含标记集合
            switch (this.type) {
                case Type.BOLD :
                    this.translated = MarkDown.BOLD + this.markInclusions() + MarkDown.BOLD;
                    break;
                case Type.ITALICS :
                    this.translated = MarkDown.ITATLICS + this.markInclusions() + MarkDown.ITATLICS;
                    break;
                case Type.BOLD_ITALICS :
                    this.translated = MarkDown.ITATLICS + this.markInclusions() + MarkDown.ITATLICS;
                    break;
                case Type.DELETE :
                    this.translated = MarkDown.DELETE + this.markInclusions() + MarkDown.DELETE;
                    break;
                case Type.UNDER_LINE :
                    this.translated = MarkDown.UNDER_LINE_1 + this.markInclusions() + MarkDown.UNDER_LINE_2;
                    break;
                default :  // 默认
                    this.translated = this.markInclusions();  // 不转换
                    break;
            }
        } else {  // 无内含标记集合
            switch (this.type) {
                case Type.BOLD :
                    this.translated = MarkDown.BOLD + this.text + MarkDown.BOLD;
                    break;
                case Type.ITALICS :
                    this.translated = MarkDown.ITATLICS + this.text + MarkDown.ITATLICS;
                    break;
                case Type.BOLD_ITALICS :
                    this.translated = MarkDown.ITATLICS + this.text + MarkDown.ITATLICS;
                    break;
                case Type.DELETE :
                    this.translated = MarkDown.DELETE + this.text + MarkDown.DELETE;
                    break;
                case Type.UNDER_LINE :
                    this.translated = MarkDown.UNDER_LINE_1 + this.text + MarkDown.UNDER_LINE_2;
                    break;
                default :  // 默认
                    this.translated = this.text;  // 不转换
                    break;
            }
        }
    }
    
    @Override
    public String markInclusions() {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < this.inclusions.size(); i ++) {
            if (i == 0) {
                result.append(inclusions.get(i).translate());  // 第一个标记不加空格
            } else {
                result.append(MarkDown.SPACE + inclusions.get(i).translate());  // 不是第一个标记前面加空格
            }
        }
        return result.toString();
    }

    @Override
    public String translate() {
        this.mark();
        if (this.next != null) {
            return this.translated + MarkDown.NEXT + this.next.translate();
        }
        return this.translated;
    }

    

}
