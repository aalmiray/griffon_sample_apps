application {
	title="WorldWind"
	startupGroups=["w"]
	autoShutdown=true
}
mvcGroups {
	w {
		model="WModel"
		controller="WController"
		view="WView"
	}
}
