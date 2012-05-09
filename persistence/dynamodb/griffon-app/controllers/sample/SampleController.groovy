package sample

import com.amazonaws.*
import com.amazonaws.services.dynamodb.AmazonDynamoDBClient
import com.amazonaws.services.dynamodb.model.*

class SampleController {
    def model

    def onStartupEnd = { app ->
        List tmpList = []
        withDynamodb { String databaseName, AmazonDynamoDBClient client ->
            ScanRequest scanRequest = new ScanRequest().withTableName("people")
            ScanResult result = client.scan(scanRequest)
            for(item in result.items) {
                tmpList << new Person(
                    id: item.id.s,
                    name: item.name.s,
                    lastName: item.lastName.s,
                )
            }
        }
        execInsideUIAsync { model.people.addAll(tmpList) }
    }
}
