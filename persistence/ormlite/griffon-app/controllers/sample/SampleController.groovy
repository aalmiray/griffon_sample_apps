package sample

import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager

class SampleController {
    def model

    def onStartupEnd = { app ->
        withOrmlite { String databaseName, JdbcConnectionSource connection ->
            Dao<Person, Integer> peopleDao = DaoManager.createDao(connection, Person)
            List tmpList = peopleDao.queryForAll().collect([]) { it }
            execInsideUIAsync { model.people.addAll(tmpList) }
        }
    }
}
