package zioo.top.deuc.web.api.webhandlers;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import zioo.educ.commons.entity.Result;

/**
 * RestControllerAdvice
 * 用于拦截所以非 zioo.educ.commons.entity.Result 类型的返回值
 * @author Diamond
 *
 */
@ControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object>{

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		boolean flag = returnType.getGenericParameterType().equals(Result.class);
		return !flag;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		Result result = new Result();
		result.setSuccess(true);
		result.setData(body);
		return result;
	}


}
