package sample

import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager

@griffon.plugins.ormlite.OrmliteAware
class SampleController {
    def model

    def onStartupEnd = { app ->
        withOrmlite { String databaseName, ConnectionSource connection ->
            Dao<Person, Integer> peopleDao = DaoManager.createDao(connection, Person)
            List tmpList = peopleDao.queryForAll().collect([]) { it }
            execInsideUIAsync { model.people.addAll(tmpList) }
        }
    }
}
