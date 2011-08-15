import org.neo4j.kernel.EmbeddedGraphDatabase

class BootstrapNeo4j {
    def init = { EmbeddedGraphDatabase db -> 
    }

    def destroy = { EmbeddedGraphDatabase db ->
    }
} 
