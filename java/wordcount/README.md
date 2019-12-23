# 1. compile 
```shell
> mvn clean package
```

# 2. run & execute
```shell

# she model like as :
#> bin/spark-submit \
# --class class-name \
#   target-submited.jar \
#   input-file \
#   ouput-dir
> /usr/local/spark/bin/spark-submit --class com.devel.wordcount.WordCount target/wordcount-1.0-SNAPSHOT.jar /usr/local/spark/README.md output
```
