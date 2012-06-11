import javax.persistence.EntityManager
import sample.Person

class BootstrapJpa {
    def init = { String persistenceUnit, EntityManager em ->
        em.getTransaction().begin()
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
            em.persist(new Person(data))
        }
        em.getTransaction().commit()
    }

    def destroy = { String persistenceUnit, EntityManager em ->
    }
} 
