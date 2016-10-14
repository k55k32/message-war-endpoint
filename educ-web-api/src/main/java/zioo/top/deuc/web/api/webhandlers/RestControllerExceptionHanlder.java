package zioo.top.deuc.web.api.webhandlers;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.dubbo.rpc.RpcException;

import zioo.educ.commons.entity.Result;
import zioo.top.educ.api.service.exceptions.AppException;

@RestControllerAdvice
public class RestControllerExceptionHanlder{

	@ExceptionHandler(Exception.class)
	public Result resolveException(Exception ex) {
		Result result = new Result();
		result.setSuccess(false);
		AppException appEx;
		if (ex instanceof AppException) {
			appEx = (AppException) ex;
		} else if (ex instanceof MethodArgumentNotValidException){
			MethodArgumentNotValidException vaildEx = (MethodArgumentNotValidException) ex;
			String errorMsg = vaildEx.getBindingResult().getFieldError().getDefaultMessage();
			appEx = new AppException(AppException.PARAMS_ERROR, errorMsg);
		} else if (ex instanceof RpcException) {
			if (ex.getCause() instanceof ConstraintViolationException) {
				ConstraintViolationException consEx= (ConstraintViolationException) ex.getCause();
				ConstraintViolation<?> v = consEx.getConstraintViolations().iterator().next();
				appEx = new AppException(AppException.PARAMS_ERROR, v.getMessage());
			} else {
				ex.printStackTrace();
				appEx = new AppException(AppException.UNKNOW_EXCEPTION);
			}
		}else {
			ex.printStackTrace();
			appEx = new AppException(AppException.UNKNOW_EXCEPTION);
		}
		result.setCode(appEx.getCode());
		result.setMsg(appEx.getMessage());
		return result;
	}

}
