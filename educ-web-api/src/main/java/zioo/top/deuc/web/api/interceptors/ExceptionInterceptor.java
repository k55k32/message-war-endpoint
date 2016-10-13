package zioo.top.deuc.web.api.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import zioo.educ.commons.entity.Result;
import zioo.educ.commons.exceptions.AppException;

@Component
public class ExceptionInterceptor implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Result result = new Result();
		result.setSuccess(false);
		AppException appEx;
		if (ex instanceof AppException) {
			appEx = (AppException) ex;
		} else {
			appEx = new AppException(AppException.UNKNOW_EXCEPTION);
		}
		result.setCode(appEx.getCode());
		ObjectMapper om = new ObjectMapper();
		result.setMsg(appEx.getMessage());
		try {
			String json = om.writeValueAsString(result);
			response.setHeader("Content-type", "application/json;charset=UTF-8");
			response.getWriter().write(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
