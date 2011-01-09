package sample

application(title: 'sample',
  size: [800, 600],
  icon: 'griffon-icon-48x48.png',
  icons: ['griffon-icon-48x48.png',
          'griffon-icon-32x32.png',
          'griffon-icon-16x16.png']) {
    app.game.onRender = { container, g ->
        model.with {
            land.draw(0, 0)
            plane.draw(x, y, scale)
        }
    }
}
