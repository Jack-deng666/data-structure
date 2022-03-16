package com.jirui.SortAlgorithm.bubble

/**
 * @author jack Deng
 * @date 2022/3/14 10:30
 * @version 1.0
 */
object BubbleS_W {
  def main(args: Array[String]): Unit = {
    val list: Array[Int] = Array(1, 34, 56, 6, 8, 9, 43, 876)
    val ints: Array[Int] = Sort(list)
    println(ints.mkString(","))
  }

  def Sort(list:Array[Int]): Array[Int] ={
    val size: Int = list.length
    for(i:Int <- 0 until size){
      for(j <- i until size){
        if(list(i)>list(j)){
          val temp: Int = list(i)
          list(i) = list(j)
          list(j) = temp
        }
      }
    }
    list
  }

}
