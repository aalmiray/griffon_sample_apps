import oracle.kv.KVStore
import oracle.kv.Key
import oracle.kv.Value
import sample.Person

class BootstrapOraclekv {
    def init = { String storeName, KVStore store ->
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             String str = Person.toJSON(new Person(data))
             store.put(Key.createKey(data.id.toString()),
                       Value.createValue(str.bytes))
        }
    }

    def destroy = { String storeName, KVStore store ->
        (1..7).each { index ->
            store.delete(Key.createKey(index.toString()))
        }
    }
} 
