package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.exception.DisablePutException;
import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 待办事项标记
 * @author Conan
 */
public class TodoMark extends BaseMark {
    
    /**
     * Check指示符
     */
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public TodoMark(String text, boolean isChecked) {
        super(text);
        this.isChecked = isChecked;
    }
    
    public TodoMark(String text) {
        super(text);
    }
    
    public TodoMark() {
        super();
    }

    @Override
    public void mark() {
        if (MarkUtil.isEmpty(this.text) == false) {
            this.translated = " - [" + (this.isChecked ? "x] " : " ] ") + this.text;
            return;
            // 优先标记文本
        }
        
        this.translated = this.markInclusions();  // 完成标记
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
                result.append(MarkDown.SPACE + inclusions.get(i).translate());  // 不是第一个标记前面加空格符
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
    
    /**
     * 附着下一个标记
     * @param mark
     */
    @Override
    public void append(BaseMark next) {
        // 待办事项没有下一个标记
    }

}
