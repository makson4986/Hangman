package org.example;

import java.util.*;

public class Game {
    private final int QUANTITY_ATTEMPT = 6;

    public void newGame() {
        int quantityMistake = 0;
        Word currentWord = new Word();
        Set<Character> introducedLetter = new HashSet<>();
        List<String> guessedWord = new ArrayList<>(Collections.nCopies(currentWord.getWord().length(), "_"));
        GameState state = GameState.RUNNING;

        while (state == GameState.RUNNING) {
            PrintGameConsole.printGame(quantityMistake, QUANTITY_ATTEMPT, guessedWord);

            char letter = InputData.inputLetter();

            if (currentWord.getWord().contains(Character.toString(letter))) {
                openGuessedLetters(letter, guessedWord, currentWord);
            } else if (!introducedLetter.contains(letter)) {
                quantityMistake++;
            }

            introducedLetter.add(letter);
            state = defineGameState(quantityMistake, guessedWord, currentWord);
        }

        PrintGameConsole.printEndScreen(state, currentWord);
    }

    public boolean suggestNewGame() {
        return InputData.inputAnswerOnSuggestGame() == GameState.RUNNING;
    }

    private GameState defineGameState(int quantityMistake, List<String> guessedWord, Word currentWord) {
        if (String.join("", guessedWord).equals(currentWord.getWord()) && quantityMistake < QUANTITY_ATTEMPT) {
            return GameState.WINNING;
        } else if (!String.join("", guessedWord).equals(currentWord.getWord()) && quantityMistake >= QUANTITY_ATTEMPT) {
            return GameState.LOSING;
        }

        return GameState.RUNNING;
    }

    private void openGuessedLetters(char letter, List<String> guessedWord, Word currentWord) {
        for (int i = 0; i < currentWord.getWord().length(); i++) {
            if (currentWord.getWord().charAt(i) == letter) {
                guessedWord.set(i, Character.toString(letter));
            }
        }
    }

}
