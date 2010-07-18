application {
	title="Effects"
	startupGroups=["effects"]
	autoShutdown=true
}
mvcGroups {
	Drop {
		model="DropModel"
		view="DropView"
	}
	Misc {
		model="MiscModel"
		view="MiscView"
	}
	Scale {
		model="ScaleModel"
		view="ScaleView"
		controller="RunController"
	}
	Bounds {
		model="BoundsModel"
		view="BoundsView"
		controller="RunController"
	}
	Resize {
		model="ResizeModel"
		view="ResizeView"
		controller="RunController"
	}
	Move {
		model="MoveModel"
		view="MoveView"
		controller="RunController"
	}
	effects {
		model="EffectsModel"
		view="EffectsView"
		controller="EffectsController"
	}
}
