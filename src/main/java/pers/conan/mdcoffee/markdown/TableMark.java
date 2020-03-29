package pers.conan.mdcoffee.markdown;

import java.util.ArrayList;
import java.util.List;

import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 表格标记
 * @author Conan
 */
public class TableMark extends BaseMark {
    
    /**
     * 表头
     */
    private TableHeadMark head;
    
    /**
     * 表行
     */
    private List<TableRowMark> rows = new ArrayList<TableRowMark>();

    /**
     * 构造方法
     * @param head
     * @param rows
     */
    public TableMark(TableHeadMark head, List<TableRowMark> rows) {
        this.head = head;
        this.rows = rows;
    }
    
    /**
     * 构造方法
     */
    public TableMark() {
        
    }

    public TableHeadMark getHead() {
        return head;
    }

    public void setHead(TableHeadMark head) {
        this.head = head;
    }

    public List<TableRowMark> getRows() {
        return rows;
    }

    public void setRows(List<TableRowMark> rows) {
        this.rows = rows;
    }

    @Override
    public void mark() {
        StringBuilder translate = new StringBuilder("");
        
        if (MarkUtil.isEmpty(this.head)) {  // 表头为空
            this.head = new TableHeadMark();
        }
        translate.append(this.head.translate());  // 标记表头
        
        translate.append(String.valueOf(MarkDown.NEXT) + "| --- |");  // 分隔表头与表行
        
        if (MarkUtil.isEmpty(this.rows)) {  // 表行为空
            translate.append("| |");
        } else {  // 表行不为空
            for (int i = 0; i< this.rows.size(); i ++) {
                translate.append(String.valueOf(MarkDown.NEXT) + this.rows.get(i).translate());  // 逐行标记
            }
        }
        translate.append(String.valueOf(MarkDown.NEXT));  // 表格标记的结尾需要换行
        
        this.translated = translate.toString();  // 完成标记
    }

}
