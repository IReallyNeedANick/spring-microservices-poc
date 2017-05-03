package app.client;

import org.springframework.stereotype.Component;

/**
 * Created by bm on 2.05.2017.
 */
@Component
public class Level2HelloClientFallback implements Level2HelloClient {
	@Override
	public String giveMeLevel2Hello() {
		return "calling 2 level service failed";
	}
}
