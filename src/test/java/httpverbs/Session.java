package httpverbs;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class Session 
{
	
	private WebClient  webClient;
	private String host;
	public static String sessionToken;
	private static ThreadLocal<Session> session = new ThreadLocal<Session>();


	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String GET_URL = "http://fabricgroup.xidio.com/fmds/api/watchable/web/videos/121972";

	private static final String POST_URL = "http://fabricgroup.xidio.com/fmds/api/watchable/iptv/authenticate";

	private static final String POST_PARAMS = "userName=Pankaj";
	
public static void main(String[] args) throws IOException 
{

	sendPOST();
	
}

public static Session getSession() {
	if (session.get() == null) 
	{
		Session newObj = new Session();
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getCookieManager().setCookiesEnabled(true);
		webClient.getOptions().setRedirectEnabled(true);
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getCache().setMaxSize(0);
		newObj.setHost("http://tollgateqa.xidio.net:8080");
		newObj.setWebClient(webClient);
		session.set(newObj);
	}
	
	return session.get();
}

public String getHost() {
	return host;
}

public void setHost(String host) 
{
	this.host = host;
}

public WebClient getWebClient() {
	return webClient;
}

public void setWebClient(WebClient webClient)
{
	this.webClient = webClient;
}

private static void sendPOST() throws IOException {
	URL obj = new URL(POST_URL);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setDoOutput(true);
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Content-Type", "text/plain");
	con.setRequestProperty("Accept", "application/json");

	OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
	out.write("9a5901f0-63f9-4938-87cc-7a9b733788c1_3a5a0a7f-3e23-4fb2-9e16-4df426cf2190");
	out.flush();
	out.close();
	con.getInputStream();

	int responseCode = con.getResponseCode();

	System.out.println("POST Response Code :: " + responseCode);

	System.out.println(con.getHeaderField("SessionToken"));

	sessionToken = con.getHeaderField("SessionToken");

	Assert.assertNotNull(sessionToken);

	
}











}
