application {
	title="Babel"
	startupGroups=["babel"]
	autoShutdown=true
}
mvcGroups {
	calculator {
		model="CalculatorModel"
		controller="CalculatorController"
		view="CalculatorView"
	}
	babel {
		model="BabelModel"
		view="BabelView"
		controller="BabelController"
	}
}
griffon {
	clojure {
		dynamicPropertyName="clj"
		injectInto=["controller"]
	}
}
