import org.pushingpixels.trident.Timeline

width = 420
height = 420

application(title: 'TransitionPicker',
  pack: true,
  resizable: false,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    panel(constraints: NORTH) {
        gridLayout(cols: 1, rows: 2)
        comboBox(id: 'cc', items: model.transitions)
        textField(id: 'code', editable: false, text: bind(source: cc, sourceProperty: "selectedIndex",
            converter: { v -> model.code[v] }))
    }
    panel(constraints: SOUTH, id: 'cards', size: [width, height], preferredSize: [width, height]) {
        transitionLayout(defaultDuration: 1500L, mirrorTransition: false, defaultTransition: bind(source: cc, sourceProperty: "selectedItem"))
        canvas(constraints: [name: 'page0'], optimize: false) {
            group(bc: 'none') {
                antialias true
                rect(x: 0, y: 0, w: bind{ cards.width }, h: bind{ cards.height }) {
                    gradientPaint(color2: color('red'))
                }
                text(x: 0, y: 0, cx: bind{ cards.width/2 }, cy: bind{ cards.height/2 }, text: 'A', f: color('white')) {
                    font(face: "Helvetica", size: (3*cards.width)/4)
                }
            }
        }
        canvas(constraints: [name: 'page1'], optimize: false) {
            group(bc: 'none') {
                antialias true
                rect(x: 0, y: 0, w: bind{ cards.width }, h: bind{ cards.height }) {
                    gradientPaint(x1: 100, x2: 0, color2: color('blue'))
                }
                text(x: 0, y: 0, cx: bind{ cards.width/2 }, cy: bind{ cards.height/2 }, text: 'B', f: color('white')) {
                    font(face: "Helvetica", size: (3*cards.width)/4)
                }
            }
        }
    }
    anim = timeline(loop: 'reverse', duration: 2000L) {
        timelineCallback {
            timelineStateChanged { oldState, newState, fraction, position ->
                switch(newState) {
                    case Timeline.TimelineState.PLAYING_FORWARD:
                        cards.layout.show(cards, 'page1')
                        break
                    case Timeline.TimelineState.PLAYING_REVERSE:
                        cards.layout.show(cards, 'page0')
                        break
                }
            }
        }
    }
    swingRepaintTimeline(cards, loop: true)
}
