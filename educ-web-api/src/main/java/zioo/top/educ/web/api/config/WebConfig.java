package zioo.top.educ.web.api.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import zioo.top.deuc.web.api.interceptors.AuthInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan({"zioo.top.deuc.web.api.interceptors", "zioo.top.deuc.web.api.webhandlers"})
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Resource
	AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
}
