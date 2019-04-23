package com.cjt.netty.tcp.chaibao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-17 9:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProtocol {

  private int length;

  private byte[] content;

}
