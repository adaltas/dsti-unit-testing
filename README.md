# DSTI

## Unit Testing Lab

In this exercise, we will be implementing unit tests of HBase's JAVA API.

[HBase](http://hbase.apache.org/) is the key/value distributed database of the [Hadoop](https://hadoop.apache.org/) ecosystem. Imagine you work in a company that needs to use HBase and want to perform unit testing of this database.

HBase is easy to use but can be quite complex to deploy.

Before to start writing unit tests, we need to have an HBase service up and running to try our tests against.

This HBase can be in multiple forms:
- A fully deployed HBase cluster over a distributed Big Data architecture.
- A local VM based HBase cluster: this is the closest we will be to a production environment.
- An "mini" HBase process embedded inside a Java code.

The easiest way is to embed the HBase process in our Java code, this is what we are going to do.

The following code sample can be found in `src/main/java/com.adaltas.examples/TestCreateTableClass`:

```java
package com.adaltas.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.io.compress.Compression;

import static org.junit.Assert.assertEquals;

public class TestCreateTableClass
{
    private final static String tableName = "myTable";

    public static void main( String[] args ) throws Exception {

        //Start the "mini cluster"
        /*...*/

        //Get the configuration
        //Configuration conf =

        //Instantiate a connection
        Connection connection = ConnectionFactory.createConnection(conf);

        //Define table "myTable"
        HTableDescriptor table = new HTableDescriptor(TableName.valueOf(tableName));
        table.addFamily(new HColumnDescriptor("cf1").setCompressionType(Compression.Algorithm.NONE));

        //Create table "myTable"
        connection.getAdmin().createTable(table);

        //Get the first (and only) table name
        String first_table = connection.getAdmin().listTableNames()[0].getNameAsString();

        //Verify the returned Table name is equal to the table name we provided
        assertEquals(tableName, first_table);

        //Insert a value with a key in "myTable"
        /*...*/

        //Get the value from "myTable" with the key
        /*...*/

        //Verify the returned value is equal to the value you created
        /*...*/

        //Stop the mini cluster
        /*...*/
    }
}
```

It is incomplete and you need to fill the missing block codes.

### Step 1

The first thing to do is to get the "mini" HBase running. To find out how to do it, check how testing is done in the HBase [Source code](https://github.com/apache/hbase).

### Step 2

Once this is done, try to run the code with the sample test in the code. This test creates a table in the HBase database. It then lists all tables (there is only one since we just launched the cluster) and asserts that the table name is correct.

The line `assertEquals(tableName, first_table);` is the actual unit test result. We make sure that the table we created has the name which we wanted it to have.

### Step 3

Go ahead and write another test in which you will put a value in the HBase table that we created, then get this value in another variable and finally assert that the returned value is equal to the written value.
