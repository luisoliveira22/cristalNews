/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristalnews;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * FXML Controller class
 *
 * @author lucas
 */
public class FXMLhomepageController implements Initializable {

    @FXML
    private WebView webview1;
    @FXML
    private WebView webview2;
    @FXML
    private WebView webview3;
    @FXML
    private WebView webview4;
    @FXML
    private WebView webview5;
    @FXML
    private WebView webview6;
    @FXML
    private WebView webview7;
    @FXML
    private WebView webview8;
    @FXML
    private WebView webview9;
    @FXML
    private WebView webview10;
    @FXML
    private WebView webview11;
    @FXML
    private WebView webview12;
    @FXML
    private WebView webview13;
    @FXML
    private WebView webview14;
    @FXML
    private WebView webview15;
    @FXML
    private WebView webview16;
    @FXML
    private WebView webview17;
    @FXML
    private WebView webview18;
    @FXML
    private WebView webview19;
    @FXML
    private WebView webview20;
    @FXML
    private WebView webview21;
    @FXML
    private WebView webview22;
    @FXML
    private WebView webview23;
    @FXML
    private WebView webview24;
    @FXML
    private WebView webview25;
    @FXML
    private WebView webview26;
    @FXML
    private WebView webview27;
    @FXML
    private WebView webview28;
    @FXML
    private WebView webview29;
    @FXML
    private WebView webview30;
    @FXML
    private WebView webview31;
    @FXML
    private WebView webview32;
    @FXML
    private WebView webview33;
    @FXML
    private WebView webview34;
    @FXML
    private WebView webview35;
    @FXML
    private WebView webview36;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        WebView[] webviewActualidade = {webview1, webview2, webview3, webview4, webview5, webview6, webview7 , webview8, webview9, webview10, webview11, webview12};
        WebView[] webviewDesporto = {webview13, webview14, webview15, webview16, webview17, webview18, webview19 , webview20, webview21, webview22, webview23, webview24};
        WebView[] webviewEco = {webview25, webview26, webview27, webview28, webview29, webview30, webview31 , webview32, webview33, webview34, webview35, webview36};
        
            //Array de strings com links para as noticias
            ArrayList<String> titulosAtualidade = titles("Actualidade");
            ArrayList<String> titulosDesporto = titles("Desporto");
            ArrayList<String> titulosEco = titles("Economia");
            //Array onde estão os paragrsfos das noticias
            ArrayList<String> paragrafosActualidade = new ArrayList<>();
            ArrayList<String> paragrafosDesporto = new ArrayList<>();
            ArrayList<String> paragrafosEco = new ArrayList<>();
            //Array com links para as paginas das noticias
            ArrayList<String> linksAtualidade = links_noticias("Actualidade");
            ArrayList<String> linksDesporto = links_noticias("Desporto");
            ArrayList<String> linksEco = links_noticias("Economia");
            
            
            ArrayList<String> imagensAtualidade = get_image("http://www.sapo.pt/noticias/atualidade", "Atualidade");
            ArrayList<String> imagensDesporto = get_image("http://www.sapo.pt/noticias/atualidade", "Desporto");
            ArrayList<String> imagensEco = get_image("http://www.sapo.pt/noticias/atualidade", "Economia");
            
            int i=0;
            int j=0;
            for (String link : linksAtualidade) {
                j++;
                if(j>20)
                    break;
                paragrafosActualidade.add(get_paragraph(link));
        }
            
            
   
        for (i = 0; i < webviewActualidade.length; i++) {    
                    
            String img_align = "\"left\"";
            System.out.println("paragrafo ="+ paragrafosActualidade.get(i));
            //builds the HTML containing the title and the first paragraph
            System.out.println("IMAGEM"+imagensAtualidade.get(i));
            String html
                    = "<html>"
                    + "   <head>"
                    + "      <style>"
                    + "         p { text-align: justify;}"
                    + "      </style>"
                    + "   </head>"
                    + "   <body>"
                    + "      <img src=" + "\""+imagensAtualidade.get(i)+"\"" + "align=" + img_align + " width=\"150\" height=\"130\" />"
                    + "      <p><b>" + titulosAtualidade.get(i) + "</b><br>"
                    +          paragrafosActualidade.get(i)
                    + "      </p>"
                    + "   </body>"
                    + "</html>";
            //loads the html to the webview
            webviewActualidade[i].getEngine().loadContent(html);
        }
      
            int k=0;
            int l=0;
            for (String link : linksDesporto) {
                l++;
                if(l>20)
                    break;
                paragrafosDesporto.add(get_paragraph(link));
        }
            
            
   
        for (k = 0; k < webviewDesporto.length; k++) {    
                    
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
                    + "      <img src=" + "\""+imagensDesporto.get(k)+"\"" + "align=" + img_align + " width=\"150\" height=\"130\" />"
                    + "      <p><b>" + titulosDesporto.get(k) + "</b><br>"
                    +          paragrafosDesporto.get(k)
                    + "      </p>"
                    + "   </body>"
                    + "</html>";
            //loads the html to the webview
            webviewDesporto[k].getEngine().loadContent(html);
        }
        
         k=0;
             l=0;
            for (String link : linksEco) {
                l++;
                if(l>20)
                    break;
                paragrafosEco.add(get_paragraph(link));
        }
            
            
   
        for (k = 0; k < webviewEco.length; k++) {    
                    
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
                    + "      <img src=" + "\""+imagensEco.get(k)+"\"" + "align=" + img_align + " width=\"150\" height=\"130\" />"
                    + "      <p><b>" + titulosEco.get(k) + "</b><br>"
                    +          paragrafosEco.get(k)
                    + "      </p>"
                    + "   </body>"
                    + "</html>";
            //loads the html to the webview
            webviewEco[k].getEngine().loadContent(html);
        }
        
    }    
    
     private ArrayList<String> get_image(String url, String categoria){
        ArrayList<String> img_links= new ArrayList<>();
        if(categoria.equals("Actualidade"))
            url="http://www.sapo.pt/noticias/atualidade";
        else if(categoria.equals("Desporto"))
            url="http://www.sapo.pt/noticias/desporto";
        else if(categoria.equals("Economia"))
            url="http://www.sapo.pt/noticias/economia";
            
        try {
            Elements locator = null;
            Document document = Jsoup.connect(url).get();
            //Returns the first node that as the news title, //article[@data-kpi]/figure/a
            locator = document.select("article[data-kpi] > figure > a img");
        
            for (Element element : locator) {
                
                //Text of the title, present in the node
               
                img_links.add(element.attr("src"));
                System.out.println();
                
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return img_links;
    }
    
    private ArrayList<String> titles(String categoria) {
        Elements locator = null;
        ArrayList<String> links= new ArrayList<>();
        try {
            String url = "https://www.sapo.pt/noticias/atualidade";
            if (categoria.equals("Actualidade")) {
                url = "http://www.sapo.pt/noticias/atualidade";
            } else if (categoria.equals("Desporto")) {
                url = "http://www.sapo.pt/noticias/desporto";
            } else if (categoria.equals("Economia")) {
                url = "http://www.sapo.pt/noticias/economia";
            }
            Document document = Jsoup.connect(url).get();
            //Returns the first node that as the news title, //article[@data-kpi]/figure/a/img
            locator = document.select("article[data-kpi] > figure > a img");
            for (Element link : locator) {
                links.add(link.attr("alt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //array list of String with the links for the news
        return links;
    }
    
    private ArrayList<String> links_noticias(String categoria) {
        Elements locator = null;
        ArrayList<String> links= new ArrayList<>();
        try {
            String url = "https://www.sapo.pt/noticias/atualidade";
            if (categoria.equals("Actualidade")) {
                url = "http://www.sapo.pt/noticias/atualidade";
            } else if (categoria.equals("Desporto")) {
                url = "http://www.sapo.pt/noticias/desporto";
            } else if (categoria.equals("Economia")) {
                url = "http://www.sapo.pt/noticias/economia";
            }
            Document document = Jsoup.connect(url).get();
            
            //Returns the first node that as the news title, //article[@data-kpi]/figure/a
            locator = document.select("article[data-kpi] > figure > a");
            for (Element link : locator) {
                links.add(link.attr("href"));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        //array list of String with the links for the news
        return links;
    }
    
 
    private String get_paragraph(String url) {
        String p = "";
        Document doc;    
            try{           
            //connects to the second link
            doc = Jsoup.connect(url).get();          
            Elements paragrafos= doc.select("p");
            StringBuilder sb= new StringBuilder();
            for (Element paragrafo : paragrafos) {
                String t= paragrafo.text().trim();
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
     
    }
    
    

}
