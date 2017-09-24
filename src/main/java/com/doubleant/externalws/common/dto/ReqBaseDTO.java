package com.doubleant.externalws.common.dto;

import com.doubleant.externalws.common.vo.RequestHead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 包装请求DTO
 *
 * @author yjh (jinhong_yao@kingdee.com)
 * @version 1.0
 * @since 2017/7/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqBaseDTO<T> implements Serializable {
    private static final long serialVersionUID = -3681527942178414594L;

    private RequestHead head;

    private T body;
}
