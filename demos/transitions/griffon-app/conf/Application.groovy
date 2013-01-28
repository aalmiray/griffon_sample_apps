application {
	title="TransitionPicker"
	startupGroups=["root"]
	autoShutdown=true
}
mvcGroups {
	root {
		model="TransitionPickerModel"
		controller="TransitionPickerController"
		view="TransitionPickerView"
	}
}
