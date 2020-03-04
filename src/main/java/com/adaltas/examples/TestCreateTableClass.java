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
        //Configuration conf = ...

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
        assertEquals(tableName,first_table);

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
