package main;

import junit.framework.Assert;

import org.junit.Test;

import com.inter.cch.pojo.Direction;


public class DirectionTest {

    @Test
    public void testRotate() throws Exception {
        Direction direction = Direction.EAST;

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, Direction.NORTH);

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, Direction.WEST);

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, Direction.SOUTH);

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, Direction.EAST);

        direction = direction.rotateLeft();
        Assert.assertEquals(direction, Direction.NORTH);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, Direction.EAST);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, Direction.SOUTH);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, Direction.WEST);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, Direction.NORTH);

        direction = direction.rotateRight();
        Assert.assertEquals(direction, Direction.EAST);
    }
}
