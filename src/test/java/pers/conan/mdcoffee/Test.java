package pers.conan.mdcoffee;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import pers.conan.mdcoffee.util.IOUtil;

public class Test {

    public static void main(String[] args) {
        
        output();

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
