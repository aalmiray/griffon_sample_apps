neo4j {
}
environments {
    development {
        neo4j {
            storeDir = "neo4j/dev"
        }
    }
    test {
        neo4j {
            storeDir = "neo4j/test"
        }
    }
    production {
        neo4j {
            storeDir = "neo4j/prod"
        }
    }
}
