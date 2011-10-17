import voldemort.client.StoreClient
import voldemort.client.StoreClientFactory

class BootstrapVoldemort {
    def init = { String clientName, StoreClientFactory clientFactory ->
        StoreClient people = clientFactory.getStoreClient('people')
        [[id: '1', name: 'Danno',     lastname: 'Ferrin'],
         [id: '2', name: 'Andres',    lastname: 'Almiray'],
         [id: '3', name: 'James',     lastname: 'Williams'],
         [id: '4', name: 'Guillaume', lastname: 'Laforge'],
         [id: '5', name: 'Jim',       lastname: 'Shingler'],
         [id: '6', name: 'Alexander', lastname: 'Klein'],
         [id: '7', name: 'Rene',      lastname: 'Groeschke']].each { data ->
             people.put data.id, [data]
        }
    }

    def destroy = { String clientName, StoreClientFactory clientFactory ->
        StoreClient people = clientFactory.getStoreClient('people')
        (1..7).toList()*.toString().each { key ->
            people.delete(key)
        }
    }
} 
