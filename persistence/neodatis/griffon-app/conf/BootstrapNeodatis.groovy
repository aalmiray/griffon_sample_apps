import org.neodatis.odb.ODB
import sample.Person

class BootstrapNeodatis {
    def init = { String databaseName, ODB odb ->
        odb.store(new Person(id: 1, name: "Danno", lastname: "Ferrin"))
        odb.store(new Person(id: 2, name: "Andres", lastname: "Almiray"))
        odb.store(new Person(id: 3, name: "James", lastname: "Williams"))
        odb.store(new Person(id: 4, name: "Guillaume", lastname: "Laforge"))
        odb.store(new Person(id: 5, name: "Jim", lastname: "Shingler"))
        odb.store(new Person(id: 6, name: "Alexander", lastname: "Klein"))
        odb.store(new Person(id: 7, name: "Rene", lastname: "Groeschke"))
    }

    def destroy = { String databaseName, ODB odb ->
    }
} 
