import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler1 {
    private Set <String> visitedLinks = new HashSet<>();
    public void crawl(String starturl){
        if(visitedLinks.contains(starturl)){
        return;
    } System.out.println("Crawling:" + starturl);
    visitedLinks.add(starturl);    

    try{
    URL url = new URL(starturl);
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder html = new StringBuilder();
        String line;
        while((line=reader.readLine()) !=null){
            html.append(line);
        }reader.close();
        Pattern  pattern = Pattern.compile("<a\\s+[^>]*href=[\"']([^\"'>\\s]+)[\"']", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html.toString());
        while (matcher.find()){
            String link = matcher.group(1);
            if(link.startsWith("http")){
                System.out.println("found:" + link);
            }
        }
    }catch(Exception e ){
        System.err.println("Failed To crawl" +  starturl + "->>>" + e.getMessage());
    }
}

    public static void main(String[] args){
    String startingurl = "https:https://uok.edu.pk/faculties/computerscience/ubit.php";
    WebCrawler1 crawler = new WebCrawler1();
    crawler.crawl(startingurl);
    }
}
