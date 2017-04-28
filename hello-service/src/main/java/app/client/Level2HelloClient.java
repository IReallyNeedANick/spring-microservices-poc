package app.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bm on 28.04.2017.
 */
@FeignClient("level2-hello-service")
public interface Level2HelloClient {
	@RequestMapping(method = RequestMethod.GET, value = "/give-me-hello")
	String giveMeLevel2Hello();
}
