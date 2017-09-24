package com.doubleant.externalws.common.constant;

/**
 * 返回结果码
 * @author jiantao_zhou@kingdee.com
 * @create 2017-08-01 15:10
 **/
public class ResultCommonConstant {

    public static final String CODE_SUCCESS = "000000";
    public static final String MSG_SUCCESS = "成功";

    public static final String CODE_ERR_UNKNOWN = "999999";
    public static final String MSG_ERR_UNKNOWN = "服务器异常";

    public static final String CODE_NO_DATA_FOUND = "800001";
    public static final String MSG_NO_DATA_FOUND = "无数据";

    public static final String CODE_HYSTRIX_FALL_BACK_BIZCODE = "800003";
    public static final String MSG_HYSTRIX_FALL_BACK_BIZCODE = "系统繁忙，稍后再试";

    public static final String CODE_HYSTRIX_ANNOTATION_ERR_BIZCODE = "800002";
    public static final String MSG_HYSTRIX_ANNOTATION_ERR_BIZCODE = "bizCode有误";

    public static final String CODE_ERR_PARAM = "800004";
    public static final String MSG_ERR_PARAM = "参数有误";

    public static final String CODE_MERCHANT_NOT_EXIST = "200100";
    public static final String MSG_MERCHANT_NOT_EXIST = "商户不存在";

    /**
     * 服务器透传code
     */
    public static final String CODE_SERVER = "300001";
}
