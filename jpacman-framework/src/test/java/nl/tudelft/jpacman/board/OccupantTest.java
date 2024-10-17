package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(!unit.hasSquare());

        /*int width = board.getWidth();
        int heigth = board.getHeigth();
        for(int x; x < width; x++){
            for(int y; y < heigth; y++){
                Ground current_square = board.SquareAt(x, y);
                List<Unit> occupants = current_square.getOccupants();
                assertThat(occupents.Contains(unit));
            }
        }
    */
    }


    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // TODO
        BasicSquare square = new BasicSquare();
        if(square.isAccessibleTo(unit)) {
            unit.occupy(square);

            // here we suposse that if the occupy method fails, the programm is interrupted
            assertThat(unit.hasSquare() && square.getOccupants().contains(unit));
        }

    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // TODO
        List <Unit> units = new ArrayList<Unit>();
        Unit element = new BasicUnit();

        units.add(element);
        units.add(unit);

        BasicSquare square = new BasicSquare();

        if(square.isAccessibleTo(unit) && square.isAccessibleTo(element) ) {
            units.get(0).occupy(square);
            units.get(1).occupy(square); // unit occupy to the square

            assertThat(unit.hasSquare() && square.getOccupants().contains(unit));
        }



    }
}
