package com.cjt.netty.bytebuf;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2019-02-26 0:47
 */
public class AtomicUpdaterTest {


  public static void main(String[] args) {

    Person person = new Person();

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
        try {
          Thread.sleep(310);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(person.age++);
      });

      thread.start();
    }


  }

}

class Person {
  int age = 1;
}
