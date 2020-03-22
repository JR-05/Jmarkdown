package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;

public class LinkMark extends BaseMark {
    
    /**
     * 链接名称
     */
    private String name = "";
    
    /**
     * 链接地址
     */
    private String url = "";
    
    /**
     * 构造方法
     * @param name
     * @param url
     */
    public LinkMark(String name, String url) {
        this.name = name;
        this.url = url;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 构造方法
     */
    public LinkMark() {
        super();
    }

    @Override
    public void mark() {
        this.translated = 
                MarkDown.LEFT_SB  // 左方括号
                + this.name  // 链接名称
                + MarkDown.RIGHT_SB  // 右方括号
                + MarkDown.LEFT_BRACKET  // 左括号
                + this.url  // 链接地址
                + MarkDown.RIGHT_BRACKET;  // 右括号
    }

    @Override
    public String translate() {
        this.mark();
        if (this.next != null) {
            return this.translated + MarkDown.NEXT + this.next.translate();
        }
        return this.translated;
    }

    @Override
    public String markInclusions() {
        // 链接标记没有内含标记集合
        return null;
    }

}
