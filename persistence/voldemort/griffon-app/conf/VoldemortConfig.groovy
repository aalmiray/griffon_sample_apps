client {
    config {
        bootstrapUrls = ['tcp://localhost:6666']
    }
}
environments {
    development {
        client {
            config {
                maxConnectionsPerNode = 20
            }
        }
    }
    test {
        client {
            config {
                maxConnectionsPerNode = 30
            }
        }
    }
    production {
        client {
            config {
                maxConnectionsPerNode = 50
            }
        }
    }
}
