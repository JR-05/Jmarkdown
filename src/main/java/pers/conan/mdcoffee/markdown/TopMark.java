package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 顶层标记
 * @author Conan
 */
public class TopMark extends BaseMark {

    /**
     * 构造方法
     */
    public TopMark() {
        super();
    }

    public void mark() {
        // 顶层标记只解析内含标记集合
        if (MarkUtil.isEmpty(this.inclusions)) {  // 内含标记为空
            return;  // 解析结束
        }

        StringBuilder translate = new StringBuilder();
        for (int i = 0; i < this.inclusions.size(); i ++) {
            translate.append(this.inclusions.get(i).translate());
            translate.append(MarkDown.NEXT);  // 换行
        }
        this.translated = translate.substring(0, translate.length() - 2);
    }
}
