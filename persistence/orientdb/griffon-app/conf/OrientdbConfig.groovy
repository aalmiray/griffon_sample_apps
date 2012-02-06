database {
    username = 'admin'
    password = 'admin'
    type     = 'document' // accepted values are 'document', 'object'
}
environments {
    development {
        database {
            url = 'local:/tmp/sample-dev'
        }
    }
    test {
        database {
            url = 'local:/temp/sample-test'
        }
    }
    production {
        database {
            url = 'local:/orient/databases/sample-prod'
        }
    }
}
