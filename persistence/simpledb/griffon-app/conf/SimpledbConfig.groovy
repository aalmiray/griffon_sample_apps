client {
    credentials {
        accessKey = '*****'
        secretKey = '*****'
    }
    config {
        connectionTimeout = 30000i
    }
}
environments {
    development {
        client {
        }
    }
    test {
        client {
        }
    }
    production {
        client {
            // credentialsProvider = full.qualified.class.name
        }
    }
}
