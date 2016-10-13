package zioo.top.educ.server;

import com.alibaba.dubbo.config.annotation.Service;

import zioo.top.educ.api.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello() {
		return "hello";
	}

}
