package sample

import org.hypergraphdb.*
import org.hypergraphdb.query.AtomTypeCondition

class SampleController {
    def model

    def onStartupEnd = { app ->
        withHypergraphdb { String databaseName, HyperGraph hg ->
            List tmpList = []
            HGSearchResult rs = hg.find(new AtomTypeCondition(Person))
            try {
                // HGSearchResult implements j.u.Iterator
                for(handle in rs) {
                    tmpList << hg.get(handle)
                }
            } finally  {
                rs.close()
            }
            
            execSync { model.people.addAll(tmpList) }
        }
    }
}
