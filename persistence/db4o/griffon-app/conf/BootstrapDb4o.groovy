import com.db4o.ObjectContainer
import sample.Person
import griffon.util.Environment

class BootstrapDb4o {
    def init = { String dataSourceName, ObjectContainer db4o ->
        db4o.store(new Person(id: 1, name: "Danno", lastname: "Ferrin"))
        db4o.store(new Person(id: 2, name: "Andres", lastname: "Almiray"))
        db4o.store(new Person(id: 3, name: "James", lastname: "Williams"))
        db4o.store(new Person(id: 4, name: "Guillaume", lastname: "Laforge"))
        db4o.store(new Person(id: 5, name: "Jim", lastname: "Shingler"))
        db4o.store(new Person(id: 6, name: "Alexander", lastname: "Klein"))
        db4o.store(new Person(id: 7, name: "Rene", lastname: "Groeschke"))
    }

    def destroy = { String dataSourceName, ObjectContainer db4o ->
        if(Environment.current != Environment.PRODUCTION) {
            db4o.query(Person).each { db4o.delete it }
        }
    }
} 
