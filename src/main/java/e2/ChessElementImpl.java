package e2;

public class ChessElementImpl implements ChessElement{
    protected Pair<Integer,Integer> position;

    public ChessElementImpl(Pair<Integer,Integer> pos){
        this.position = pos;
    }
    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> newPosition) {
        this.position = new Pair<>(newPosition.getX(), newPosition.getY());
    }
}
