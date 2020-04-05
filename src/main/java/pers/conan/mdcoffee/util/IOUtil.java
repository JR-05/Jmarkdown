package pers.conan.mdcoffee.util;

import pers.conan.mdcoffee.markdown.BaseMark;

import java.io.*;

/**
 * IO流工具类
 */
public class IOUtil {
    /**
     * 关闭IO流
     */
    public static void close (Closeable[] args) {
        for (int i = 0; i < args.length; i ++) {
            if (MarkUtil.isEmpty(args[i]) == false) {
                try {
                    args[i].close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 把标记后的文本内容输出到文件里
     * @param fileName : 文件名
     * @param mark : 标记
     * @param charsetName : 字符名称
     * @return Boolean true:写入成功, false:写入失败
     */
    public static boolean output(String fileName, BaseMark mark, String charsetName) {
        boolean result = true;  // 初始化返回值

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            fos = new FileOutputStream(fileName);
            osw = new OutputStreamWriter(fos, charsetName);
            bw = new BufferedWriter(bw);

            // 写入文件
            bw.write(mark.translate());

        } catch (IOException e) {
            e.printStackTrace();
            result = false;  // 写入文件失败
        } finally {
            close(new Closeable[]{fos, osw, bw});  // 关闭IO流
        }

        return result;  // 返回执行结果
    }

    /**
     * 把标记后的文本内容输出到文件里
     * @param fileName : 文件名
     * @param mark : 标记
     * @return Boolean true:写入成功, false:写入失败
     */
    public static boolean output(String fileName, BaseMark mark) {
        return output(fileName, mark, "UTF-8");  // 默认字符名称:UTF-8
    }

}
