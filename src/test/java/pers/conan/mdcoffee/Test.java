package pers.conan.mdcoffee;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import pers.conan.mdcoffee.markdown.Markable;
import pers.conan.mdcoffee.markdown.TextMark;
import pers.conan.mdcoffee.text.Type;
import pers.conan.mdcoffee.util.IOUtil;

public class Test {

    public static void main(String[] args) {
        
        TextMark boldMark = new TextMark("This is a bold MarkDown.", Type.BOLD);
        TextMark italicMark = new TextMark("This is an italics MarkDown.", Type.ITALICS);
        TextMark deleteMark = new TextMark("This is a delete MarkDown.", Type.DELETE);
        TextMark underLineMark = new TextMark("This is an underline MarkDown.", Type.UNDER_LINE);
        
        TextMark textMark = new TextMark();
        textMark.put(boldMark);
        textMark.put(italicMark);
        textMark.put(deleteMark);
        textMark.put(underLineMark);
        
        TextMark textMark2 = new TextMark();
        textMark2.setText("Hello World.");
        
        textMark.append(textMark);  // 附着一个标记
        
        textMark2.append(textMark);  // 附着一个标记
        
        output("d:/test.md", textMark);
        
        System.out.println(textMark.translate());
    }
    
    public static void output(String file, Markable mark) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        
        try {
            
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);
            
            bw.write(mark.translate());  // 写入文件
            
            bw.flush();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            IOUtil.close(new Closeable[] {fos, osw, bw});
        }
        
    }
    
    public static void output() {
        String[] contents = new String[] {"Hello World.", "This is MarkDown."}; 
        
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        
        try {
            fos = new FileOutputStream("D:/test.txt");
            osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);
            for (int i = 0; i < contents.length; i ++) {
                if (i == 0) {
                    bw.write(contents[i]);
                } else {
                    bw.write("\r" + contents[i]);
                }
            }
            bw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            IOUtil.close(new Closeable[] {fos, osw, bw});
        }
    }

}
