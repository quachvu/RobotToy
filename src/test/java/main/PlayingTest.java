package main;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.inter.cch.pojo.Direction;
import com.inter.cch.pojo.Position;
import com.inter.cch.pojo.SquareTable;
import com.inter.exception.RobotToyException;
import com.inter.main.PlaceObject;
import com.inter.main.Playing;
import com.inter.main.RobotToy;

public class PlayingTest {

    final int BOARD_ROWS = 5;
    final int BOARD_COLUMNS = 5;
    @Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPlacing() throws RobotToyException {

        SquareTable board = new SquareTable(BOARD_COLUMNS, BOARD_ROWS);
        RobotToy robotToy = new RobotToy();
        PlaceObject placeObject = new PlaceObject();
        Playing game = new Playing(placeObject,robotToy,board);

        Assert.assertTrue(game.initRobot(new Position(0, 1, Direction.NORTH)));
        Assert.assertTrue(game.initRobot(new Position(2, 2, Direction.SOUTH)));
        Assert.assertFalse(game.initRobot(new Position(6, 6, Direction.WEST)));
        Assert.assertFalse(game.initRobot(new Position(-1, 5, Direction.EAST)));
    }

    @Test
    public void testPlacingExceptions() throws RobotToyException {

    	SquareTable table = new SquareTable(BOARD_COLUMNS, BOARD_ROWS);
        RobotToy robotToy = new RobotToy();
        PlaceObject placeObject = new PlaceObject();
        Playing playing = new Playing(placeObject,robotToy,table);

        thrown.expect(RobotToyException.class);
        playing.initRobot(null);
        thrown.expect(RobotToyException.class);
        playing.initRobot(new Position(0, 1, null));
    }

    @Test
    public void testEvaluation() throws RobotToyException {

        SquareTable board = new SquareTable(BOARD_COLUMNS, BOARD_ROWS);
        RobotToy robotToy = new RobotToy();
        PlaceObject placeObject = new PlaceObject();
        Playing playing = new Playing(placeObject,robotToy,board);

        playing.evaluation("PLACE 0,0,NORTH");
        Assert.assertEquals("0,0,NORTH", playing.evaluation("REPORT"));

        playing.evaluation("MOVE");
        playing.evaluation("RIGHT");
        playing.evaluation("MOVE");
        Assert.assertEquals("1,1,EAST", playing.evaluation("REPORT"));

        // if it goes out of the board it ignores the command
        for (int i = 0; i < 10; i++)
            playing.evaluation("MOVE");
        Assert.assertEquals("5,1,EAST", playing.evaluation("REPORT"));

        //rotate on itself
        for (int i = 0; i < 4; i++)
            playing.evaluation("LEFT");
        Assert.assertEquals("5,1,EAST", playing.evaluation("REPORT"));

        // invalid commands
        thrown.expect(RobotToyException.class);
        Assert.assertEquals("Invalid command", playing.evaluation("PLACE12NORTH"));
        thrown.expect(RobotToyException.class);
        Assert.assertEquals("Invalid command", playing.evaluation("LEFFT"));
        thrown.expect(RobotToyException.class);
        Assert.assertEquals("Invalid command", playing.evaluation("RIGHTT"));
    }
}
