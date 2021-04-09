package pers.conan.mdcoffee.util;

import pers.conan.mdcoffee.markdown.BaseMark;
import pers.conan.mdcoffee.markdown.ImageMark;
import pers.conan.mdcoffee.markdown.LinkMark;
import pers.conan.mdcoffee.markdown.TextMark;

import java.util.Collection;
import java.util.List;

public class MarkUtil {

    /**
     * 标签集合转换
     *
     * @param baseMarks
     * @return
     */
    public static String translate(List<BaseMark> baseMarks) {
        StringBuilder strTemp = new StringBuilder();

        for (BaseMark baseMark : baseMarks) {
            strTemp.append(baseMark.translate());

            // 文本标签、链接标签、图片标签不换行
            if (baseMark instanceof TextMark || baseMark instanceof LinkMark || baseMark instanceof ImageMark) {
                continue;
            }

            strTemp.append("\n");
        }

        return strTemp.toString();
    }

    /**
     * 判断对象是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        }
        return obj.toString().length() == 0;
    }

}
