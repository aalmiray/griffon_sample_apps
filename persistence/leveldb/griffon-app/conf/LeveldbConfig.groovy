database {
    delete = false
    options {
		createIfMissing = true
	}
}
environments {
    development {
        database {
            path = 'sample-dev'
        }
    }
    test {
        database {
            path = 'sample-test'
        }
    }
    production {
        database {
            path = 'sample-prod'
        }
    }
}
