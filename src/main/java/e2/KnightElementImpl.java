package e2;

public class KnightElementImpl extends ChessElementImpl{
    public KnightElementImpl(Pair<Integer, Integer> pos) {
        super(pos);
    }

    private boolean isMoveAllowed(final int xNewPos,final int yNewPos){
        int totalMoves = 3;
        int x = xNewPos-this.getPosition().getX();
        int y = yNewPos-this.getPosition().getY();
        return (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==totalMoves);
    }

    public boolean moveKnight(final int x, final int y){
        if(isMoveAllowed(x,y)){
            this.setPosition(new Pair<Integer, Integer>(x,y));
            return true;
        }
        return false;
    }
}
