package com.jirui.SortAlgorithm.bubble


/**
 * @author jack Deng
 * @date 2022/3/14 11:40
 * @version 1.0
 */
object BubbleS {

  def main(args: Array[String]): Unit = {
    var list: Array[Int] = Array(1, 34, 56, 6, 8, 9, 43, 876)
    val ints: Array[Int] = Sort(list)
    println(ints.mkString(","))
  }
  def Sort(list: Array[Int]):Array[Int]={
    val size: Int = list.length
    for(i:Int <-0 until size){
      for(j:Int <- i until(size-1-i)){
        if(list(j)>list(j+1)){
          val temp: Int = list(j)
          list(j) = list(j+1)
          list(j+1) = temp
        }
      }
    }


    list
  }

}
