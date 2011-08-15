stackPane {
    imageView(styles: "{horizontalAlignment:'left', verticalAlignment:'top'}") {
        drawing {
            rectangle(x: 20, y: 20, width: 320, height: 240,
                      fill: "{paintType:'gradient', startX:0, startY:0, startColor:'#4444ff', endX:320, endY:240, endColor:'#000044'}",
                      stroke: "#0000aa", strokeThickness: 4, cornerRadius: 10)
        }
    }
    panel {
        button("Button 1", styles: "{color:'#ffffff', backgroundColor:'#000066', borderColor:'#0000dd'}",
               x: 30, y: 30, width: 120, height: 24)
        button("Button 2", styles: "{color:'#ffffff', backgroundColor:'#000066', borderColor:'#0000dd'}",
               x: 30, y: 60, width: 120, height: 24)
        button("Button 3", styles: "{color:'#ffffff', backgroundColor:'#000066', borderColor:'#0000dd'}",
               x: 30, y: 90, width: 120, height: 24)
    }
}
