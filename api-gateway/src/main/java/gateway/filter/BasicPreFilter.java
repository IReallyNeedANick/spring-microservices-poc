package gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Service
public class BasicPreFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory
			.getLogger(BasicPreFilter.class);
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 50;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Enumeration<String> headerNames = request.getHeaderNames();
		logger.info("CALLING SERVICE URL: "+ ctx.getRequest().getRequestURI());
		return null;
	}
}
