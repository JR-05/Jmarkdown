package pers.conan.mdcoffee.markdown;

import pers.conan.mdcoffee.text.MarkDown;
import pers.conan.mdcoffee.util.MarkUtil;

/**
 * 图片标记
 * @author Conan
 *
 */
public class ImageMark extends BaseMark {
    
    /**
     * 图片名称
     */
    private String name = "";
    
    /**
     * 链接地址
     */
    private String url = "";
    
    /**
     * 图片说明
     * 鼠标放到图片上时显示的图片说明
     */
    private String description = "";
    
    /**
     * 构造方法
     * @param name
     * @param url
     * @param description
     */
    public ImageMark(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 构造方法
     */
    public ImageMark() {
        super();
    }

    @Override
    public void mark() {
        StringBuilder image = new StringBuilder();
        image.append(
                MarkDown.EXCLAMATION  // 感叹号
                + MarkDown.LEFT_SB  // 左方括号
                + this.name  // 链接名称
                + MarkDown.RIGHT_SB  // 右方括号
                + MarkDown.LEFT_BRACKET  // 左括号
                + this.url  // 链接地址
                );
        if (MarkUtil.isEmpty(this.description) == false) {  // 有图片说明
            image.append(
                    MarkDown.SPACE  // 空格
                    + MarkDown.DOUBLE_QUOTATION  // 双引号
                    + this.description  // 图片说明
                    + MarkDown.DOUBLE_QUOTATION  // 双引号
                    );
        }
        image.append(MarkDown.LEFT_BRACKET);  // 右括号
        this.translated = image.toString();
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
        // 图片标记没有内含标记集合
        return null;
    }

}
