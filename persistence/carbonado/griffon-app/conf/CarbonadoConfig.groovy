dataSource {
    pooled = false
    driverClassName = 'org.h2.Driver'
    username = 'sa'
    password = ''
    tokenizeddl = false // set this to true if using MySQL or any other
                        // RDBMS that requires execution of DDL statements
                        // on separate calls
}
pool {
    maxWait = 60000
    maxIdle = 5
    maxActive = 8
}

berkeleydb {
    environmentHomeFile = new File('.', 'carbonado-carbonado-sample')
    transactionWriteNoSync = true
}

map {
    name = 'carbonado-sample'
}

environments {
    development {
        dataSource {
            name = 'carbonado-sample-dev'
            dbCreate = "create" // one of ['create', 'skip']
            url = "jdbc:h2:mem:carbonado-sample-dev"
        }
        berkeleydb {
            name = 'carbonado-sample-dev'
        }
    }
    test {
        dataSource {
            name = 'carbonado-sample-test'
            dbCreate = "create"
            url = "jdbc:h2:mem:carbonado-sample-test"
        }
        berkeleydb {
            name = 'carbonado-sample-test'
        }
    }
    production {
        dataSource {
            name = 'carbonado-sample-prod'
            dbCreate = "skip"
            url = "jdbc:h2:file:carbonado-sample-prod;shutdown=true"
        }
        berkeleydb {
            name = 'carbonado-sample-prod'
        }
    }
}
