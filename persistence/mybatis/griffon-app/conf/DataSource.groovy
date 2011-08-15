dataSource {
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
environments {
    development {
        dataSource {
            dbCreate = 'create' // one of ['create', 'skip']
            url = 'jdbc:h2:mem:mybatis-sample-dev'
        }
    }
    test {
        dataSource {
            dbCreate = 'create'
            url = 'jdbc:h2:mem:mybatis-sample-test'
        }
    }
    production {
        dataSource {
            dbCreate = 'skip'
            url = 'jdbc:h2:mem:mybatis-sample-prod'
        }
    }
}
