/**
 * @program: json_preaser
 * @description: 后处理器，功能增强
 * @author: hamhuo
 **/
public class cleanStylePostProcessor {
    public static String cleanHtmlStyle(String text) {
        // 移除所有style属性
        text = text.replaceAll(" style=\"[^\"]*\"", "");

        // 移除span标签,保留内容
        text = text.replaceAll("<span[^>]*>", "");
        text = text.replaceAll("</span>", "");

        // 移除p标签
        text = text.replaceAll("<p>", "");
        text = text.replaceAll("</p>", "");

        return text;
    }

}