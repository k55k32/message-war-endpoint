package zioo.top.educ.server;

import com.alibaba.dubbo.config.annotation.Service;

import zioo.top.educ.api.HelloService;

@Service
public class HelloServerImpl implements HelloService{

	public String sayHello(String say) {
		return say + "hello";
	}

}
