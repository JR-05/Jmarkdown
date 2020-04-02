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
        
        this.translated = this.markInclusions();

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
     * 添加待办事项标记
     * @param mark
     * @throws DisablePutException 
     */
    public void put(TodoMark todo) {
        this.inclusions.add(todo);
    }
    
    /**
     * 添加内含标记
     * @throws DisablePutException 
     */
    @Override
    public void put(BaseMark todo) throws DisablePutException {
        if (todo instanceof TodoMark == false) {
            throw new DisablePutException();
        }
        
        this.put((TodoMark)todo);
    }
    
    /**
     * 添加待办事项
     * @param text
     */
    public void put(String text) {
        this.inclusions.add(new TodoMark(text));
    }

}
