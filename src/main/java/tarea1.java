import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static spark.Spark.get;
import static spark.Spark.post;

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
        Elements imgElements = doc.select("p img[src~=(?i)\\\\.(png|jpe?g|gif)]");
        System.out.println("Cantidad de Imagenes dentro de Parrafos son: " + imgElements.size());

        //Parte D indicar la cantidad de formularios (form) que contiene el HTML por categorizando por el método implementado POST o GET
        Elements formElementsGet = doc.select("form[method~=get]");
        System.out.println("Cantidad de Form elements por Get: " + formElementsGet.size());
        Elements formElementsPost = doc.select("form[method~=post]");
        System.out.println("Cantidad de Form elements por Post: " + formElementsPost.size());

        //Parte E Para cada formulario mostrar los campos del tipo input y su respectivo tipo que contiene en el documento HTML
        Elements formElements = doc.select("form");
        System.out.println("Formularios:");
        for(Element form : formElements){
            System.out.println(" - Form " + form.id());
            Elements inputElements = formElements.select("input");
            for(Element input : inputElements){
                System.out.println("\tInput type " + input.attr("type"));
            }
        }

        //Parte F Para cada formulario “parseado”, identificar que el método de envío
        //        del formulario sea POST y enviar una petición al servidor con el
        //        parámetro llamado asignatura y valor practica1 y un header llamado
        //        matricula con el valor correspondiente a matrícula asignada. Debe
        //        mostrar la respuesta por la salida estándar.
        for(Element form : formElements){
            if(form.attr("type").equals("post")){
                String postUrl = form.attr("action");
                String asignatura = "ProgramaciónWeb";
                String practica1 = "Práctica1";
                String matricula = "2014-1130";
                String url = doc.baseUri() +  postUrl + "/" + asignatura + "/" + practica1;
                System.out.println(url);
                Document response = Jsoup
                        .connect(url).header("Matricula", matricula).timeout(5000).post();
                System.out.println(response);
            }
        }
    }
}
