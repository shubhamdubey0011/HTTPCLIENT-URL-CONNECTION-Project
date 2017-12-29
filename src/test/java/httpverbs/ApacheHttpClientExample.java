package httpverbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonNode;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ApacheHttpClientExample
{
	private static String sessionToken;
	private static JsonNode metadata = null;
	private static com.fasterxml.jackson.databind.JsonNode metadata1 = null;
	private static final String USER_AGENT = "Mozilla/5.0";

	private static String jsonLine;

	private static final String GET_URL = "http://fabricgroup.xidio.com/fmds/api/watchable/web/videos/121972";

	private static final String Merlin_URL = "http://fabricdemo.xidio.com/fmes/api/merlin/event";

	private static final String POST_URL = "http://fabricgroup.xidio.com/fmds/api/watchable/iptv/authenticate";

	public static void main(String[] args) throws IOException

	{

		
		  System.out.println("POST : Generating Session Token"); sendPOST();
		  System.out.println("Session Token generated");
		  
		  System.out.println("GET : Getting video details"); sendGET();
		  System.out.println("Received Video details ");
		 
//		sendPUT();
	}

	private static CloseableHttpResponse sendPOST() throws IOException {

		CloseableHttpResponse response = null;

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(POST_URL);
		httpPost.addHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("Content-Type", "text/plain"));
		urlParameters.add(new BasicNameValuePair("Accept", "application/json"));

		HttpEntity e = new StringEntity(
				"9a5901f0-63f9-4938-87cc-7a9b733788c1_3a5a0a7f-3e23-4fb2-9e16-4df426cf2190");

		HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
		httpPost.setEntity(postParams);
		httpPost.setEntity(e);

		System.out.println("Executing request : " + httpPost.getRequestLine());
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

		System.out.println("POST Response Status:: "
				+ httpResponse.getStatusLine().getStatusCode());
		Assert.assertEquals(204, httpResponse.getStatusLine().getStatusCode());

		// print result
		System.out.println(httpResponse.getFirstHeader("SessionToken")
				.toString());

		org.apache.http.Header[] header = httpResponse
				.getHeaders("SessionToken");
		sessionToken = header[0].toString();
		Assert.assertNotNull(header[0]);
		String[] tokens = sessionToken.split(":");
		sessionToken = tokens[1];

		System.out.println(sessionToken);

		httpClient.close();
		return httpResponse;

	}

	private static CloseableHttpResponse sendGET() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(GET_URL);
		httpGet.addHeader("User-Agent", USER_AGENT);
		httpGet.setHeader("Content-Type", "text/plain");
		httpGet.setHeader("SessionToken", sessionToken);
		CloseableHttpResponse gethttpResponse = httpClient.execute(httpGet);

		System.out.println("Request executing:: " + httpGet.getRequestLine());

		System.out.println("GET Response Status:: "
				+ gethttpResponse.getStatusLine().getStatusCode());

		Assert.assertEquals(200, gethttpResponse.getStatusLine()
				.getStatusCode());

		// print result
		System.out.println("response headers :: " + gethttpResponse);

		String response = gethttpResponse.toString();

		if (gethttpResponse.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			// success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					gethttpResponse.getEntity().getContent()));

			String inputLine;
			StringBuffer response1 = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response1.append(inputLine);
				ModelVideo object = new Gson().fromJson(response1.toString(),
						ModelVideo.class);
				System.out.println("Channel Title " + object.getTitle());
			}

			in.close();

			System.out.println(" Response Body : :" + response1.toString());

		} else {
			System.out.println("GET request not worked");
		}

		/* Parsing using object mapper */
		/*
		 * ObjectMapper mapper = new ObjectMapper(); metadata =
		 * mapper.readTree(gethttpResponse.getEntity().getContent());
		 * System.out.println(metadata); String type =
		 * metadata.get("type").asText(); String id =
		 * metadata.get("id").asText(); System.out.println("video type :: " +
		 * type); System.out.println("video id :: " + id);
		 */

		// httpClient.close();
		return gethttpResponse;
	}

	private static CloseableHttpResponse sendPUT() throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut httpput = new HttpPut(Merlin_URL);

		HttpEntity merlinbody = new StringEntity(
				"{\"uuid\":\"7459b08f-ef2d-482d-9b9b-2ea7d8980f96\",\"fensEvent\":{\"resourceType\":\"AssetResourceType\",\"resourceId\":\"189458\",\"eventType\":\"Published\",\"attributes\":{\"tenant\":\"watchable\",\"platforms\":\"stb\",\"uuid\":\"726439a1-63e3-44ba-ba30-2b1c73d06ff1\"}},\"rss\":null,\"rssXml\":null,\"vimondEvent\":null}");

		List<NameValuePair> urlParameters1 = new ArrayList<NameValuePair>();
		urlParameters1.add(new BasicNameValuePair("Content-Type",
				"application/json"));
		urlParameters1.add(new BasicNameValuePair("x-fabric-uuid", "1"));
		urlParameters1.add(new BasicNameValuePair("cache-control", "no-cache"));
		urlParameters1.add(new BasicNameValuePair("postman-token",
				"b7d4ad2b-fe7a-de84-a76a-22ea4d395742"));

		HttpEntity postParams = new UrlEncodedFormEntity(urlParameters1);
		httpput.setEntity(merlinbody);

		CloseableHttpResponse gethttpResponse2 = httpClient.execute(httpput);

		System.out.println("Request executing:: " + httpput.getRequestLine());

		System.out.println("GET Response Status:: "
				+ gethttpResponse2.getStatusLine().getStatusCode());

		Assert.assertEquals(gethttpResponse2.getStatusLine().getStatusCode(),
				200);

		// print result
		System.out.println("response headers :: " + gethttpResponse2);

		/*
		 * ObjectMapper mapper = new ObjectMapper(); metadata1 =
		 * mapper.readTree(gethttpResponse2.getEntity().getContent());
		 * System.out.println(metadata); String type =
		 * metadata1.get("type").asText(); String id =
		 * metadata1.get("id").asText(); System.out.println("video type :: " +
		 * type); System.out.println("video id :: " + id);
		 */

		if (gethttpResponse2.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			// success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					gethttpResponse2.getEntity().getContent()));

			String inputLine;
			StringBuffer response1 = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response1.append(inputLine);
				/*
				 * ModelMerlin object = new
				 * Gson().fromJson(response1.toString(), ModelMerlin.class);
				 * System.out.println("sssssssssssssssssss" +
				 * object.getFensEvent().getEventType());
				 */

			}

			// in.close();
			System.out.println(" Response Body : :" + response1.toString());

		} else {
			System.out.println("GET request not worked");
		}

		// httpClient.close();
		return gethttpResponse2;
	}

}
