package com.doubleant.externalws.common.em;

/**
 * 接口操作方法枚举类
 * 
 * @author zhoujt
 * @date 2017年7月31日
 */
public enum OperationEnum {

	QUERY_PRODUCT_CLASSIFY("product_classify","查询产品分类"),

	QUERY_OPEN_ACCOUNT_STATUS("user_isOpenAccount", "查询用户开户状态"),
	MERCHANT_BALANCE("merchant_balance", "商户余额查询"),
	MERCHANT_BATCH_REMIT("remit_batchRemit","商户批量打款请求"),
	MERCHANT_REMIT_STATUS("remit_remitStatus","商户打款状态查询"),
	MERCHANT_REMIT_CHECK("remit_check","商户对账查询");

	private String code;

	private String name;

	OperationEnum() {
	}

	OperationEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
