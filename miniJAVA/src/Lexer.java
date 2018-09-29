import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexer {
    public static String[] keywordsString = {"boolean", "class", "else", "extends", "false", "if", "int", "length", "main",
            "new", "public", "return", "static", "this", "true", "void", "while", "String", "System.out.println"};
    public static String[] OperatorAndDelimitersString = {"=", "+", "-", "*", "/", "&&", "||", "!", "==", "!=", "<", "<=", ">", ">=", ";", ",", ".", "(", ")",
            "[", "]", "{", "}"};
    public static List<String> keywords = Arrays.asList(keywordsString);
    public static List<String> operatorAndDelimiters = Arrays.asList(OperatorAndDelimitersString);
    ArrayList<Token> tokens;
    char[] chars;
    static int curIndex = 0;
    static int lastIndex = 0;

    public Lexer(char[] chars) {
        this.tokens = new ArrayList<>();
        this.chars = chars;
    }

    public void lex() throws Exception {

    }

    public boolean readNextChar() {
        if (curIndex < chars.length) {
            curIndex++;
            if (curIndex == chars.length)
                return false;
            return true;
        }
        return false;
    }

    public boolean isIntegerOrDouble() {
        return false;
    }

    public Token formToken(String information, int tokenNum) {
        Token token = new Token(tokenNum, information);
        if (token.tokenNum == 47) {
            if (keywords.contains(information)) {
                token.tokenNum = keywords.indexOf(information) + 1;
            }
        }
        return token;
    }

    public Token isIdentifier() {
        if (!readNextChar()) {
            String information = getString(lastIndex + 1, curIndex - 1);
            return formToken(information, 47);
        }
        char c = chars[curIndex];
        while (curIndex < chars.length && ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || ('A' <= c && c <= 'Z') || c == '_' || c == '$') {
            if (!readNextChar()) {
                String information = getString(lastIndex + 1, curIndex - 1);
                return formToken(information, 47);
            }
            c = chars[curIndex];
        }
        String information = getString(lastIndex + 1, curIndex - 1);
        Token token = formToken(information, 47);
        lastIndex = curIndex - 1;
        return token;
    }

    public String getString(int start, int end) {
        char[] chars_part = new char[end - start + 1];
        for (int i = 0; i <= end - start; i++) {
            chars_part[i] = chars[start + i];
        }
        return String.copyValueOf(chars_part);
    }

    public boolean isKeyword() {
        return false;
    }

    public Token isOperatorOrDelimiter() {
        char c = chars[curIndex];
        String operatorOrDelimiter = String.valueOf(c);
        return formToken(operatorOrDelimiter, operatorAndDelimiters.indexOf(operatorOrDelimiter) + 21);
    }

    public boolean isString() {
        return false;
    }
}
