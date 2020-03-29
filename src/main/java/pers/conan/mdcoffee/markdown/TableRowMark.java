package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;
import java.util.List;

import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 表行标记
 * @author Conan
 */
public class TableRowMark extends BaseMark {
    
    /**
     * 表行单元格集合
     * 内部元素：单元格标记
     */
    private List<CellMark> row = new ArrayList<CellMark>();
    
    /**
     * 构造方法
     * @param row
     */
    public TableRowMark(List<CellMark> row) {
        this.row = row;
    }
    
    /**
     * 构造方法
     */
    public TableRowMark() {
        
    }

    public List<CellMark> getRow() {
        return row;
    }

    public void setRow(List<CellMark> row) {
        this.row = row;
    }

    @Override
    public void mark() {
        StringBuilder translate = new StringBuilder("| ");
        if (MarkUtil.isEmpty(this.row)) {  // 表行单元格集合为空
            translate.append(" |");
            this.translated = translate.toString();  // 完成标记
            return;
        }
        
        for (int i = 0; i < this.row.size(); i ++) {
            translate.append(this.row.get(i).translate() + " | ");  // 添加表头单元格
        }
        this.translated = translate.toString();  // 完成标记
    }
    
    /**
     * 标记内容转换输出
     * @return
     * 表行标记没有下一个标记对象
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
