import com.basho.riak.client.RiakClient
import com.basho.riak.client.RiakObject
import sample.Person
import griffon.util.Environment

class BootstrapRiak {
    def init = { String clientName, RiakClient riak ->
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             RiakObject o = new RiakObject(riak, 'people', data.id.toString())
             o.value = Person.toJSON(new Person(data))
             riak.store(o)
        }
    }

    def destroy = { String clientName, RiakClient riak ->
        if(Environment.current != Environment.PRODUCTION) {
            riak.listBucket('people').bucketInfo.keys.each { key ->
                riak.delete('people', key)
            } 
        }
    }
}