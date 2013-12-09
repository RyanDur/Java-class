import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class TestWebPage {
    WebPage webPage;
    String url = "http://en.wikipedia.org/";
    Document document;
    String link = "http://example.com/image.ico";

    private String PageProvider1() {

        StringBuffer html = new StringBuffer();

        html.append("<!DOCTYPE html>");
        html.append("<html lang=\"en\">");
        html.append("<head>");
        html.append("<link rel=\"icon\" href=\""+ link +"\" />");
        html.append("</head>");
        html.append("<body>");
        html.append("something");
        html.append("</body>");
        html.append("</html>");

        return html.toString();
    }

    @Before
    public void setup() {
        webPage = spy(new WebPageImpl(url));
    }

    @Test
    public void shouldSomething() {
        doReturn(Jsoup.parse(PageProvider1())).when(webPage).getDocument(anyString());
    }
}
