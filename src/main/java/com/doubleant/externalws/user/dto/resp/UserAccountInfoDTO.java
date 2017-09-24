package com.doubleant.externalws.user.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户是否开户信息
 * @Author 张敏.
 * @Date 2017/7/21 14:40.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccountInfoDTO {

    public static final int IS_OPEN = 1;//已开户
    public static final int IS_NOT_OPEN = 0;//未开户

    /**
     * 随手记id
     */
    private String ssjId;
    /**
     * 是否开户
     */
    private Integer isOpenAccount;
}
