package app.client;

import org.springframework.stereotype.Component;

/**
 * Created by bm on 3.05.2017.
 */
@Component
public class Level3HelloClientFallback implements HelloLevel3Client {
	@Override
	public String giveMeLevel3Hello() {
		return "level 3 application is unavailable";
	}
}
