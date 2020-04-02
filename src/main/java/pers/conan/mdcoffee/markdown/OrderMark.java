package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.exception.DisablePutException;
import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 有序列表标记
 * @author Conan
 *
 */
public class OrderMark extends BaseMark {
    
    /**
     * 构造方法
     */
    public OrderMark() {
        super();
    }

    /**
     * 向有序列表里添加文本
     * @param line
     */
    public void put(String line) {
        try {
            this.put(new TextMark(line));
        } catch (DisablePutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public void mark() {
        StringBuilder translate = new StringBuilder();
        String[] inclusion = this.markInclusions(MarkDown.NEXT).split(String.valueOf(MarkDown.NEXT));  // 解析内含标记
        
        int index = 0;  // 声明索引
        for (int i = 0; i < inclusion.length; i ++) {
            if (MarkUtil.isEmpty(inclusion[i])) {
                continue;  // 空行跳过
            }
            index ++;  // 索引自增
            if (index == 1) {
                translate.append(index 
                        + String.valueOf(MarkDown.POINT)
                        + String.valueOf(MarkDown.SPACE)
                        + inclusion[i]);  // 文本内容
            } else {
                translate.append(
                        String.valueOf(MarkDown.NEXT)
                        + index 
                        + String.valueOf(MarkDown.POINT)
                        + String.valueOf(MarkDown.SPACE)  // 空格
                        + inclusion[i]);  // 文本内容
            }
            
        }
        this.translated = translate.toString();

    }

}
