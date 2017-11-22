package com.yujun.firststep;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yujun.firststep.web.exceptions.MyException;
import com.yujun.firststep.web.response.error.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ModelAndView handle(HttpServletRequest request, Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("requestUrl", request.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
	
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	public ErrorInfo<String> handleMyException(HttpServletRequest request, MyException e){
		ErrorInfo<String> errorInfo = new ErrorInfo<String>();
		errorInfo.setCode(ErrorInfo.ERROR_CODE);
		errorInfo.setMessage(e.getMessage());
		errorInfo.setData("return json test");
		return errorInfo;
	}
}
