package com.cjt.netty.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-03-06 23:53
 */
public class T {

  public static void main(String[] args) {

//    AtomicIntegerFieldUpdater<A> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater
//        .newUpdater(A.class, "age");

    A aa = new A();


    for (int i = 0; i < 10; i++) {

      Thread thread = new Thread(()->{
        try {

          Thread.sleep(50);

        } catch (Exception e) {

        }
//          System.out.println(atomicIntegerFieldUpdater.getAndIncrement(aa));
        System.out.println(aa.age2++);
      });

      thread.start();;
    }

  }
}


class A {
  int age2 = 1;
//  volatile int age = 1;
}