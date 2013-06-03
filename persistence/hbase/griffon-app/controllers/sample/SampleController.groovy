package sample

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.client.HTable
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.hbase.client.ResultScanner
import org.apache.hadoop.hbase.client.Scan
import org.apache.hadoop.hbase.util.Bytes

@griffon.plugins.hbase.HBaseAware
class SampleController {
    def model

    def onStartupEnd = { app ->
        List<Person> tmpList = []
        withHTable('people') { String configName, Configuration config, String tableName, HTable htable ->
            Scan scan = new Scan()
            ResultScanner scanner = htable.getScanner(scan)
            Result r = null
            while (((r = scanner.next()) != null)) {
                byte[] key = r.row
                byte[] personValue = r.getValue(Bytes.toBytes('person'), key)
                Person person = Person.fromJSON(Bytes.toString(personValue))
                tmpList << person
            }
            scanner.close()
        }
        execInsideUISync { model.people.addAll tmpList }
    }
}
