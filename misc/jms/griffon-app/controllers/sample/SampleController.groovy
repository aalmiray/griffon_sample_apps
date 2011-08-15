package sample

class SampleController {
    def jmsService

    def onReadyEnd = { app ->
        jmsService.send(service: 'listening', 1)
    }
}
