package zioo.top.deuc.web.api.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import zioo.top.educ.api.HelloService;

@RestController
public class HelloController {
	
	@Reference
	HelloService helloService;
	
	@RequestMapping("/hello")
	public List<String> hello() {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			result.add(helloService.sayHello("test" + ('a' + i)));
		}
		return result;
	}
}
