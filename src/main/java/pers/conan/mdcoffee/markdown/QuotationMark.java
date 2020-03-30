package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.exception.DisablePutException;
import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 引用标记
 * @author Conan
 *
 */
public class QuotationMark extends BaseMark {
    
    /**
     * 给引用标记添加一行内容
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
        
        /*
         * 引用标记在标记时，
         * 先解析内含标记，
         * 然后在解析出来的每一行文本前加上'> '字符
         */
        String strInclusion = this.markInclusions(MarkDown.NEXT);  // 获取标记后的内含标记文本内容
        String[] markInclusions = strInclusion.split(String.valueOf(MarkDown.NEXT));  // 获取标记后的内含标记文本内容拆分出来的字符串数组
        
        StringBuilder quotation = new StringBuilder();
        for (int i = 0; i < markInclusions.length; i ++) {
            if (MarkUtil.isEmpty(markInclusions[i])) {  // 标记后的文本内容是空的话
                continue;  // 继续下一次循环
            }
            if (i == 0) {
                quotation.append(MarkDown.LEFT_AB + MarkDown.SPACE + markInclusions[i]);
            } else {
                quotation.append(MarkDown.NEXT + MarkDown.LEFT_AB + MarkDown.SPACE + markInclusions[i]);
            }
        }
        
        this.translated = quotation.toString();
    }

}
