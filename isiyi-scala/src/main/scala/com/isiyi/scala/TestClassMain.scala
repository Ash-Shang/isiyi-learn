package com.isiyi.scala

class TestClassMain {
  def testPrint(msg: String): Unit ={
    println(msg)
  }
}

object ClassMain{
  def main(args: Array[String]): Unit = {
    var t = new TestClassMain();
    t.testPrint("hello world")
  }
}
