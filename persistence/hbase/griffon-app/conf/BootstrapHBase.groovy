import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.HTableDescriptor
import org.apache.hadoop.hbase.HColumnDescriptor
import org.apache.hadoop.hbase.client.HBaseAdmin
import org.apache.hadoop.hbase.client.HTable
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.util.Bytes
import sample.Person

class BootstrapHBase {
    def init = { String configName, Configuration config ->
        HBaseAdmin hbaseAdmin = new HBaseAdmin(config)
        if(hbaseAdmin.tableExists('people')) {
            hbaseAdmin.disableTable('people')
            hbaseAdmin.deleteTable('people')
        }
        hbaseAdmin.createTable(peopleTableDescriptor())

        HTable people = new HTable(config, 'people')
        people.autoFlush = true
        [[id: 1, name: 'Danno',     lastname: 'Ferrin'],
         [id: 2, name: 'Andres',    lastname: 'Almiray'],
         [id: 3, name: 'James',     lastname: 'Williams'],
         [id: 4, name: 'Guillaume', lastname: 'Laforge'],
         [id: 5, name: 'Jim',       lastname: 'Shingler'],
         [id: 6, name: 'Alexander', lastname: 'Klein'],
         [id: 7, name: 'Rene',      lastname: 'Groeschke']].each { data ->
            Person person = new Person(data)
            byte[] rowKey = Bytes.toBytes(person.id)
            Put put = new Put(rowKey)
            put.add(Bytes.toBytes('person'), rowKey, Bytes.toBytes(Person.toJSON(person)))
            people.put(put)
        }

        people.flushCommits()
        people.close()
    }

    def destroy = { String configName, Configuration config ->
        HBaseAdmin hbaseAdmin = new HBaseAdmin(config)
        hbaseAdmin.disableTable('people')
        hbaseAdmin.deleteTable('people')
    }
    
    private HTableDescriptor peopleTableDescriptor() {
        new HTableDescriptor(
            Bytes.toBytes('people'),
            [new HColumnDescriptor('person')] as HColumnDescriptor[]    
        )
    }
} 
