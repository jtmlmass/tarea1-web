import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class tarea1 {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.wikihow.com/Play-Guitar").get();
        System.out.println("Titulo: " + doc.title());

        //Parte A Indicar la cantidad de lineas del recurso retornado
        int lineas = doc.html().split(System.getProperty("line.separator")).length;
        System.out.println("Cantidad de lineas en el Recurso retornado: " + lineas);
    }
}
