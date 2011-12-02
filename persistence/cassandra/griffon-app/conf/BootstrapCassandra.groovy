import groovy.sql.Sql
import griffon.util.Environment

class BootstrapCassandra {
    def init = { String dataSourceName = 'default', Sql sql ->
        [[KEY: '1', name: 'Danno', lastname: 'Ferrin'],
         [KEY: '2', name: 'Andres', lastname: 'Almiray'],
         [KEY: '3', name: 'James', lastname: 'Williams'],
         [KEY: '4', name: 'Guillaume', lastname: 'Laforge'],
         [KEY: '5', name: 'Jim', lastname: 'Shingler'],
         [KEY: '6', name: 'Alexander', lastname: 'Klein'],
         [KEY: '7', name: 'Rene', lastname: 'Groeschke']].each { data ->
            List values = data.values().collect([]) { "'" + it.toString() + "'" }
            sql.execute("INSERT INTO people (${data.keySet().join(',')}) VALUES (${values.join(',')});".toString())
        }
    }

    def destroy = { String dataSourceName = 'default', Sql sql ->
        if(Environment.current != Environment.PRODUCTION) {
            sql.execute('DROP COLUMNFAMILY people;')
        }
    }
} 
