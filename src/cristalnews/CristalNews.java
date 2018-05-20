/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristalnews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author lucas
 */
public class CristalNews extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLhomepage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);
        
        int i=0;
        WebView webview1 = (WebView) root.getChildrenUnmodifiable().get(0);
        WebView webview2 = (WebView) root.getChildrenUnmodifiable().get(1);
        WebView webview3 = (WebView) root.getChildrenUnmodifiable().get(2);
        WebView webview4 = (WebView) root.getChildrenUnmodifiable().get(3);
        WebView webview5 = (WebView) root.getChildrenUnmodifiable().get(4);
        WebView webview6= (WebView) root.getChildrenUnmodifiable().get(5);
        WebView webview7= (WebView) root.getChildrenUnmodifiable().get(6);
        WebView webview8 = (WebView) root.getChildrenUnmodifiable().get(7);
        WebView webview9= (WebView) root.getChildrenUnmodifiable().get(8);
        WebView webview10= (WebView) root.getChildrenUnmodifiable().get(9);
        WebView webview11= (WebView) root.getChildrenUnmodifiable().get(10);
        WebView webview12= (WebView) root.getChildrenUnmodifiable().get(11);
        
        
        
       
        WebView[] webview = {webview1, webview2, webview3, webview4, webview5, webview6, webview7 , webview8, webview9, webview10, webview11, webview12};
        List<WebView>  webview_list= new ArrayList<WebView>(); 
        
        List<WebEngine> engine_list = new ArrayList<WebEngine>();

        Document document, document2;
        
            //Array de strings com links para as noticias
            ArrayList<String> titulos = titles();
            //Array onde estão os paragrsfos das noticias
            ArrayList<String> paragrafos = new ArrayList<>();
            //Array com links para as paginas das noticias
            ArrayList<String> links = links_noticias();
                    int j=0;
            for (String link : links) {
                System.out.println(link +"link" + j);
                paragrafos.add(get_paragraph(link));
                j++;
        }
            System.out.println("Passou-------------------------");
            //String titulo = locator.text();
            //String link = a_href(locator);
            ArrayList<String> imagens = get_image("https://news.google.com/gn/news/headlines?ned=pt-pt_pt&hl=pt-pt&gl=PT");
            
            //System.out.println(link);
            
           // String paragrafo = get_paragraph(link);
           //System.out.println(paragrafo);
        for (i = 0; i < webview.length; i++) {
            System.out.println("tiulo:    "+titulos.get(i) + "\n Paragrafos     " + paragrafos.get(i));
            String img_align = "\"left\"";
            
            //builds the HTML containing the title and the first paragraph
            String html
                    = "<html>"
                    + "   <head>"
                    + "      <style>"
                    + "         p { text-align: justify;}"
                    + "      </style>"
                    + "   </head>"
                    + "   <body>"
                    + "      <img src=" + "\""+imagens.get(i)+"\"" + "align=" + img_align + " width=\"150\" height=\"130\" />"
                    + "      <p><b>" + titulos.get(i) + "</b><br>"
                    + paragrafos.get(i)
                    + "      </p>"
                    + "   </body>"
                    + "</html>";
            //loads the html to the webview
            webview[i].getEngine().loadContent(html);
        }
      
        
        
        
        /*for (i = 0; i < root.getChildrenUnmodifiable().size(); i++) {
            if (root.getChildrenUnmodifiable().get(i) instanceof WebView) {
                webview_list.add((WebView) root.getChildrenUnmodifiable().get(i));
                engine_list.add(webview[i].getEngine());
                engine_list.get(i).load(urls[i]);
            }
        }*/
    }
    
    private ArrayList<String> get_image(String link){
        ArrayList<String> img_links= new ArrayList<>();
        try {
            Elements locator = null;
            Document document = Jsoup.connect(link).get();
            //Returns the first node that as the news title
            locator = document.select("c-wiz[class=lPV2Xe k3Pzib] img");
        
            for (Element element : locator) {
                
                //Text of the title, present in the node
                System.out.println("Imagem link=" + element.attr("src") );
                
                img_links.add(element.attr("src"));
                
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return img_links;
    }
    
    private ArrayList<String> titles() throws IOException {
        Elements locator = null;
        ArrayList<String> links= new ArrayList<>();
        try {
            String url = "https://news.google.com/gn/news/headlines?ned=pt-pt_pt&hl=pt-pt&gl=PT";
            Document document = Jsoup.connect(url).get();
            //Returns the first node that as the news title
            locator = document.select("c-wiz[class=M1Uqc kWyHVd] > a");
            for (Element link : locator) {
                links.add(link.text());
            }
            //Text of the title, present in the node
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        //array list of String with the links for the news
        return links;
    }
    
    
    private ArrayList<String> links_noticias() throws IOException {
        Elements locator = null;
        ArrayList<String> links= new ArrayList<>();
        try {
            String url = "https://news.google.com/gn/news/headlines?ned=pt-pt_pt&hl=pt-pt&gl=PT";
            Document document = Jsoup.connect(url).get();
            //Returns the first node that as the news title
            locator = document.select("c-wiz[class=M1Uqc kWyHVd] > a");
            for (Element link : locator) {
                links.add(link.attr("href"));
            }
            //Text of the title, present in the node
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        //array list of String with the links for the news
        return links;
    }
    
    
    private String a_href(Element loc){//loc must be a tag
        //gets the link of the title, representing the news link
        String url = loc.attr("href");
       
        return url;
    }
    
    private String get_paragraph(String url){
        String p = "";
        Document doc;
        int i=0;
        try{
            //connects to the second link
            doc = Jsoup.connect(url).get();
            Elements paragrafos= doc.select("p");
            StringBuilder sb= new StringBuilder();
            for (Element paragrafo : paragrafos) {
                String t= paragrafo.text().trim();
                System.out.println("tamanho======" + t.length());
                
                if(t.length()==0){
                    continue;
                } 
                char last= t.charAt(t.length()-1);  
                if ( ".!?".contains(last+"") ) {
                    sb.append(t);
                    if ( sb.length() > 200 ) 
                        break;
                }
            }
            
            return sb.toString();
        } catch(IOException e){
            e.printStackTrace();
        }
            
        return "";
     
           /* while (true) {
                //selects the first paragrhpah, normally contains the first paragraph of the news
                p = doc.select("p").get(i).text();
                System.out.println(p);
                if(p.length()<100)
                    p= p+ doc.select("p").get(i).text();
                else
                    return p;
                i++;
            }
            
            
            
       
        /*
        return p;*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
