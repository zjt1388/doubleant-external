package com.doubleant.externalws.common;

import com.doubleant.externalws.common.em.ResultCode;
import com.doubleant.externalws.common.vo.RequestVo;
import com.doubleant.externalws.common.vo.ResponseVo;
import com.doubleant.externalws.common.handler.Handler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 统一请求路由
 * 
 * @author xiong.hx
 * @date 2017年7月20日
 */
@Component(value = "requestRoute")
public class RequestRoute implements ApplicationContextAware {

	/**
	 * 所有对外接口的处理类map
	 */
	private final Map<String, Handler> handerMap = new ConcurrentHashMap<>();

	/**
	 * 接口路由
	 * 
	 * @param operation
	 * @param requestVo
	 * @return
	 * @author xiong.hx
	 */
	public ResponseVo route(String operation, RequestVo requestVo) {
		Handler handler = handerMap.get(operation);
		if (null == handler) {
			return new ResponseVo(ResultCode.ERR_OPERATION_NOT_FOUND);
		}
		ResponseVo responseVo = handler.execute(requestVo);
		return responseVo;
	}



	/**
	 * 初始化接口实现类map
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		Map<String, Handler> localMap = applicationContext.getBeansOfType(Handler.class);
		Collection<Handler> localCollection = localMap.values();
		Iterator<Handler> localIterator = localCollection.iterator();
		while (localIterator.hasNext()) {
			Handler handler = localIterator.next();
			handerMap.put(handler.getOperation(), handler);
		}
	}

}
