package httpverbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;

import com.google.gson.Gson;

public class HttpURLConnectionExample {

	private static String sessionToken;

	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String GET_URL = "http://fabricgroup.xidio.com/fmds/api/watchable/web/videos/121972";

	private static final String POST_URL = "http://fabricgroup.xidio.com/fmds/api/watchable/iptv/authenticate";

	private static final String POST_PARAMS = "userName=Pankaj";

	public static void main(String[] args) throws IOException {

		sendPOST();
		System.out.println("Session Token Generated Using Post Method ");
		sendGET();
		System.out.println("Video By Id API");

	}

	private static void sendGET() throws IOException {
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("SessionToken", sessionToken);

		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				ModelVideo object = new Gson().fromJson(response.toString(), ModelVideo.class);
				System.out.println("Video Title :: " + object.getTitle());
			}

			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}

	// Session Token Generation
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

		/*
		 * if (responseCode == HttpURLConnection.HTTP_NO_CONTENT)
		 * 
		 * { // success BufferedReader in = new BufferedReader(new
		 * InputStreamReader( con.getInputStream())); String inputLine;
		 * StringBuffer response = new StringBuffer();
		 * 
		 * while ((inputLine = in.readLine()) != null) {
		 * System.out.println("Shubham"+in.readLine());
		 * response.append(inputLine); } in.close();
		 * 
		 * // print result System.out.println(con.toString()); } else {
		 * System.out.println("POST request not worked"); }
		 */
	}

}