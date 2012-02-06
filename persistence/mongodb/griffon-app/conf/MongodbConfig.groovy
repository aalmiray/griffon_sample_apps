server {
    port = 27017
}
environments {
    development {
        server {
            host = 'localhost'
        }
    }
    test {
        server {
            host = 'localhost'
        }
    }
    production {
        server {
            host = 'localhost'
        }
    }
}
