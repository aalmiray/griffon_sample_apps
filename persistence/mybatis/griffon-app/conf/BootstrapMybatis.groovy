import org.apache.ibatis.session.SqlSession
import sample.Person
import sample.mappers.PersonMapper

class BootstrapMybatis {
    def init = { String dataSourceName, SqlSession session ->
        PersonMapper personMapper = session.getMapper(PersonMapper)
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
            Person person = new Person()
            data.each { propName, propValue ->
                person[propName] = propValue
            }
            personMapper.insert(person)
        }
    }

    def destroy = { String dataSourceName, SqlSession session ->
    }
} 
