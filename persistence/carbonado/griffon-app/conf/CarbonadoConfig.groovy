repository {
    type = 'map'
    jdbc {
        driverClassName = 'org.h2.Driver'
        username = 'sa'
        password = ''
        tokenizeddl = false // set this to true if using MySQL or any other
                            // RDBMS that requires execution of DDL statements
                            // on separate calls
        pool {
            maxWait = 60000
            maxIdle = 5
            maxActive = 8
        }
    }
    bdb {
        environmentHomeFile = new File('.', 'carbonado-carbonado-sample')
        transactionWriteNoSync = true
    }
    map {
        //
    }
}

environments {
    development {
        repository {
            jdbc {
                dbCreate = "create" // one of ['create', 'skip']
                url = "jdbc:h2:mem:carbonado-sample-dev"
            }
        }
    }
    test {
        repository {
            jdbc {
                dbCreate = "create"
                url = "jdbc:h2:mem:carbonado-sample-test"
            }
        }
    }
    production {
        repository {
            jdbc {
                dbCreate = "skip"
                url = "jdbc:h2:file:carbonado-sample-prod;shutdown=true"
            }
        }
    }
}
