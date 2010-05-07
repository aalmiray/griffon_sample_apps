import math.Calculator

class CalculatorController {
    def model
    Calculator calculator

    def add = {
        model.enabled = false
        doOutside {
            try {
                Double a = Double.valueOf(model.numbera)
                Double b = Double.valueOf(model.numberb)
                def result = calculator.add(a, b)
                edt { model.result = result }
            } finally {
                edt { model.enabled = true }
            }
        }
    }
}
