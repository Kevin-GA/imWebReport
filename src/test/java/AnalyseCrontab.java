import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @project:metadata
 * @packname:PACKAGE_NAME
 * @name: AnalyseCrontab
 * @describe:
 * @author: niujiaxin
 * @create: 2018-11-16-13:31
 */
public class AnalyseCrontab {
    public static void main(String[] args) {
        //File file = new File("d:/64_2018-11-09_15-44-53.log");
        //File file = new File("d:/124.251.46.199.log");
        File file = new File("d:/231.txt");
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<>();

        String str1 = "^#.*$";
        Pattern p1 = Pattern.compile(str1);
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                if(tempString.length()>0&&tempString!=null){
                    list.add(tempString);
                }
            }
            reader.close();
            for (String sr: list)
            {
                if(!p1.matcher(sr).matches()){
                    System.out.println("line " + line + ": " + sr);
                    line++;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

    }
    public void getMatch(String regEx,String matchStr){
        Pattern pattern = Pattern.compile(regEx);

    }
}
