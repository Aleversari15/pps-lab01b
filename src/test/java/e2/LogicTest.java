package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {
  private Logics l;
  private static final Pair<Integer, Integer> INITIAL_KNIGHT_POS = new Pair<>(0, 0);
  private static final Pair<Integer, Integer> INITIAL_PAWN_POS = new Pair<>(1,2);
  @BeforeEach
  public void init(){
    l = new LogicsImpl(5, INITIAL_KNIGHT_POS, INITIAL_PAWN_POS);
  }

  @Test
  public void testWin() {
    assertTrue(l.hit(INITIAL_PAWN_POS.getX(),INITIAL_PAWN_POS.getY()));
  }

  @Test
  public void testMoveNotAllowed(){
    assertFalse(l.hit(2,2));
    assertTrue(l.hasKnight(INITIAL_KNIGHT_POS.getX(),INITIAL_KNIGHT_POS.getY())); //k pos not changed
  }

  @Test
  public void testMoveAllowed(){
    l.hit(2,1); //k pos not changed
    assertFalse(l.hasKnight(INITIAL_KNIGHT_POS.getX(),INITIAL_KNIGHT_POS.getY())); //k pos should be changed
  }


}
