package com.doubleant.externalws.user.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author 张敏.
 * @Date 2017/7/21 14:34.
 * @Email Jetman_zhang@kingdee.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SsjInfoReqDTO implements Serializable{


    private static final long serialVersionUID = 9142163513936942391L;
    /**
     * 随手记id
     */
    private String ssjId;
}
