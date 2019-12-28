package com.devel.streaming

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.Duration
import org.apache.spark.streaming.Seconds

import org.apache.spark._
import org.apache.spark.SparkContext._

object StreamDemo {

  def main(args: Array[String]){

    val conf = new SparkConf().setAppName("wordcount")
    val sc = new StreamingContext(conf, Seconds(1))

    val lines = sc.socketTextStream("hadp-dev", 7777)
    val errorLines = lines.filter(_.contains("error"))
    errorLines.print()
    
    sc.start()
    sc.awaitTermination()
  }
}