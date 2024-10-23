package nl.tudelft.jpacman.npc.ghost;

public class ClydeTest {

    @Test
    void testClydeFarFromPacMan() {
        /*

       Test 1: Clyde Far from Pac-Man (More than 8 Spaces Away)
Scenario: Clyde is more than 8 grid spaces away from Pac-Man.
Map Layout: Pac-Man (P) and Clyde (C) are on the same row but far apart.
Expected Behavior: Clyde should move towards Pac-Man.
*/
        GhostMapParser parser = new GhostMapParser();
        List<String> map = Arrays.asList(
            "############",
            "#P________C#",
            "############"
        );

        Level level = parser.parseMap(map);
        Player player = new PlayerFactory().createPacMan();
        level.registerPlayer(player);

        // Find Clyde
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());

        // Set Clyde's AI move direction and check if it moves toward Pac-Man
        Optional<Direction> nextMove = clyde.nextAiMove();
        assertTrue(nextMove.isPresent());
        assertEquals(Direction.LEFT, nextMove.get());
    }

}
