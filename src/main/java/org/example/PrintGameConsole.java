package org.example;

import java.util.List;

public class PrintGameConsole {
    public static void printGame(int quantityMistake, int quantityAttempt, List<String> guessedWord) {
        System.out.printf("""
                Количество ошибок: %d/%d
                Текущее слово: %s
                
                """, quantityMistake, quantityAttempt, String.join("", guessedWord));
    }

    public static void printEndScreen(GameState gameState, Word word) {
        if (gameState == GameState.WINNING) {
            System.out.println("Вы угадали слово! Конец игры.");
        } else {
            System.out.printf("""
                    Слово: %s
                    Вы не угадали слово! Конец игры.
                    """, word.getWord());
        }
    }
}
