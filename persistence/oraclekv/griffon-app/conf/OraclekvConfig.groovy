store {
    name = 'kvstore'
    port = 5000
}
environments {
    development {
        store {
            host = 'localhost'
        }
    }
    test {
        store {
            host = 'localhost'
        }
    }
    production {
        store {
            host = 'localhost'
        }
    }
}
