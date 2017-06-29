import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bm on 2.05.2017.
 */
//@RunWith(SpringRunner.class)
public class TestRun {

//	@Autowired
//	private TestRestTemplate restTemplate;

	public static Set<String> s = new HashSet<>();
	//	@Test
	public static void main(String[] args) throws InterruptedException {
		test();
	}

	public static void test() throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJib3JpcyIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJvcmdhbml6YXRpb24iOiJBV0VTT01FIG9yZ2FuaXphdGlvbiIsImV4cCI6MzY0NjI1MTE0MSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImIxZmE0ZTAzLTRjNTUtNDZiMi05ZTZmLTE2MTgwYjljYjc3YyIsImNsaWVudF9pZCI6InRydXN0ZWRfY2xpZW50In0.WJrAnMIrN44pivk0wg9fW4wNodvFZwY5NfSIuJDTPUeHxCxH9-ltI_Ww1duB4KMowej_lYbth-RxgDXsF7dL58BqoGeKsUZlKi7XwR6R-dqhJ6xBczNxUoc-y26qnr8TnG-CSHQkKXFgkfYSDoJlh6aui-AI-vLiwu-LrfIRsG4");
		String url = "http://localhost:8080/hello-service/level1-hello";
		String url1 = "http://localhost:51229/call-another-hello";

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		for (int i = 0; i < 100000; i++) {
			new Thread(() -> {
				//Do whatever
			try {

				ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
				s.add(exchange.getBody());
				System.out.println(exchange.getBody());
			} catch (HttpServerErrorException errorException) {
				System.out.println(errorException.getStatusCode() + " " + errorException.getMessage() + " "+ errorException.getResponseBodyAsString());
				s.add(errorException.getResponseBodyAsString());
			}
			}).start();

		Thread.sleep(200);
		}
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println(s);
	}
}
