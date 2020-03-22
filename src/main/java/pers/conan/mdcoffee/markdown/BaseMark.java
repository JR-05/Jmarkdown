package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;
import java.util.List;

import pers.conan.mdcoffee.text.Type;

public abstract class BaseMark implements Markable {
    
    /**
     * 标记类型
     * 默认：其他
     */
    protected int type = Type.OTHER;
    
    /**
     * 标记内容
     */
    protected String text = "";
    
    /**
     * 转换后的内容
     */
    protected String translated = "";
    
    /**
     * 下一个标记
     */
    protected BaseMark next;
    
    /**
     * 内含标记集合
     */
    protected List<BaseMark> inclusions;

    public abstract void mark();

    public abstract String translate();

    /**
     * 添加下一个标记
     * @param mark
     */
    public void append(BaseMark next) {
        if (this.next != null) {  // 没有下一个标记
            this.next = next;
        } else {  // 有下一个标记
            this.next.append(next);
        }
    }

    /**
     * 添加内含标记
     * @param mark
     */
    public void put(BaseMark inclusion) {
        if (this.inclusions == null) {
            this.inclusions = new ArrayList<BaseMark>();
        }
        this.inclusions.add(inclusion);
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
        this.next = mark;
    }
    
    /**
     * 构造方法
     */
    public BaseMark() {
    }

}
