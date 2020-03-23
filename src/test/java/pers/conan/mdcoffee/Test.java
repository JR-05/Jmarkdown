package pers.conan.mdcoffee;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import pers.conan.mdcoffee.markdown.BaseMark;
import pers.conan.mdcoffee.markdown.Markable;
import pers.conan.mdcoffee.markdown.OrderMark;
import pers.conan.mdcoffee.markdown.TextMark;
import pers.conan.mdcoffee.markdown.UnOrderMark;
import pers.conan.mdcoffee.text.Type;
import pers.conan.mdcoffee.util.IOUtil;

public class Test {

    public static void main(String[] args) {
        
        TextMark boldMark = new TextMark("This is a bold MarkDown.", Type.BOLD);
        TextMark italicMark = new TextMark("This is an italics MarkDown.", Type.ITALICS);
        TextMark deleteMark = new TextMark("This is a delete MarkDown.", Type.DELETE);
        TextMark underLineMark = new TextMark("This is an underline MarkDown.", Type.UNDER_LINE);
        
        UnOrderMark uoMark = new UnOrderMark();
        uoMark.put(boldMark);
        uoMark.put(italicMark);
        uoMark.put(deleteMark);
        uoMark.put(underLineMark);
        
        OrderMark oMark = new OrderMark();
        oMark.put(boldMark);
        oMark.put(italicMark);
        oMark.put(deleteMark);
        oMark.put(underLineMark);
        
        uoMark.append(oMark);
        
        
        output("d:/test.md", uoMark);
        
        System.out.println(uoMark.translate());
    }
    
    public static void output(String file, BaseMark mark) {
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
