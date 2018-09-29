import java.io.*;

public class Util {
    /*
     * 该类用于构建一些工具类的静态方法，比如打开文件，处理文件中的无用字符等等
     */

    public static char[] openFile(String fileName) {
        char[] chars = new char[10];
        String inputContent = "";

        try {
            String pathname = "./codes/" + fileName;
            File f = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(f));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            inputContent += line;
            while (line != null) {
                line = br.readLine();
                if (line != null)
                    inputContent += line + "\n";
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fail to open source code file.");
        }

        System.out.println(inputContent);

        return chars;
    }


    // 去除无用字符
    public static char[] deleteUnusedChars() {
        char[] chars = new char[10];
        return chars;
    }

    public static void main(String args[]) {
        openFile("test.txt");
    }
}
