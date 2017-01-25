package com.test;
public class MyTestHarness {
  public void writeString() {
    //object creation
// MySuper object = new MySuper();
MySuper object = new MySub();
    System.out.println(object.buildString("0,"));
  }
}