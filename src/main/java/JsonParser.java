
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: json_parser
 * @description: a parser for transiting homework
 * @author: hamhuo
 **/
public class JsonParser {

    public static String parseQuestions(String jsonStr) {
        StringBuilder output = new StringBuilder();

        try {
            JSONObject data = JSON.parseObject(jsonStr);
            JSONObject rt = data.getJSONObject("rt");
            JSONObject examBase = rt.getJSONObject("examBase");
            JSONArray parts = examBase.getJSONArray("workExamParts");
            JSONObject part = parts.getJSONObject(0);
            JSONArray questions = part.getJSONArray("questionDtos");

            for (int i = 0; i < questions.size(); i++) {
                JSONObject q = questions.getJSONObject(i);
                String qtype = q.getJSONObject("questionType").getString("name");
                // 在JsonParser类的parseQuestions方法中修改处理逻辑:
                String question = cleanStylePostProcessor.cleanHtmlStyle(q.getString("name"));

                JSONArray options = q.getJSONArray("questionOptions");

                output.append(String.format("%d. [%s] %s\n", (i+1), qtype, question));

                for (int j = 0; j < options.size(); j++) {
                    JSONObject opt = options.getJSONObject(j);
                    String optContent = cleanStylePostProcessor.cleanHtmlStyle(opt.getString("content"));
                    output.append(String.format("%c. %s\n", (char)('A' + j), optContent));
                }
                output.append("\n");
            }

        } catch (Exception e) {
            return "Error parsing JSON: " + e.getMessage();
        }

        return output.toString();
    }
}