package e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final ChessElement pawn;
	private final KnightElementImpl knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = new ChessElementImpl(this.randomEmptyPosition());
        this.knight = new KnightElementImpl(this.randomEmptyPosition());
    }

	public LogicsImpl(int size, Pair<Integer,Integer> knightPos, Pair<Integer,Integer> pawnPos){
		this.size = size;
		this.pawn = new ChessElementImpl(pawnPos);
		this.knight = new KnightElementImpl(knightPos);
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn.getPosition()!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }

	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		return this.knight.moveKnight(row, col) && this.pawn.getPosition().equals(this.knight.getPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.getPosition().equals(new Pair<>(row,col));
	}
}
