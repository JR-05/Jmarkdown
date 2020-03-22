package pers.conan.mdcoffee.markdown;

public class TextMark extends BaseMark {

    public TextMark(String text, int type) {
        super(text);
        this.type = type;
    }
    
    public TextMark(BaseMark mark, int type) {
        super(mark);
        this.type = type;
    }

    @Override
    public void mark() {
        // TODO Auto-generated method stub

    }

    @Override
    public String translate() {
        // TODO Auto-generated method stub
        return null;
    }

}
