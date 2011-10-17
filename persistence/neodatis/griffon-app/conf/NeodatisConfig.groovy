database {
   client = false
   config { }
}
environments {
    development {
        database {
            alias = 'neodatis/sample-dev.odb'
        }
    }
    test {
        database {
            alias = 'neodatis/sample-test.odb'
        }
    }
    production {
        database {
            alias = 'neodatis/sample-prod.odb'
        }
    }
}
