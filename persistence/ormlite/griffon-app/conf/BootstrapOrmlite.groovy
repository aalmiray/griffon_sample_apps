import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.table.TableUtils
import sample.Person

class BootstrapOrmlite {
    def init = { String databaseName, ConnectionSource connection ->
        TableUtils.createTableIfNotExists(connection, Person)
        Dao<Person, Integer> peopleDao = DaoManager.createDao(connection, Person)
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
             Person person = new Person(data)
             peopleDao.create(person)
        }
    }

    def destroy = { String databaseName, ConnectionSource connection ->
        TableUtils.dropTable(connection, Person, true)
    }
} 