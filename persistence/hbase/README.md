Griffon + HBase
---------------

This small application shows how a Griffon application can connect to an HBase server

Configuration
-------------

The application assumes there's an HBase running at 127.0.0.1 with the following configuration

    <?xml version="1.0"?>
    <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
    <configuration>
      <property>
        <name>hbase.rootdir</name>
        <value>file:///tmp/hbase</value>
      </property>
    </configuration>

