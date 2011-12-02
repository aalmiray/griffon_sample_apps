Cassandra + Griffon
===================

Make sure to create a suitable keyspace before launching the application, for example
by invoking the following command via cqlsh

    CREATE KEYSPACE cassandra_dev \
        WITH strategy_class = 'SimpleStrategy' \
        AND strategy_options:replication_factor=1;
