package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	
	private final MyLogger myLogger;
	private final LogDemoService logDemoService;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		
		String requestURL = request.getRequestURL().toString();
		myLogger.setRequestURL(requestURL);
		myLogger.log("controller test");
		logDemoService.logic("testId");
		
		return "OK";
	}
	
}
