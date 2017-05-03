package app.client;

import org.springframework.stereotype.Component;

/**
 * Created by bm on 2.05.2017.
 */
@Component
public class Level2HelloClientFallback implements Level2HelloClient {
	@Override
	public String giveMeHigh5() {
		return "level 2 service is unable to give you high5";
	}

	@Override
	public String hello2() {
		return "level 2 is unavailable";
	}
}
