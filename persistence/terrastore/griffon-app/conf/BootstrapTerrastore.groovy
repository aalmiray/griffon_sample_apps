import terrastore.client.TerrastoreClient
import sample.Person

class BootstrapTerrastore {
    def init = { String clientName, TerrastoreClient client ->
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             client.bucket('people').key(data.id.toString()).put(new Person(data))
        } 
    }

    def destroy = { String clientName, TerrastoreClient client ->
        client.bucket('people').clear()
    }
} 
