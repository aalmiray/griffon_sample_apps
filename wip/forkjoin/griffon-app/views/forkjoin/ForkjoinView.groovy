package forkjoin

actions {
    action(id: 'startAction',
        name: 'Start',
        enabled: bind {!model.busy},
        closure: controller.start
    )
}

application(title: 'Visualisation of merge sort using fork join',
  preferredSize: [1024, 768],
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    vbox(constraints: NORTH) {
        hbox {
            label("""
            <html><ol>
                <li>Thread takes a task from the queue. If the tasks is too big (longer than two elements) it is split to two smaller tasks</li>
                <li>Subtasks are placed to queue to be processed</li>
                <li>While the task waits for its subtasks to finish the thread goes to 1.</li>
                <li>When the subtasks are finished their results are merged.</li>
            </ol></html>
			""".stripIndent(12).trim())
        }
        panel {
            label(text: "Waiting in queue", background: ForkjoinModel.COLOR_SCHEDULED, opaque: true, border: emptyBorder(3))
            label(text: "Waiting for subtasks", background: ForkjoinModel.COLOR_WAIT, opaque: true, border: emptyBorder(3))
            label(text: "Finished", background: ForkjoinModel.COLOR_FINISHED, opaque: true, border: emptyBorder(3))
            ForkjoinModel.THREAD_COLORS.eachWithIndex {color, idx ->
                label(text: "Thread ${idx + 1}", background: color, opaque: true, border: emptyBorder(3))
            }
        }
        hbox {
            slider(minimum: 0, maximum: 1000, border: titledBorder(title: 'Speed'),
                   enabled: bind{model.busy}, value: bind('speed', source: model, mutual: true))
            slider(minimum: 1, maximum: 8, paintTicks: true, paintLabels: true, minorTickSpacing: 1,  enabled: bind{model.busy},
                   border: titledBorder(title: "Number of threads 3"), value: bind('numThreads', source: model, mutual: true),
                   stateChanged: {it.source.border.title = "Number of threads ${model.numThreads}"})
            slider(minimum: 4, maximum: 64, paintTicks: true, paintLabels: true, minorTickSpacing: 1, enabled: bind{model.busy},
                   border: titledBorder(title: 'Problem size 32'), value: bind('problemSize', source: model, mutual: true),
                   stateChanged: {it.source.border.title = "Problem size ${model.problemSize}"})
        }
        hbox {
            button(startAction)
        }
    }
    scrollPane(constraints: CENTER) {
        treemap(id: 'treemap')
    }
}
