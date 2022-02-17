package EternityII;

public class piece {
	public int edgeTop, edgeLeft, edgeRight, edgeBottom;
	
	piece(int eT, int eR, int eB, int eL)
	{
		edgeTop=eT;
		edgeLeft=eL;
		edgeRight=eR;
		edgeBottom=eB;
	}
	
	public piece rotate(piece a) //rotate anticlockwise
	{
		int temp=a.edgeTop;
		a.edgeTop=a.edgeRight;
		a.edgeRight=a.edgeBottom;
		a.edgeBottom=a.edgeLeft;
		a.edgeLeft=temp;
		return a;
		
	}
	
	public boolean NotequalTo(piece a)
	{
		if(edgeTop!=a.edgeTop||edgeRight!=a.edgeRight||edgeBottom!=a.edgeBottom||edgeLeft!=a.edgeLeft)
		{
			return true;
		}
		return false;
	}
	
	public void OutputPiece(piece a)
	{
		System.out.print(a.edgeTop);
		System.out.print(a.edgeLeft);
		System.out.print(a.edgeRight);
		System.out.print(a.edgeBottom);
	}
}
