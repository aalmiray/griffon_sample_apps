import griffon.effects.Effect

class RunController {
    def model

    private parentModel
    private Class effectClass
    private target

    void mvcGroupInit(Map args) {
        parentModel = args.parentModel
        effectClass = args.effectClass
    }

    def runEffect = {
        parentModel.animating = true
        newEffect().run()
    }

    private Effect newEffect() {
        effectClass.newInstance([model.properties, target, finish] as Object[])
    }

    private finish = { t, p ->
        parentModel.animating = false
    }
}
