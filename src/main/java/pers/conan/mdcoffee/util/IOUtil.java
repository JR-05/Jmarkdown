package pers.conan.mdcoffee.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * IO流工具类
 */
public class IOUtil {
    /**
     * 关闭IO流
     */
    public static void close (Closeable[] args) {
        for (int i = 0; i < args.length; i ++) {
            if (args[i] != null) {
                try {
                    args[i].close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
