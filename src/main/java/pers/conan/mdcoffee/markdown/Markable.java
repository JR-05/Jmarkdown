package pers.conan.mdcoffee.markdown;

/**
 * 接口：Markable
 * 可标记的
 * @author Conan
 */
public interface Markable {
    
    /**
     * 标记
     */
    void mark();
    
    /**
     * 转换成文本内容
     * @return
     */
    String translate();
    
}
