import java.util.Scanner;

/**
 * @program: json_preaser
 * @description: entry
 * @author: hamhuo
 **/
public class Application {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while(true){
                StringBuilder jsonInput = new StringBuilder();
                System.out.println("@hamhuo \n 仅供智慧树`dohomework`解析");
                System.out.println("请输入JSON数据(输入 END 结束):");

                String line;
                while (!(line = scanner.nextLine()).equals("END")) {
                    jsonInput.append(line);
                }

                String result = JsonParser.parseQuestions(jsonInput.toString());
                System.out.println("\n解析结果:");
                System.out.println(result);
            }
        }

}