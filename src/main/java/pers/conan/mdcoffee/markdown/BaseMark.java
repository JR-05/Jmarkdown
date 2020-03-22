package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;
import java.util.List;

import pers.conan.mdcoffee.text.Type;

public abstract class BaseMark implements Markable, Cloneable {
    
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
    
    public abstract String markInclusions();

    /**
     * 附着下一个标记
     * @param mark
     */
    public void append(BaseMark next) {
        if (this.next == null) {  // 没有下一个标记
            try {
                this.next = (BaseMark) next.clone();
            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
        this.next.append(this);
    }
    
    /**
     * 构造方法
     */
    public BaseMark() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public BaseMark getNext() {
        return next;
    }

    public void setNext(BaseMark next) {
        this.next = next;
    }

}
