import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTests {
    private Brawler shelly;
    private Profile playerProfile;
    private Enemy enemy;
    private Location spawn;
    private Location forest;

    @Test
    void testBrawlerAttack() {
        assertFalse(shelly.attack());
    }

    @Test
    void testBrawlerLevelUp() {
        boolean leveledUp = shelly.levelUp(playerProfile, shelly);
        assertTrue(leveledUp);
        assertEquals(1, shelly.getLevel());
    }

    @Test
    void testMoveCommandValid() {
        MoveCommand moveNorth = new MoveCommand(spawn, "north");
        moveNorth.execute();
        assertEquals("Forest", forest.getName());
    }

    @Test
    void testMoveCommandInvalid() {
        MoveCommand moveWest = new MoveCommand(spawn, "west");
        moveWest.execute();
        assertEquals("Spawn Point", spawn.getName());
    }

    @Test
    void testEnemyStats() {
        assertEquals(3, enemy.getRange());
        assertEquals(800, enemy.getDamage());
        assertEquals(4000, enemy.getHp());
    }

}
