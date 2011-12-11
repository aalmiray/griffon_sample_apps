database {
    host = "localhost"
    port = 5984
    username = ""
    password = ""
}
environments {
    development {
        database {
            datastore = "sample-dev"
        }
    }
    test {
        database {
            datastore = "sample-test"
        }
    }
    production {
        database {
            datastore = "sample-prod"
        }
    }
}
