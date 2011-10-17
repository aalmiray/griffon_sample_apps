client {
    timeout = 2000
    maxConnections = 50
}
environments {
    development {
        client {
            url = 'http://localhost:8098/riak'
        }
    }
    test {
        client {
            url = 'http://localhost:8098/sample-test'
        }
    }
    production {
        client {
            url = 'http://localhost:8098/sample-prod'
        }
    }
}
