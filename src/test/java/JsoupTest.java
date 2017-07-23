import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupTest {
    public static void main(String[] args){
        String s = "<div class=\"profile-navbar clearfix\">\n" +
                "<a class=\"item home first \" href=\"/people/wo-yan-chen-mo\">\n" +
                "<i class=\"icon icon-profile-tab-home\"></i><span class=\"hide-text\">主页</span>\n" +
                "</a>\n" +
                "<a class=\"item \" href=\"/people/wo-yan-chen-mo/asks\">\n" +
                "提问\n" +
                "<span class=\"num\">2</span>\n" +
                "</a>\n" +
                "<a class=\"item \" href=\"/people/wo-yan-chen-mo/answers\">\n" +
                "回答\n" +
                "<span class=\"num\">4</span>\n" +
                "</a>\n" +
                "<a class=\"item \" href=\"/people/wo-yan-chen-mo/posts\">\n" +
                "文章\n" +
                "<span class=\"num\">0</span>\n" +
                "</a>\n" +
                "\n" +
                "<a class=\"item \" href=\"/people/wo-yan-chen-mo/collections\">\n" +
                "收藏\n" +
                "<span class=\"num\">5</span>\n" +
                "</a>\n" +
                "<a class=\"item \" href=\"/people/wo-yan-chen-mo/logs\">\n" +
                "公共编辑\n" +
                "<span class=\"num\">4</span>\n" +
                "</a>\n" +
                "\n" +
                "</div>";
        Document document = Jsoup.parse(s);
        Elements es = document.select("div.profile-navbar a[href$=asks]");
        String attr = es.attr("class");
        String html = es.html();
        String text = es.text();
        System.out.println(text);
        System.out.println(html);
        System.out.println(attr);
        System.out.println(es.toString());
    }
}
