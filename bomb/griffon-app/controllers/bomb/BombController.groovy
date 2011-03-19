package bomb

class BombController {
    def buggyAction = {
        throw new BombException()
    }
}