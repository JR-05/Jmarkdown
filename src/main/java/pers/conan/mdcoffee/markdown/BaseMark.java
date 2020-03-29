package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;
import java.util.List;

import pers.conan.mdcoffee.exception.DisablePutException;
import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.text.Type;

/**
 * 基础标记
 * 其他标记类型的父类
 * @author Conan
 */
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
    protected List<BaseMark> inclusions = new ArrayList<BaseMark>();

    public abstract void mark();

    /**
     * 标记内容转换输出
     * @return
     */
    public String translate() {
        this.mark();
        if (this.next != null) {
            return this.translated + MarkDown.NEXT + this.next.translate();
        }
        return this.translated;
    }
    
    /**
     * 标记内含标记
     * @return
     */
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
     * @throws DisablePutException 
     */
    public void put(BaseMark inclusion) throws DisablePutException {
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
