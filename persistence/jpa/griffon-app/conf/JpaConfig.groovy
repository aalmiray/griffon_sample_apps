persistenceUnit {
    facrtory {
        // EntityManagerFactory properties go here
    }
    entityManager {
        // EntityManager properties go here
    }
}

environments {
    development {
        persistenceUnit {
        }
    }
    test {
        persistenceUnit {
        }
    }
    production {
        persistenceUnit {
        }
    }
}
