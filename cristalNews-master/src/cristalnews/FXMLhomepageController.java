/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristalnews;

import java.util.Timer;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class FXMLhomepageController implements Initializable{

    HashSet<String> lexicoRelevante;
    Timer timer= new Timer();
    
    @FXML
    private TabPane tab_pane;
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
    @FXML
    private WebView webview37;
    @FXML
    private WebView webview38;
    @FXML
    private WebView webview39;
    @FXML
    private WebView webview40;
    @FXML
    private WebView webview41;
    @FXML
    private WebView webview42;
    @FXML
    private WebView webview43;
    @FXML
    private WebView webview44;
    @FXML
    private WebView webview45;
    @FXML
    private WebView webview46;
    @FXML
    private WebView webview47;
    @FXML
    private WebView webview48;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadLexicos();
        String bgcolor = "#ffffff";
       
        WebView[] webviewActualidade = {webview1, webview2, webview3, webview4, webview5, webview6, webview7, webview8, webview9, webview10, webview11, webview12, webview37, webview38, webview39, webview40};
        WebView[] webviewDesporto = {webview13, webview14, webview15, webview16, webview17, webview18, webview19, webview20, webview21, webview22, webview23, webview24, webview41, webview42, webview43, webview44};
        WebView[] webviewEco = {webview25, webview26, webview27, webview28, webview29, webview30, webview31, webview32, webview33, webview34, webview35, webview36, webview45, webview46, webview47, webview48};

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

        int i = 0;
        int j = 0;
        for (String link : linksAtualidade) {
            j++;
            if (j > 20) {
                break;
            }
            paragrafosActualidade.add(get_paragraph(link));
        }

        for (i = 0; i < webviewActualidade.length; i++) {
            if (destakNew(paragrafosActualidade.get(i))) {
                bgcolor = "#a1ffb4";
            } else {
                bgcolor = "#FFFFFF";
            }

            String img_align = "\"left\"";
            //builds the HTML containing the title and the first paragraph

            String html
                    = "<html>"
                    + "   <head>"
                    + "      <style>"
                    + "         p { text-align: justify;}"
                    + "      </style>"
                    + "   </head>"
                    + "   <body bgcolor=" + "\"" + bgcolor + "\">"
                    + "      <img src=" + "\"" + imagensAtualidade.get(i) + "\"" + "align=" + img_align + " width=\"150\" height=\"130\" />"
                    + "      <p><b>" + titulosAtualidade.get(i) + "</b><br>"
                    + paragrafosActualidade.get(i)
                    + "      </p>"
                    + "   </body>"
                    + "</html>";
            //loads the html to the webview
            webviewActualidade[i].getEngine().loadContent(html);
        }

        int k = 0;
        int l = 0;
        for (String link : linksDesporto) {
            l++;
            if (l > 20) {
                break;
            }
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
                    + "      <img src=" + "\"" + imagensDesporto.get(k) + "\"" + "align=" + img_align + " width=\"150\" height=\"130\" />"
                    + "      <p><b>" + titulosDesporto.get(k) + "</b><br>"
                    + paragrafosDesporto.get(k)
                    + "      </p>"
                    + "   </body>"
                    + "</html>";
            //loads the html to the webview
            webviewDesporto[k].getEngine().loadContent(html);
        }

        k = 0;
        l = 0;
        for (String link : linksEco) {
            l++;
            if (l > 20) {
                break;
            }
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
                    + "      <img src=" + "\"" + imagensEco.get(k) + "\"" + "align=" + img_align + " width=\"150\" height=\"130\" />"
                    + "      <p><b>" + titulosEco.get(k) + "</b><br>"
                    + paragrafosEco.get(k)
                    + "      </p>"
                    + "   </body>"
                    + "</html>";
            //loads the html to the webview
            webviewEco[k].getEngine().loadContent(html);
        }
 
        timer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        
                        try {
                            refresh();
                        } catch (Exception ex) {
                            Logger.getLogger(FXMLhomepageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        }, 1800000);
        
    }
    
    @FXML
    public void reload(KeyEvent e) throws Exception {
       // Stage stage = (Stage) tab_pane.getScene().getWindow();
        Scene scene = tab_pane.getScene();
        if(e.getCode().equals(KeyCode.R))
            scene.setRoot(FXMLLoader.load(getClass().getResource("FXMLhomepage.fxml")));
            
    }
    
    @FXML
    public void refresh() throws Exception {
        Scene scene = tab_pane.getScene();
        scene.setRoot(FXMLLoader.load(getClass().getResource("FXMLhomepage.fxml")));
    }
    
    private ArrayList<String> get_image(String url, String categoria) {
        ArrayList<String> img_links = new ArrayList<>();
        if (categoria.equals("Actualidade")) {
            url = "http://www.sapo.pt/noticias/atualidade";
        } else if (categoria.equals("Desporto")) {
            url = "http://www.sapo.pt/noticias/desporto";
        } else if (categoria.equals("Economia")) {
            url = "http://www.sapo.pt/noticias/economia";
        }

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
        ArrayList<String> links = new ArrayList<>();
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
        ArrayList<String> links = new ArrayList<>();
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
        try {
            //connects to the second link
            doc = Jsoup.connect(url).get();
            Elements paragrafos = doc.select("p");
            StringBuilder sb = new StringBuilder();
            for (Element paragrafo : paragrafos) {
                String t = paragrafo.text().trim();
                if (t.length() == 0) {
                    continue;
                }
                char last = t.charAt(t.length() - 1);
                if (".!?".contains(last + "")) {
                    sb.append(t);
                    if (sb.length() > 200) {
                        break;
                    }
                }
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    private Boolean destakNew(String text) {
        HashSet<String> hset = new HashSet<>();
        HashSet<String> hset1 = new HashSet<>();

        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\CristalNews\\src\\lexico\\atualidade.txt")));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();

        }
        HashSet<String> intersection = hset1;
        String[] palavras = text.trim().split("[ ,;:.!?\n]+");
        for (String palavra : palavras) {
            hset.add(palavra);

        }
        System.out.println("hash.texto" + hset.toString());

        int lexSize = lexicoRelevante.size();
        hset.retainAll(lexicoRelevante);
        System.out.println("|lexSize|: " + lexSize);
        System.out.println("|retainAllSize|: " + hset.size());

        double conjuction = (double) hset.size() / lexSize;
        System.out.println("|Intersection %| " + conjuction);
        if (conjuction > 0.75) {
            return true;
        } else {
            return false;
        }

    }

    private void loadLexicos() {
        lexicoRelevante = new HashSet<>();
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get("C:\\Users\\lucas\\OneDrive\\Documentos\\NetBeansProjects\\CristalNews\\src\\lexico\\atualidade.txt")));
            String[] palavras = content.trim().split("[ ,;:.!?\n]+");
            for (String palavra : palavras) {
                lexicoRelevante.add(palavra);
            }
            //System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
