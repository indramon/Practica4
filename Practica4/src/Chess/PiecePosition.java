package Chess;

public class PiecePosition {
	private int column, row;

	/**
	 * This is the constructor of the piece, which sets the column
         * and the row of the piece into the given values
	 */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	/**
	 * This method checks if the position given is inside the range
         * of positions of a chess table, which is, a valid a position
	 */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
	 * This method is used to know if a certain position of the table that is not
         * the position of the piece, is available. The position to check availability
         * is based on the current position of the piece.
	 */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
	 * This method is used to know if the position is valid, but this time using
         * the class PiecePosition, checking first if it's null and then using the 
         * method that checks the position using the row and the column, above explained
	 */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}


	
	/**
	 * This method gives you the column of the piece
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * This method gives you the row of the piece
	 */
	public int getRow() {
		return row;
	}
        
        /**
	 * This method sets the row and the column of this piece into
         * the values given, checking first if those values are valid
	 */
	public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns a PiecePosition with the values given to the
         * method+ the values of the column and the row of the original piece.
         * Checking first if that position exists and it's valid.
	 */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	/**
	 * This method returns a clone of the piece, with its same column and row
	 */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/**
	 * This method here checks if the position of a given piece is the same
         * that the position of this piece
	 */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
