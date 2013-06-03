import org.skife.jdbi.v2.DBI
import sample.PersonDAO

class BootstrapJdbi {
    def init = { String dataSourceName, DBI dbi ->
        PersonDAO dao = dbi.open(PersonDAO)
        dao.create(1, 'Danno', 'Ferrin')
        dao.create(2, 'Andres', 'Almiray')
        dao.create(3, 'James', 'Williams')
        dao.create(4, 'Guillaume', 'Laforge')
        dao.create(5, 'Jim', 'Shingler')
        dao.create(6, 'Alexander', 'Klein')
        dao.create(7, 'Rene', 'Groeschke')
    }

    def destroy = { String dataSourceName, DBI dbi ->
    }
}