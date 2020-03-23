package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 无序列表标记
 * @author Conan
 *
 */
public class UnOrderMark extends BaseMark {
    
    /**
     * 向无序列表里添加文本
     * @param line
     */
    public void put(String line) {
        this.put(new TextMark(line));
    }

    @Override
    public void mark() {
        StringBuilder translate = new StringBuilder();
        String[] inclusion = this.markInclusions().split(String.valueOf(MarkDown.NEXT));  // 解析内含标记
        
        for (int i = 0; i < inclusion.length; i ++) {
            if (MarkUtil.isEmpty(inclusion[i])) {
                continue;  // 空行跳过
            }
            translate.append(MarkDown.ASTER  // 星号 
                    + MarkDown.SPACE  // 空格
                    + inclusion[i]);  // 文本内容
        }
        translate.toString();
    }
    
    /**
     * 标记内含标记
     * @return
     */
    @Override
    public String markInclusions() {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < this.inclusions.size(); i ++) {
            if (i == 0) {
                result.append(inclusions.get(i).translate());  // 第一个标记不加换行符
            } else {
                result.append(MarkDown.NEXT + inclusions.get(i).translate());  // 不是第一个标记前面加换行符
            }
        }
        return result.toString();
    }

}
