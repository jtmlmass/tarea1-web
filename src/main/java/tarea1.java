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

        //Parte B Indicar la cantidad de párrafos (p) que contiene el documento HTML
        Elements pElements = doc.select("p");
        System.out.println("Cantidad de Parrafos: " + pElements.size());

        //Parte C Indicar la cantidad de imágenes (img) dentro de los párrafos que contiene el archivo HTML
        Elements imgElements = doc.select("p img");
        System.out.println("Cantidad de Imagenes dentro de Parrafos son: " + imgElements.size());

        //Parte D indicar la cantidad de formularios (form) que contiene el HTML por categorizando por el método implementado POST o GET
        Elements formElementsGet = doc.select("form[method~=get]");
        System.out.println("Cantidad de Form elements por Get: " + formElementsGet.size());
        Elements formElementsPost = doc.select("form[method~=post]");
        System.out.println("Cantidad de Form elements por Post: " + formElementsPost.size());
    }
}
