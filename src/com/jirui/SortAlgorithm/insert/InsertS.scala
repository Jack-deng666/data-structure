package com.jirui.SortAlgorithm.insert

/**
 * @author jack Deng
 * @date 2022/3/14 14:20
 * @version 1.0
 */

/**
 * 插入排序犹如打扑克牌，遍历每一个元素直接插到合适的位置
 */
object InsertS {
  def main(args: Array[String]): Unit = {
    var list: Array[Int] = Array(1, 34, 56, 6, 8, 9, 43, 876)
    val ints: Array[Int] = Sort(list)
    println(ints.mkString(","))

  }
  def Sort(list: Array[Int]):Array[Int]={
    for(i:Int <- list.indices){
      val tmp: Int = list(i)
      var j:Int = i
      while(j>0 && tmp<list(j-1)){
        list(j) = list(j-1)
        j-=1
      }
      if(i!=j){
        list(j) = tmp
      }
    }
    list
  }

}
