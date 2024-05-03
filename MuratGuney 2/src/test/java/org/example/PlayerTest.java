package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer", 0);
    }

    @Test
    public void testSendMessage_initialMessage_appendsZero() {
        String result = player.sendMessage("hello");
        assertEquals("hello0", result, "Initial message should append 0.");
    }

    @Test
    public void testSendMessage_incrementingCount_correctlyAppendsCount() {
        player.sendMessage("hello"); // "hello0"
        String result = player.sendMessage("hello");
        assertEquals("hello1", result, "Second message should append 1.");
    }
}