package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.text.Type;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 标题标记
 * @author Conan
 *
 */
public class TitleMark extends BaseMark {
    
    /**
     * 标题等级
     * 默认：一级
     */
    private int level = Type.TITLE_ONE;
    
    /**
     * 构造方法
     * @param text
     * @param level
     */
    public TitleMark(String text, int level) {
        super(text);
        this.level = level;
    }

    @Override
    public void mark() {
        if (MarkUtil.isEmpty(this.inclusions) == false) {  // 有内含标记集合
            switch (this.level) {  // 判断标题等级
            case Type.TITLE_ONE :  // 一级标题
                this.translated = MarkDown.TITLE_H1 + MarkDown.SPACE + this.text + this.markInclusions();
                break;
            case Type.TITLE_TWO :  // 二级标题
                this.translated = MarkDown.TITLE_H2 + MarkDown.SPACE + this.text + this.markInclusions();
                break;
            case Type.TITLE_THREE :  // 三级标题
                this.translated = MarkDown.TITLE_H3 + MarkDown.SPACE + this.text + this.markInclusions();
                break;
            case Type.TITLE_FOUR :  // 四级标题
                this.translated = MarkDown.TITLE_H4 + MarkDown.SPACE + this.text + this.markInclusions();
                break;
            case Type.TITLE_FIVE :  // 五级标题
                this.translated = MarkDown.TITLE_H5 + MarkDown.SPACE + this.text + this.markInclusions();
                break;
            case Type.TITLE_SIX :  // 六级标题
                this.translated = MarkDown.TITLE_H6 + MarkDown.SPACE + this.text + this.markInclusions();
                break;
            default :  // 默认
                this.translated = MarkDown.TITLE_H1 + MarkDown.SPACE + this.text + this.markInclusions();
                break; 
            }
        } else {  // 无内含标记集合
            switch (this.level) {  // 判断标题等级
                case Type.TITLE_ONE :  // 一级标题
                    this.translated = MarkDown.TITLE_H1 + MarkDown.SPACE + this.text;
                    break;
                case Type.TITLE_TWO :  // 二级标题
                    this.translated = MarkDown.TITLE_H2 + MarkDown.SPACE + this.text;
                    break;
                case Type.TITLE_THREE :  // 三级标题
                    this.translated = MarkDown.TITLE_H3 + MarkDown.SPACE + this.text;
                    break;
                case Type.TITLE_FOUR :  // 四级标题
                    this.translated = MarkDown.TITLE_H4 + MarkDown.SPACE + this.text;
                    break;
                case Type.TITLE_FIVE :  // 五级标题
                    this.translated = MarkDown.TITLE_H5 + MarkDown.SPACE + this.text;
                    break;
                case Type.TITLE_SIX :  // 六级标题
                    this.translated = MarkDown.TITLE_H6 + MarkDown.SPACE + this.text;
                    break;
                default :  // 默认
                    this.translated = MarkDown.TITLE_H1 + MarkDown.SPACE + this.text;
                    break; 
            }
        }
        
    }

}
