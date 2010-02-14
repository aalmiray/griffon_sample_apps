class NController {
    def onStartupEnd = { app ->
        // tx1
        withNeo4j { db, index ->
            def andy = db.createNode()
            def larry = db.createNode()
            // andy.setProperty( "name", "Andy Wachowski" )
            // andy.setProperty( "title", "Director" )
            // larry.setProperty( "name", "Larry Wachowski" )
            // larry.setProperty( "title", "Director" )
            andy['name"'] = "Andy Wachowski"
            andy['title'] = "Director"
            larry['name'] = "Larry Wachowski"
            larry['title'] = "Director"
            andy.indexBy(['name', 'title'])
            larry.indexBy(['name', 'title'])
            def isBrother = andy.relate(MyRelationshipType.KNOWS, larry)
            println isBrother 
        }
        // tx2
        withNeo4j { db, index ->
            def node = index.getSingleNode("name", "Andy Wachowski")
            assert node.getProperty('name') == 'Andy Wachowski'
            assert node['name'] == 'Andy Wachowski'
        }
    }
}
