package sample

class ListeningService {
    static exposes = ['jms']

     def jmsMessage(message) { 
         println message
         assert message == 1
     }
}
