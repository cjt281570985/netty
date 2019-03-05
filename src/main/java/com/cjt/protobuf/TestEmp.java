package com.cjt.protobuf;


/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-06-03 15:24
 */
public class TestEmp {

  public static void main(String[] args) throws Exception{

    EmpInfo.Employee employee = EmpInfo.Employee.newBuilder().setName("吉米").setAge(22).setSex("男").build();
    byte[] toByteArray = employee.toByteArray();

    EmpInfo.Employee emp = EmpInfo.Employee.parseFrom(toByteArray);
    System.out.println(emp);
    System.out.println(emp.getName());
    System.out.println(emp.getAge());
    System.out.println(emp.getSex());

  }

}
