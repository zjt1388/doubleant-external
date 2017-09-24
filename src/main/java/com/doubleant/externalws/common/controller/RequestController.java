package com.doubleant.externalws.common.controller;

import com.doubleant.externalws.common.AcceptSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * HTTPS POST方式接收器
 * 
 * @author xiong.hx
 * @date 2017年7月19日
 */
@Controller
@RequestMapping("/ws/api")
public class RequestController {

	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
    private String charset = "UTF-8";

	@Autowired
	public AcceptSupport acceptSupport;

	@RequestMapping(value = "/{module}/{function}", method = RequestMethod.POST)
	public String requestDo(@PathVariable String module, @PathVariable String function, HttpServletRequest request,
			HttpServletResponse response) {
    	OutputStream out = null;
		String operation = module + "_" + function;
        try {
			logger.info("{} start:", operation);
			String transMsg = this.readRequest(request, charset);
			String result = acceptSupport.acceptIn(transMsg, operation);
			response.setContentType("application/json;charset=" + charset);
            out = response.getOutputStream();
            out.write(result.getBytes(charset));
        } catch (Exception e) {
			logger.error("{} error", operation, e);
        }finally {
            try {
            	if (out != null)out.close();
            } catch (IOException e) {
				logger.error("{} error", operation, e);
            }
        }
        return null;
    }

    /**
	 * 读取http请求
	 * 
	 * @param request
	 * @param charset
	 * @return
	 * @throws IOException
	 */
    private String readRequest(HttpServletRequest request, String charset) throws IOException {
        StringBuilder str = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), charset));
        String s;
        while ((s = reader.readLine()) != null)
            str.append(s + '\n');
        reader.close();
        return str.toString();
    }

 }
