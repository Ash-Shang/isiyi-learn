package com.isiyi.scala

object TestBibao {

  def main(args: Array[String]): Unit = {
    println( "muliplier(1) value = " +  multiplier(1) )
    println( "muliplier(2) value = " +  multiplier(2) )
  }

  var factor = 3
  var multiplier = (i: Int) => i * factor;
}
