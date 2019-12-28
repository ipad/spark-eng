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

    val conf = new SparkConf()//.setAppName("stream-demo")
    conf.set("spark.app.name", "stream-demo")
    conf.set("spark.master", "local[4]")
    conf.set("spark.ui.port", "36000")

    val sc = new StreamingContext(conf, Seconds(1))

    val lines = sc.socketTextStream("hadp-dev", 7777)
    val errorLines = lines.filter(processLines(lines))
    errorLines.print()
    
    sc.start()
    sc.awaitTermination(10000)
    sc.stop()
    
  }
  def processLines(lines: DStream[String]) = {
    // Filter our DStream for lines with "error"
    lines.filter(_.contains("error"))
  }

}