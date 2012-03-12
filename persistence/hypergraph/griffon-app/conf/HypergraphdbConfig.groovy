database {
    configuration {
        // any property that can be set on org.hypergraphdb.HGConfiguration, for example
        skipOpenedEvent = true
    }
}
environments {
    development {
        database {
            location = 'sample-dev'
        }
    }
    test {
        database {
            location = 'sample-test'
        }
    }
    production {
        database {
            location = 'sample-prod'
        }
    }
}
