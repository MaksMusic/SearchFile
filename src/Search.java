import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    static List<File> list = new ArrayList<>();
    static List<String> text ;

    public static void main(String[] args) {
        Path path = Paths.get("d:\\Users\\Admin\\Desktop\\Java����������");
        listFiles(path.toFile());
        //keywordSearch(list,"linzy","�����","������� �����","�������","�������");
        searchTextFile(list);

    }

    /** ������� ��� ����� �� ���� �������� � ����*/
    public static void listFiles(File dir) {

        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file);
            } else {
                list.add(file);
                //System.out.println(file.getAbsolutePath());
            }
        }
    }


    /** ����� �� ����������� ������ �� ����� ������ */
    public static void searchTextFile(List<File> list){
        System.out.println("----------------����� �� �����---------------------");
        System.out.println("������� �������� ����� ��� ������");
        String words = new Scanner(System.in).nextLine();
        for (File file : list) {
            List<String> texts = new ArrayList<>();
            try {
                Charset charset = StandardCharsets.UTF_8;
                try {
                 texts = Files.readAllLines(file.toPath(),charset);
                }catch (MalformedInputException e){

                }

                //byte [] bytes = Files.readAllBytes(file.toPath());
                //String content = new String(bytes, StandardCharsets.UTF_8);
                //System.out.println(content);
                for (String str : texts) {

                    if(str.toLowerCase().contains(words.toLowerCase())){
                        System.out.println(file.getName());
                        System.out.println("---����������---");
                        System.out.println(texts);
                        System.out.println("----------");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /** ����� �� �������� ������ �� ����� ������*/
    public static void keywordSearch(List<File> fileList,String ... strs){
        for (File file : fileList) {
            for (String str : strs) {
                if (file.getName().toLowerCase().contains(str.toLowerCase())){
                    System.out.println(file);
                }
            }

        }
    }


}
