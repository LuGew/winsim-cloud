package com.lugew.winsim.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 业务代码为String类型
 *
 * @author 夏露桂
 * @since 2021/1/16 16:37
 */
@SuperBuilder
@AllArgsConstructor
public class StringCodeResult<DATA> extends AbstractResult<String, DATA> {

}
