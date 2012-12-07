package org.jboss.weld.environment.se.example.numberguess

switchButtons = {
    buttonPanel.layout.next(buttonPanel)
}

application(title: 'Guess-the-number Game',
  pack: true,
  resizable: false,
  locationByPlatform: true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    migLayout layoutConstraints: 'fill'
    label text: bind{ model.challengeMessage }, constraints: 'center, span 2, grow, wrap'
    label text: bind{ model.resultMessage }, constraints: 'center, span 2, grow, wrap'
    textField(constraints: 'grow, push', columns: 20, id: 'guessField',
        text: bind('guess', target: model, mutual: true))
    panel(constraints: 'wrap', id: 'buttonPanel') {
        cardLayout()
        button guessAction,  constraints: 'card1'
        button replayAction, constraints: 'card2'
    }
    panel(constraints: 'grow, span 2') {
        migLayout layoutConstraints: 'fill'
        label 'Guesses remaining:'
        progressBar(constraints: 'push, grow', maximum: Game.MAX_NUM_GUESSES,
            value: bind{ model.remainingGuesses })
    }
}