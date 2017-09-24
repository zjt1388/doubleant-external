package com.doubleant.externalws.common.em;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信用卡还款系统统一错误码
 * <p>
 * 本系统错误码全部使用01开头
 * </p>
 *
 * @author xiong.hx
 * @date 2017年7月26日
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ResultCode {

    SUCCESS("000000", "成功"),

    /**
     * ************* 系统异常 ******************
     */
    ERR_UNKNOW("999999", "系统繁忙，请稍后再试"),
    ERR_RPC_FAIL("999998", "远程服务调用失败"),
    ERR_RPC_TIMEOUT("999997", "远程服务调用超时"),

    /**
     * ************* 通用校验错误<0101**> ******************
     */
    ERR_EMPTY_REQUST("010100", "收到请求为空"),
    ERR_EMPTY_PARAM("010101", "必填参数为空"),
    ERR_ILLEGAL_PARAM("010102", "请求参数错误"),
    ERR_WRONG_SIGN("010103", "请求签名错误"),
    ERR_OPERATION_NOT_FOUND("010104", "接口操作未配置"),

    /**
     * ************* 用户相关<0110**> ******************
     */
    ERR_USER_NOT_ACTIVATED("011000", "用户未激活理财功能"),
    //实名认证接口返回   ---开始
    ERR_REALNAME_SSJID("011001", "该ssjId已实名开户，但实名信息不一致"),
    ERR_REALNAME_IDNO("011002", "该身份证号但实名信息不一致"),
    ERR_REALNAME_UID("011003", "该用户uid已实名开户，但实名信息不一致"),
    ERR_REALNAME_ALREADY("011004", "该用户已实名开户，实名信息一致"),
    //实名认证接口返回   ---结束


    //realName项目 实名认证接口返回   ---开始
    ERR_REALNAME_CERTIFIED("313001", "您的身份证已被绑定"),
    ERR_REALNAME_WAIT("313002", "用户未实名认证"),
    ERR_REALNAME_COMPLETE("313003", "用户已实名认证"),
    ERR_IDNO_ILLEGAL("313004", "身份证不合法"),
    ERR_REALNAME_NO_MATCH("333001", "用户实名信息不匹配"),
    ERR_REALNAME_ERROR("333002", "用户实名信息验证错误"),
    ERR_REALNAME_FAIL_TOO_MORE("313005", "您今日请求实名失败次数过多"),
    //realName项目 实名认证接口返回   ---结束

    //查询是否实名接口返回
    NEVER_REALNAME("011005", "未实名"),


    /**
     * ************* 商户相关<0111**> ******************
     */
    ERR_MERCHANT_NOT_EXIST("200100", "商户不存在"),
    ;



    /**
     * ************* 还款相关<0112**> ******************
     */

    /**
     * ************* 透传其他系统错误码  ******************
     */

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String description;

}
