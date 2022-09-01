# read-resources

`read-resources` is a demo project showing how to read files out of a project's resources directory, whether the directory exists on disk or is stored within a jar file.

## How to run

To run, simply execute:

~~~shell
./gradlew run
~~~

This option will read files in the resources directory as it exists on disk.
You should see output similar to:

~~~shell
./gradlew run
> Task :run
/migrations/create.js
/migrations/create2.js
/migrations/create3.js
~~~

If you want read files from the jar you will first need to assemble the jar file using:

~~~shell
./gradlew assemble
~~~

Then, move to the `build/libs` directory, download the [Kotlin 1.7.10 stdlib jar](https://repo1.maven.org/maven2/org/jetbrains/kotlin/kotlin-stdlib/1.7.10/kotlin-stdlib-1.7.10.jar), place it in the same directory, and run:

~~~shell
java -cp "read-resources-0.0.1-SNAPSHOT.jar;kotlin-stdlib-1.7.10.jar" com.lesserwhirls.demo.rr.ReadResourceKt
~~~

If all goes well, you should see the following output:

~~~shell
> java -cp "read-resources-0.0.1-SNAPSHOT.jar;kotlin-stdlib-1.7.10.jar" com.lesserwhirls.demo.rr.ReadResourceKt
/migrations/create.js
/migrations/create2.js
/migrations/create3.js
~~~
