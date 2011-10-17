import com.db4o.config.EmbeddedConfiguration

dataSource {
    delete = true
}
environments {
    development {
        dataSource {
            name = "sample-dev.yarv"
        }
    }
    test {
        dataSource {
            name = "sample-test.yarv"
        }
    }
    production {
        dataSource {
            name = "sample-prod.yarv"
            delete = false
        }
    }
}

def configure(EmbeddedConfiguration configuration) {
    // empty
}
