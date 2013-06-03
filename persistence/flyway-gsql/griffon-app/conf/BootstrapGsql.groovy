import groovy.sql.Sql

class BootstrapGsql {
    def init = { String dataSourceName = 'default', Sql sql ->
        def people = sql.dataSet('people')
        people.add(id: 1, name: 'Danno', lastname: 'Ferrin')
        people.add(id: 2, name: 'Andres', lastname: 'Almiray')
        people.add(id: 3, name: 'James', lastname: 'Williams')
        people.add(id: 4, name: 'Guillaume', lastname: 'Laforge')
        people.add(id: 5, name: 'Jim', lastname: 'Shingler')
        people.add(id: 6, name: 'Alexander', lastname: 'Klein')
        people.add(id: 7, name: 'Rene', lastname: 'Groeschke')
    }

    def destroy = { String dataSourceName = 'default', Sql sql ->
    }
}