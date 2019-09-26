import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class tarea1 {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.wikihow.com/Play-Guitar").get();
        System.out.println("Titulo: " + doc.title());
    }
}
