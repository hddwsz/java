package com.itheima.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionResolver implements HandlerExceptionResolver {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class); 
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		//debug日志
		logger.debug("hello,我们测试一下debug日志...");
		//打印错误消息
		logger.info("系统已经发生异常,进入到全局异常处理器");
		//写日志
		logger.error("下面是错误的内容:",e);
		//发邮件
		//发短信
		//返回错误页面
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", e.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
