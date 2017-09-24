package com.doubleant.externalws.common.handler;


import com.doubleant.externalws.common.vo.RequestVo;
import com.doubleant.externalws.common.vo.ResponseVo;

/**
 * ws接口处理类
 * 
 * @author xiong.hx
 * @date 2017年7月21日
 */
public interface Handler {

	/**
	 * 执行
	 * 
	 * @param requestVo
	 * @return
	 * @author xiong.hx
	 */
	ResponseVo execute(RequestVo requestVo);

	/**
	 * 匹配
	 * 
	 * @param operation
	 * @return
	 * @author xiong.hx
	 */
	boolean support(String operation);

	/**
	 * 获取操作名
	 * 
	 * @return
	 * @author xiong.hx
	 */
	String getOperation();

}
