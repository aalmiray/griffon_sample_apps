import org.hypergraphdb.*
import org.hypergraphdb.query.AtomTypeCondition
import sample.Person

class BootstrapHypergraphdb {
    def init = { String databaseName, HyperGraph hg ->
        def people = [
            [id: 1, name: 'Danno',     lastName: 'Ferrin'],
            [id: 2, name: 'Andres',    lastName: 'Almiray'],
            [id: 3, name: 'James',     lastName: 'Williams'],
            [id: 4, name: 'Guillaume', lastName: 'Laforge'],
            [id: 5, name: 'Jim',       lastName: 'Shingler'],
            [id: 6, name: 'Alexander', lastName: 'Klein'],
            [id: 7, name: 'Rene',      lastName: 'Groeschke']
        ].collect([]) { data ->
             hg.add(new Person(data))
        }        
    }

    def destroy = { String databaseName, HyperGraph hg ->
        HGSearchResult rs = hg.find(new AtomTypeCondition(Person))
        try {
            // HGSearchResult implements j.u.Iterator
            for(handle in rs) {
                hg.remove(handle)
            }
        } finally  {
            rs.close()
        }
    }
} 
