import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

import java.util.Scanner;

public class HttpGetEx {

	public static void main(String args[]) throws Exception{

		//Creating a HttpClient object
		CloseableHttpClient httpclient = HttpClients.createDefault();

		//Creating a HttpGet object
		HttpGet httpget = new HttpGet("https://www.tutorialspoint.com/");

		//Printing the method used
		System.out.println("Request Type: "+httpget.getMethod());

		//Executing the Get request
		HttpResponse httpresponse = httpclient.execute(httpget);

		Scanner sc = new Scanner(httpresponse.getEntity().getContent());

		//Printing the status line
		System.out.println(httpresponse.getStatusLine());
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());

		}
		//34534534534534534

		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());System.out.println(sc.nextLine());System.out.println(sc.nextLine());
	}
}
