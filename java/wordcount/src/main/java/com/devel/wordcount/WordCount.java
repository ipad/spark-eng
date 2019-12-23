package com.devel.wordcount;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

// import scala.Function2;
import scala.Tuple2;

// import scala.collection.mutable.Iterable;

// import scala.collection.Iterable;

/**
 * Hello world!
 *
 */
public class WordCount {
    public static void main(final String[] args) {

        System.out.println("Hello World!");
        final SparkConf conf = new SparkConf().setAppName("wordCount");
        final JavaSparkContext sc = new JavaSparkContext(conf);

        final String inputFile = args[0];
        final JavaRDD<String> input = sc.textFile(inputFile);

        final JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {

            public Iterator<String> call(final String x) {

                return Arrays.asList(x.split(" ")).iterator();
            }

        });

        JavaPairRDD<String, Integer> counts = words.mapToPair(new PairFunction<String, String, Integer>() {

            public Tuple2<String, Integer> call(String x) throws Exception {
                return new Tuple2<String, Integer>(x, 1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {

            /**
             *
             */
            private static final long serialVersionUID = -6089572010467649940L;

            public Integer call(Integer x, Integer y) {
                return x + y;
            }
        });

        String outFile = args[1];
        counts.saveAsTextFile(outFile);
    }
}
