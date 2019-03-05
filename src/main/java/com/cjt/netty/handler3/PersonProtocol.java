package com.cjt.netty.handler3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-03 17:09
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonProtocol {

  private int length;

  private byte[] content;

}
