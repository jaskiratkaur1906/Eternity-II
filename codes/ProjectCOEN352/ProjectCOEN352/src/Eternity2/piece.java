package Eternity2;

public class piece {
	private int edgeTop, edgeLeft, edgeRight, edgeBottom;
	
	public void setEdgeofPiece(int eT, int eR, int eB, int eL)
	{
		edgeTop=eT;
		edgeLeft=eL;
		edgeRight=eR;
		edgeBottom=eB;
	}
	
	public int getTopEdgeofPiece()
	{
		return edgeTop;
	}
	
	public int getLeftEdgeofPiece()
	{
		return edgeLeft;
	}
	
	public int getRightEdgeofPiece()
	{
		return edgeRight;
	}
	
	public int getBottomEdgeofPiece()
	{
		return edgeBottom;
	}
}
