import java.util.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class WebPageImpl implements WebPage {
    private String url;
    private Document doc;

    public WebPageImpl(String url) {
        this.url = url;
	doc = getDocument(url);
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Set<String> getLinks() {
        Set<String> links = new HashSet<String>();
        Elements jLinks = doc.getElementsByAttribute("href");
        return Collections.unmodifiableSet(links);
    }

    @Override
    public Set<String> getEmails() {
        Set<String> emails = null;
        return Collections.unmodifiableSet(emails);
    }

    @Override
    public Document getDocument(String url) {
	Document doc = null;
	try{
	    doc = Jsoup.connect(url).get();
	} catch(IOException e) {}
	return doc;
    }
}
