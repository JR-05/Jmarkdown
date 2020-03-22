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

    @Override
    public void mark() {
        if (this.marks != null) {  // 有内含标记集合
            
        } else {  // 无内含标记集合
            switch (this.type) {
                case Type.BOLD :
                    this.text = MarkDown.BOLD + this.text + MarkDown.BOLD;
                    break;
                case Type.ITALICS :
                    this.text = MarkDown.ITATLICS + this.text + MarkDown.ITATLICS;
                    break;
                case Type.BOLD_ITALICS :
                    this.text = MarkDown.ITATLICS + this.text + MarkDown.ITATLICS;
                    break;
            }
        }
    }

    @Override
    public String translate() {
        // TODO Auto-generated method stub
        return null;
    }

}
