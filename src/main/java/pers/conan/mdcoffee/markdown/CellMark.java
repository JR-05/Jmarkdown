package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;

import pers.conan.mdcoffee.exception.DisablePutException;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 单元格标记
 * @author Administrator
 *
 */
public class CellMark extends BaseMark {
    
    public CellMark(String text) {
        super(text);
    }

    @Override
    public void mark() {
        if (MarkUtil.isEmpty(this.text) == false) {  // 文本内容优先标记
            this.translated = this.text;
            return;
        }
        
        markInclusions();
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
        
        if (this.inclusions == null) {
            this.inclusions = new ArrayList<BaseMark>();
        }
        this.inclusions.add(inclusion);
    }

}
