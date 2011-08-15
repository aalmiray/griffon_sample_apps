package bomb

class BombController {
    def buggyAction = {
        println 1
        throw new BombException()
        println 2
    }
}