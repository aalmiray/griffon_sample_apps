package weld

import javax.inject.Inject

class WeldController {
    def model
    @Inject NorseGod thor

    def clickAction = {
        thor.act(model)
    }
}
