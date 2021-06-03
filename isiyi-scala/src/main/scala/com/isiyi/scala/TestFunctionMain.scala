package com.isiyi.scala


class TestFunctionMain {


}
object  TestTestFunctionMain{
  def main(args: Array[String]): Unit = {

    var res = max(1, 2)
    printMsg(res)
    var addRes = add(1,2)
    printMsg(addRes)
  }

  def max(x: Int, y: Int) = if(x > y) x else y;

  def add(x: Int, y: Int): Int = {
    var sum:Int = 0
    sum = x + y
    return sum
  }

  def printMsg(msg: Int) {
    println(msg)
  }
}
