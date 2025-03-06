package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
  public void testMoveNotAllowed1(){
    Pair<Integer,Integer> wrongPos = new Pair<>(2, 2);
    assertAll(
            () ->  assertFalse(l.hit(wrongPos.getX(),wrongPos.getY())),
            () -> assertTrue(l.hasKnight(INITIAL_KNIGHT_POS.getX(),INITIAL_KNIGHT_POS.getY())) //k pos not changed
    );
  }

  @Test
  public void testMoveNotAllowed2(){
    Pair<Integer,Integer> wrongPos = new Pair<>(0, 1);
    assertAll(
            () ->  assertFalse(l.hit(wrongPos.getX(),wrongPos.getY())),
            () -> assertTrue(l.hasKnight(INITIAL_KNIGHT_POS.getX(),INITIAL_KNIGHT_POS.getY())) //k pos not changed
    );
  }

  @Test
  public void testMoveNotAllowed3(){
    Pair<Integer,Integer> wrongPos = new Pair<>(1, 1);
    assertAll(
            () ->  assertFalse(l.hit(wrongPos.getX(),wrongPos.getY())),
            () -> assertTrue(l.hasKnight(INITIAL_KNIGHT_POS.getX(),INITIAL_KNIGHT_POS.getY())) //k pos not changed
    );
  }

  @Test
  public void testMoveOutOfBounds() {
    assertThrows(IndexOutOfBoundsException.class, () -> l.hit(-1, -1));
    assertThrows(IndexOutOfBoundsException.class, () -> l.hit(5, 5));
  }


  @Test
  public void testMoveAllowed(){
    l.hit(2,1); //k pos not changed
    assertFalse(l.hasKnight(INITIAL_KNIGHT_POS.getX(),INITIAL_KNIGHT_POS.getY())); //k pos should be changed
  }
}
