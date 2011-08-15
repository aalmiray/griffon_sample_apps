package org.jboss.weld.environment.se.example.numberguess

import javax.inject.Inject

class NumberGuessController {
    def model
    def view

    @Inject
    private Game game

    @Inject
    private MessageGenerator msgGenerator

    void mvcGroupInit(Map<String, Object> args) {
        model.challengeMessage = msgGenerator.challengeMessage
        model.resultMessage = msgGenerator.resultMessage
        model.remainingGuesses = game.remainingGuesses
    }
    
    def guess = {
        int number = -1
        try {
            number = Integer.parseInt(model.guess)
        } catch(NumberFormatException nfe) {
            // ignore
        }
        
        game.guess = number
        game.check()
        update()
        
        if(game.gameWon || game.gameLost) {    
            execAsync { view.switchButtons() }
        }
    }

    def replay = {
        game.reset()
        update()
        execAsync { 
            model.challengeMessage = msgGenerator.challengeMessage
            view.switchButtons()
        }
    }
    
    private void update() {
        execAsync {
            model.guess = ''
            model.resultMessage = msgGenerator.resultMessage
            model.remainingGuesses = game.remainingGuesses
            view.guessField.requestFocus()
        }
    }
}