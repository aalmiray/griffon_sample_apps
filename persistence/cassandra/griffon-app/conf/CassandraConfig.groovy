dataSource {
    driverClassName = 'org.apache.cassandra.cql.jdbc.CassandraDriver'
    pool {
        maxWait = 60000
        maxIdle = 5
        maxActive = 8
    }
}
environments {
    development {
        dataSource {
            dbCreate = 'create' // one of ['create', 'skip']
            url = 'jdbc:cassandra://localhost:9160/cassandra_dev'
        }
    }
    test {
        dataSource {
            dbCreate = 'create'
            url = 'jdbc:cassandra://localhost:9160/cassandra_test'
        }
    }
    production {
        dataSource {
            dbCreate = 'skip'
            url = 'jdbc:cassandra://localhost:9160/cassandra_prod'
        }
    }
}
