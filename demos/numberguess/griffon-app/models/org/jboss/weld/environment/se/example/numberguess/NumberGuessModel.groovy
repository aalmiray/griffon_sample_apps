package org.jboss.weld.environment.se.example.numberguess

import groovy.beans.Bindable

@Bindable
class NumberGuessModel {
    String challengeMessage = ''
    String resultMessage = ''
    String guess = ''
    int remainingGuesses = Game.MAX_NUM_GUESSES
}