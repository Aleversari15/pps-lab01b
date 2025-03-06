package e2;

public interface ChessElement {
    /**
     * A method to get the position of the element.
     * @return the position of the element.
     */
    Pair<Integer,Integer>  getPosition();

    /**
     * A method to set a new position the element
     * @param newPosition the new position to set.
     */
    void setPosition(Pair<Integer,Integer> newPosition);
}
