import org.apache.pivot.collections.ArrayList as PivotArrayList

autoCompleteStates = { textInput, index, count ->
    String text = textInput.text
    int i = PivotArrayList.binarySearch(model.states, text, model.states.comparator)

    if (i < 0) {
        i = -(i + 1);
        int n = model.states.length

        if (i < n) {
            text = text.toLowerCase()
            String state = model.states[i]

            if (state.toLowerCase().startsWith(text)) {
                String nextState = (i == n - 1) ? null : model.states[i + 1]

                if (!nextState || !nextState.toLowerCase().startsWith(text)) {
                    textInput.text = state

                    int selectionStart = text.length()
                    int selectionLength = state.length() - selectionStart
                    textInput.setSelection(selectionStart, selectionLength)
                }
            }
        }
    }
}

hbox(styles: "{padding: 4, horizontalAlignment: 'left', verticalAlignment: 'top'}") {
    label('State:')
    textInput(textSize: 20) {
        textInputCharacterListener {
            onCharactersInserted(autoCompleteStates)
        }
    }
}
