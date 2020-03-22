package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMark implements Markable {
    
    /**
     * 标记类型
     */
    protected int type;
    
    /**
     * 标记内容
     */
    protected String text;
    
    /**
     * 转换后的内容
     */
    protected String translated;
    
    
    /**
     * 下一个标记
     */
    protected BaseMark nextMark;
    
    /**
     * 内含标记集合
     */
    protected List<BaseMark> marks;

    public abstract void mark();

    public abstract String translate();

    /**
     * 添加下一个标记
     * @param mark
     */
    public void append(BaseMark mark) {
        if (this.nextMark != null) {  // 没有下一个标记
            this.nextMark = mark;
        } else {  // 有下一个标记
            this.nextMark.append(mark);
        }
    }

    /**
     * 添加内含标记
     * @param mark
     */
    public void put(BaseMark mark) {
        if (this.marks == null) {
            this.marks = new ArrayList<BaseMark>();
        }
        this.marks.add(mark);
    }
    
    /**
     * 构造方法
     */
    public BaseMark(String text) {
        this.text = text;
    }
    
    /**
     * 构造方法
     */
    public BaseMark(BaseMark mark) {
        this.nextMark = mark;
    }
    
    /**
     * 构造方法
     */
    public BaseMark() {
    }

}
