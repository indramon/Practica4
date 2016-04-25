package Chess;

public class ChessPieceImplementation implements ChessPiece{
    protected Color theColor;
    protected Type theType;
    protected boolean moved;
    protected PiecePosition thePosition;
    
    public ChessPieceImplementation(Color color, Type type) {
        theColor = color;
        theType = type;
    }
    
    @Override
    public Color getColor() {
        return theColor;
    }

    @Override
    public Type getType() {
        return theType;
    }

    @Override
    public void notifyMoved() {
        moved = true;
    }

    @Override
    public boolean wasMoved() {
        return moved ==true;
    }

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
        switch(theType) {
            case KING:
                ChessMovementManager.getAvailablePositionsOfKing(this, aBoard);
            case QUEEN:
                ChessMovementManager.getAvailablePositionsOfQueen(this, aBoard)       ;
            case PAWN:
                 ChessMovementManager.getAvailablePositionsOfPawn(this, aBoard)   ;
            case ROOK:
                 ChessMovementManager.getAvailablePositionsOfRook(this, aBoard)   ;
            case BISHOP:
                ChessMovementManager.getAvailablePositionsOfBishop(this, aBoard);
            case KNIGHT:
                ChessMovementManager.getAvailablePositionsOfKnight(this, aBoard);
            default:
                return null;
        }
    }
    
    
    
}