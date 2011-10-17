database {
    params = [:]
}
environments {
    development {
        database {
            storeDir = "neo4j/sample-dev"
        }
    }
    test {
        database {
            storeDir = "neo4j/sample-test"
        }
    }
    production {
        database {
            storeDir = "neo4j/sample-prod"
        }
    }
}
