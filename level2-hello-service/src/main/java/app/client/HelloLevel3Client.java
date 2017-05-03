package app.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by bm on 3.05.2017.
 */
@FeignClient(value = "level3-hello-service", fallback = Level3HelloClientFallback.class)
public interface HelloLevel3Client {
	@GetMapping(value = "/level3-hello")
	String giveMeLevel3Hello();
}
