package com.jirui.SortAlgorithm.fast

/**
 * @author jack Deng
 * @date 2022/3/14 17:42
 * @version 1.0
 */
object FastS {
  def main(args: Array[String]): Unit = {
    var list: Array[Int] = Array(1, 34, 56, 6, 8, 9, 43, 876)
    val ints: Array[Int] = Sort(list,0,list.length-1)
    println(ints.mkString(","))
  }
  def Sort(list:Array[Int],start:Int, end:Int):Array[Int]={
    if(start>end){
      return list
    }
    val pivot: Int = list(start)
    var i: Int = start
    var j: Int = end
    while(i<j) {
        while(i<j&& list(j)>=pivot){
          j -=1
        }
        while(i<j && list(i)<=pivot){
          i +=1
        }
        if(j>i){
          val tmp: Int = list(j)
          list(j) = list(i)
          list(i) = tmp
        }
      }
    list(start) = list(i)
    list(i) = pivot

    Sort(list,start,i-1)
    Sort(list,i+1,end)
    list
  }

}