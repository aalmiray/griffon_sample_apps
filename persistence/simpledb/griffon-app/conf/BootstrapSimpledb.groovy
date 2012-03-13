import com.amazonaws.*
import com.amazonaws.services.simpledb.AmazonSimpleDB
import com.amazonaws.services.simpledb.model.*

class BootstrapSimpledb {
    def init = { String clientName, AmazonSimpleDB client ->
        setupDomain(client, 'people')

        List<ReplaceableItem> items = []
        [[id: '1', name: 'Danno',     lastName: 'Ferrin'],
         [id: '2', name: 'Andres',    lastName: 'Almiray'],
         [id: '3', name: 'James',     lastName: 'Williams'],
         [id: '4', name: 'Guillaume', lastName: 'Laforge'],
         [id: '5', name: 'Jim',       lastName: 'Shingler'],
         [id: '6', name: 'Alexander', lastName: 'Klein'],
         [id: '7', name: 'Rene',      lastName: 'Groeschke']].each { data ->
            items << new ReplaceableItem("person_${data.id}").withAttributes(
                    new ReplaceableAttribute('id', data.id, true),
                    new ReplaceableAttribute('name', data.name, true),
                    new ReplaceableAttribute('lastName', data.lastName, true))
        }
        client.batchPutAttributes(new BatchPutAttributesRequest('people', items))
    }

    def destroy = { String clientName, AmazonSimpleDB client ->
        deleteDomain(client, 'people')
    }
    
    private void setupDomain(AmazonSimpleDB client, String domainName) {
        if(domainName in client.listDomains().domainNames) {
            deleteDomain(client, domainName)
        }
        client.createDomain(new CreateDomainRequest(domainName))
    }
    
    private void deleteDomain(AmazonSimpleDB client, String domainName) {
        client.deleteDomain(new DeleteDomainRequest(domainName))
    }
} 
