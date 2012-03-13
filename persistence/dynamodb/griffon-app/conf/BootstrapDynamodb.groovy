import com.amazonaws.*
import com.amazonaws.services.dynamodb.AmazonDynamoDBClient
import com.amazonaws.services.dynamodb.model.*

class BootstrapDynamodb {
    def init = { String clientName, AmazonDynamoDBClient client ->
        setupTable(client, 'people')

        [[id: '1', name: 'Danno',     lastName: 'Ferrin'],
         [id: '2', name: 'Andres',    lastName: 'Almiray'],
         [id: '3', name: 'James',     lastName: 'Williams'],
         [id: '4', name: 'Guillaume', lastName: 'Laforge'],
         [id: '5', name: 'Jim',       lastName: 'Shingler'],
         [id: '6', name: 'Alexander', lastName: 'Klein'],
         [id: '7', name: 'Rene',      lastName: 'Groeschke']].each { data ->
            Map<String, AttributeValue> person = newPerson(data)
            client.putItem(new PutItemRequest('people', person))
        }
    }

    def destroy = { String clientName, AmazonDynamoDBClient client ->
        for(i in ['1', '2', '3', '4', '5', '6', '7']) {
            Key key = new Key(new AttributeValue(i))
            client.deleteItem(new DeleteItemRequest('people', key))
        }
    }
    
    private void setupTable(AmazonDynamoDBClient client, String tableName) {
        if(!(tableName in client.listTables().tableNames)) {
            CreateTableRequest createTableRequest = new CreateTableRequest()
                    .withTableName(tableName)
                    .withKeySchema(new KeySchema(new KeySchemaElement().withAttributeName("id").withAttributeType("S")))
                    .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(10L).withWriteCapacityUnits(10L))
            client.createTable(createTableRequest)
        }
        waitForTableToBecomeAvailable(client, tableName)    
    }

    private static void waitForTableToBecomeAvailable(AmazonDynamoDBClient client, String tableName) {
        System.out.println("Waiting for " + tableName + " to become ACTIVE...");

        long startTime = System.currentTimeMillis();
        long endTime = startTime + (10 * 60 * 1000);
        while (System.currentTimeMillis() < endTime) {
            try {
                DescribeTableRequest request = new DescribeTableRequest().withTableName(tableName);
                TableDescription tableDescription = client.describeTable(request).getTable();
                String tableStatus = tableDescription.getTableStatus();
                System.out.println("  - current state: " + tableStatus);
                if (tableStatus.equals(TableStatus.ACTIVE.toString())) return;
            } catch (AmazonServiceException ase) {
                if (ase.getErrorCode().equalsIgnoreCase("ResourceNotFoundException") == false) throw ase;
            }
            try {Thread.sleep(1000 * 20);} catch (Exception e) {}
        }

        throw new RuntimeException("Table " + tableName + " never went active");
    }

    private static Map<String, AttributeValue> newPerson(Map data) {
        Map<String, AttributeValue> person = [:]
        for(entry in data) {
            person[entry.key] = new AttributeValue(entry.value)
        }
        person
    }
} 
