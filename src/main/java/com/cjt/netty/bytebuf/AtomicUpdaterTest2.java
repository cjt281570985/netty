package com.cjt.netty.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-26 0:47
 */
public class AtomicUpdaterTest2 {

  public static void main(String[] args) {
    Student student = new Student();
    AtomicIntegerFieldUpdater<Student> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater
        .newUpdater(Student.class, "age");

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
        try {
          Thread.sleep(310);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(student));
      });

      thread.start();
    }
  }
}

class Student {
  volatile int age = 1;
}
