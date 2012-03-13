package sample

import com.amazonaws.*
import com.amazonaws.services.simpledb.AmazonSimpleDB
import com.amazonaws.services.simpledb.model.*

class SampleController {
    def model

    def onStartupEnd = { app ->
        List tmpList = []
        withSimpledb { String databaseName, AmazonSimpleDB client ->
            String selectExpression = 'select * from `people`'
            SelectRequest selectRequest = new SelectRequest(selectExpression)
            for (Item item : client.select(selectRequest).getItems()) {
                Person person = new Person()
                for (Attribute attribute : item.getAttributes()) {
                    person[attribute.name] = attribute.value
                }
                tmpList << person
            }
        }
        execSync { model.people.addAll(tmpList) }
    }
}
