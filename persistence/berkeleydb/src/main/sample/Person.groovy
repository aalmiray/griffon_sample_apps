package sample

import com.sleepycat.persist.model.Entity
import com.sleepycat.persist.model.PrimaryKey
import com.sleepycat.je.DatabaseException
import com.sleepycat.persist.EntityCursor
import com.sleepycat.persist.EntityStore
import com.sleepycat.persist.PrimaryIndex

@Entity
class Person {
    @PrimaryKey
    Integer id
    String name
    String lastname

    static class Accessor {
        private final PrimaryIndex<Integer, Person> personById

        Accessor(EntityStore store) throws DatabaseException {
            personById = store.getPrimaryIndex(Integer, Person)
        }
        
        void save(Person person) throws DatabaseException {
            personById.put(person)
        }
        
        EntityCursor<Person> list() throws DatabaseException {
            personById.entities()
        }
    }
}
