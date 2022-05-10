object SparkHadoop extends App {

  import org.apache.spark.sql.SparkSession

  val spark = SparkSession
    .builder()
    .appName("Spark SQL example")
    .master("local[*]")
    .getOrCreate()

  val read = spark
    .read
    .option("header", value = true)
    .option("inferSchema", value = true)
    .format("csv")
    .load("hdfs://localhost:9000/input")

  read.show()
}
