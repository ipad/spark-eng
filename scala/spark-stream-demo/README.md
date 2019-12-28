```shell
/usr/local/spark/bin/spark-submit --class com.devel.streaming.StreamDemo target/scala-2.11/spark-streaming-example_2.11-1.0.jar --master local[4]

/usr/local/spark/bin/spark-submit --class com.devel.streaming.StreamDemo --master local[4] target/scala-2.11/spark-streaming-example_2.11-1.0.jar 
```

# 1. Fix error "zsh: no matches found: local[4]"
```shell
1> echo setopt no_nomatch >> ~/.zshrc
2> zsh
```