import net.spy.memcached.ConnectionFactoryBuilder as CFB

servers {
    'localhost' {
        port = 11211
    }
}
client {
    connectionFactory {
        protocol = CFB.Protocol.BINARY
    }
}
environments {
    production {
        client {
            connectionFactory {
                protocol = CFB.Protocol.BINARY
            }
        }
    }
}
