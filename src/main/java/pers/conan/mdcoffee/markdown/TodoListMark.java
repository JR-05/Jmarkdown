package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.exception.DisablePutException;
import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 待办列表标记
 * @author Conan
 */
public class TodoListMark extends BaseMark {

    @Override
    public void mark() {
        /*
         * 待办列表标记在标记时，
         * 先解析内含标记，
         * 然后在解析出来的每一行文本前加上'- [ ] '字符
         */
        String strInclusion = this.markInclusions();  // 获取标记后的内含标记文本内容
        String[] markInclusions = strInclusion.split(String.valueOf(MarkDown.NEXT));  // 获取标记后的内含标记文本内容拆分出来的字符串数组
        
        StringBuilder quotation = new StringBuilder();
        for (int i = 0; i < markInclusions.length; i ++) {
            if (MarkUtil.isEmpty(markInclusions[i])) {  // 标记后的文本内容是空的话
                continue;  // 继续下一次循环
            }
            if (i == 0) {
                quotation.append("- [ ] " + markInclusions[i]);
            } else {
                quotation.append(MarkDown.NEXT + "- [ ] " + markInclusions[i]);
            }
        }
        
        this.translated = quotation.toString();

    }
    
    /**
     * 标记内含标记
     * @return
     */
    @Override
    public String markInclusions() {
        if (MarkUtil.isEmpty(this.inclusions)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.inclusions.size(); i ++) {
            if (i == 0) {
                result.append(inclusions.get(i).translate());  // 第一个标记不加换行符
            } else {
                result.append(MarkDown.NEXT + inclusions.get(i).translate());  // 不是第一个标记前面加换行符
            }
        }
        return result.toString();
    }
    
    /**
     * 添加内含标记
     * @param mark
     * @throws DisablePutException 
     */
    @Override
    public void put(BaseMark inclusion) throws DisablePutException {
        if (inclusion instanceof QuotationMark) {  // 不能放入引用标记
            throw new DisablePutException();
        }
        
        if (inclusion instanceof OrderMark) {  // 不能放入有序列表标记
            throw new DisablePutException();
        }
        
        if (inclusion instanceof UnOrderMark) {  // 不能放入无序列表标记
            throw new DisablePutException();
        }
        
        if (inclusion instanceof TableMark) {  // 不能放入表格标记
            throw new DisablePutException();
        }
        
        if (inclusion instanceof CellMark) {  // 不能放入单元格标记
            throw new DisablePutException();
        }
        
        this.inclusions.add(inclusion);
    }

}
