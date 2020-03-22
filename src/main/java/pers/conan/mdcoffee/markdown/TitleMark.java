package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.Type;

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
        // TODO Auto-generated method stub
        
    }

    @Override
    public String translate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String markInclusions() {
        // TODO Auto-generated method stub
        return null;
    }

}
