package com.jirui.likou.toNum


/**
 * @author jack Deng
 * @date 2022/3/16 18:32
 * @version 1.0
 */
object scalaDemoP {

  def main(args: Array[String]): Unit = {
    println(myAtoi("-91283472332"))
  }
  def myAtoi(s: String): Int = {
    val str:String = s.trim
    var ans:Long = 0
    var positiveNum:Boolean = true
    for(i:Int <- 0 until(str.length) ){
      val a: Char = str.charAt(i)
      if(i==0 &&(a=='+' || a=='-')){
        positiveNum = a== '+'
      }else if(Character.isDigit(a)){
        ans = ans * 10 + a - '0'
        ans = if (positiveNum) Math.min(ans, Integer.MAX_VALUE) else Math.max(ans, Integer.MIN_VALUE)

        if(ans>Integer.MAX_VALUE){
          ans = Integer.MAX_VALUE+1
        }
      }
      ans = if (positiveNum) Math.min(ans, Integer.MAX_VALUE) else Math.max(ans, Integer.MIN_VALUE)

    }

    return (if(positiveNum) ans.toInt else -ans.toInt)
  }

}
