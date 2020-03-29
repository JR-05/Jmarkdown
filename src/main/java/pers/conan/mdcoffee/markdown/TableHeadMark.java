package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;
import java.util.List;

import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 表头标记
 * @author Conan
 */
public class TableHeadMark extends BaseMark {
    
    /**
     * 表头单元格集合
     * 内部元素：单元格标记
     */
    private List<CellMark> header = new ArrayList<CellMark>();
    
    public List<CellMark> getHeader() {
        return header;
    }

    public void setHeader(List<CellMark> header) {
        this.header = header;
    }

    /**
     * 构造方法
     * @param text
     * @param header
     */
    public TableHeadMark(List<CellMark> header) {
        this.header = header;
    }

    /**
     * 构造方法
     */
    public TableHeadMark() {
        
    }

    @Override
    public void mark() {
        StringBuilder translate = new StringBuilder("| ");
        if (MarkUtil.isEmpty(this.header)) {  // 表头单元格集合为空
            translate.append(" |");
            this.translated = translate.toString();  // 完成标记
            return;
        }
        
        for (int i = 0; i < this.header.size(); i ++) {
            translate.append(this.header.get(i).translate() + " | ");  // 添加表头单元格
        }
        this.translated = translate.toString();  // 完成标记
        
    }
    
    /**
     * 添加单元格标记
     * @param cell
     */
    public void put(CellMark cell) {
        this.header.add(cell);
    }
    
    /**
     * 标记内容转换输出
     * @return
     * 表头标记没有下一个标记对象
     */
    @Override
    public String translate() {
        this.mark();
        /*if (this.next != null) {
            return this.translated + MarkDown.NEXT + this.next.translate();
        }*/
        return this.translated;
    }

}
