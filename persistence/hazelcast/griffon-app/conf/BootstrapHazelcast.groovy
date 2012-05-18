import com.hazelcast.client.HazelcastClient

class BootstrapHazelcast {
    def init = { String clientName, HazelcastClient client ->
        [[id: '1', name: 'Danno',     lastname: 'Ferrin'],
         [id: '2', name: 'Andres',    lastname: 'Almiray'],
         [id: '3', name: 'James',     lastname: 'Williams'],
         [id: '4', name: 'Guillaume', lastname: 'Laforge'],
         [id: '5', name: 'Jim',       lastname: 'Shingler'],
         [id: '6', name: 'Alexander', lastname: 'Klein'],
         [id: '7', name: 'Rene',      lastname: 'Groeschke']].each { data ->
             client.getMap('people').put(data.id, data)
        } 
    }

    def destroy = { String clientName, HazelcastClient client ->
        List keys = []
        keys.addAll client.getMap('people').keySet()
        for (key in keys) client.getMap('people').remove(key)
    }
} 
