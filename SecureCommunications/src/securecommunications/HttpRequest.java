package securecommunications;

import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.cert.X509Certificate;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.interfaces.RSAPublicKey;
import java.security.cert.CertificateException;
 
public class HttpRequest {
 
	private final String USER_AGENT = "Something Secret to be fun";

	// HTTP GET request
	public Integer sendGet(String data) throws Exception {
		
		final TrustManager[] trustAllCerts = new TrustManager[] { 
			new X509TrustManager() {
				@Override
				public void checkClientTrusted(final X509Certificate[] chain, final String authType) {}
				
				@Override
				public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException
				{
					String PUB_KEY = "30819f300d06092a864886f70d010101050003818d003081890281" +
									 "8100c4fa891590ba83e2b51b0b86afd29cde3e04a6daaeea659c87"+
									 "dea9125ce593830a47c6ccbccbfffa336838af972e9644b0cdc64e"+
									 "44535272e45420ad6f8512fc992c33ba6c279e24564df9835267d4"+
									 "67dd3b234afc3789d6bc07b552e9e734b89b71cc97433b4d086b56"+
									 "a4227523ced2c6177d86f7d8dc85aa2a79dae1c9e58f0203010001";
					
					RSAPublicKey pubkey = (RSAPublicKey) chain[0].getPublicKey();
					String encoded = new BigInteger(1 /* positive */, pubkey.getEncoded()).toString(16);
					
					// Pin it!
					final boolean expected = PUB_KEY.equalsIgnoreCase(encoded);
					
					if (!expected) {
						throw new CertificateException("Could not establish SSL connection");
					}
				}
				
				@Override
				public X509Certificate[] getAcceptedIssuers() { return null; }
			} 
		};

		// Install the all-trusting trust manager
		final SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
		
		// Create an ssl socket factory with our all-trusting manager
		final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

		URI uri = new URI("https", "secure.lan", "/index.php", "data="+data, null);
		URL obj = uri.toURL();
		
		// Open the connection and check for our specific SSL certificate
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();	
		((HttpsURLConnection)con).setSSLSocketFactory(sslSocketFactory);
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
				   
		return responseCode;
	}
}
