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
