package pers.conan.mdcoffee.util;

import java.util.Collection;

public class MarkUtil {
    
    /**
     * 判断对象是否为空
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
