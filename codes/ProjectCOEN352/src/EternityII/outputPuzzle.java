package EternityII;

public class outputPuzzle {
	importPieces piecesFromFile= new importPieces();
	puzzleBorder solvedBorder= new puzzleBorder();
	InsidePuzzle solvedInsidePuzzle= new InsidePuzzle();
	
	public void PuzzleOutput()
	{
		int numberOfPieces=piecesFromFile.getNumberofPiecesFromFile();
		
		
		piece[] solvedBorderPieces= solvedBorder.solvePuzzle();
		
		piece[] solvedInsidePieces= solvedInsidePuzzle.solveInsidePuzzle();
		
        int numberOfBorderPieces= ((int)Math.sqrt(numberOfPieces))*2+(((int)Math.sqrt(numberOfPieces))-2)*2;
		
		
		for(int i=0;i<(int)Math.sqrt(numberOfPieces);i++)
		{
			solvedBorderPieces[i].OutputPiece(solvedBorderPieces[i]);
			System.out.print(" ");
		}
		
		System.out.println();
		
		int j=0;
		int z=(int)Math.sqrt(numberOfPieces)-3;
		int count=0;
		int count2=(int)Math.sqrt(numberOfPieces);
		for(int i=0;i<(int)Math.sqrt(numberOfPieces)-2;i++)
		{
			solvedBorderPieces[numberOfBorderPieces-i-1].OutputPiece(solvedBorderPieces[numberOfBorderPieces-i-1]);
			System.out.print(" ");
			while(count!=z-j+1)
			{
				solvedInsidePieces[count].OutputPiece(solvedInsidePieces[count]);
				System.out.print(" ");
				count++;
			}
			solvedBorderPieces[count2].OutputPiece(solvedBorderPieces[count2]);
			System.out.print(" ");
			j=j+z;
			z=z+z;
			count2++;
			System.out.println();
		}
		
		for(int i=(((int)Math.sqrt(numberOfPieces)-1)*3);i>=(((int)Math.sqrt(numberOfPieces)-1)*3)-(int)Math.sqrt(numberOfPieces)-1;i++)
		{
			solvedBorderPieces[i].OutputPiece(solvedBorderPieces[i]);
		}
		
		
	}
}
