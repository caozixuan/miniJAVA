import java.util.ArrayList;

public class Lexer {

    ArrayList<Token> tokens;
    char[] chars;
    static int curIndex = 0;
    static int lastIndex = 0;

    public Lexer(char[] chars){
        this.tokens = new ArrayList<>();
        this.chars = chars;
    }

    public void lex() throws Exception{

    }

    public boolean readNextChar(){
        return false;
    }

    public boolean isIntegerOrDouble(){
        return false;
    }

    public boolean isKeyWord(){
        return false;
    }

    public boolean isIdentifier(){
        return false;
    }

    public boolean isKeyword(){
        return false;
    }

    public boolean isOperatorOrDelimiter(){
        return false;
    }

    public boolean isComment(){
        return false;
    }

    public boolean isString(){
        return false;
    }
}
