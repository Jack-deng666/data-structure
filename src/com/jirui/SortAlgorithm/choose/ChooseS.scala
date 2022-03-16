package com.jirui.SortAlgorithm.choose


/**
 * @author jack Deng
 * @date 2022/3/14 11:06
 * @version 1.0
 */
object ChooseS {
  def main(args: Array[String]): Unit = {
    var list: Array[Int] = Array(1, 34, 56, 6, 8, 9, 43, 876)
    val ints: Array[Int] = Sort(list)
    println(ints.mkString(","))
  }

  def Sort(list:Array[Int]):Array[Int]={
    val size: Int = list.length
    for(i:Int <- 0 until(size-1)){
      var minIndex: Int = i
      for(j:Int <- i+1  until size){
        if(list(j)<list(minIndex)){
          minIndex = j
        }
      }

      if(i!=minIndex){
        val temp: Int = list(i)
        list(i) = list(minIndex)
        list(minIndex) = temp

      }
    }

    list
  }

}
