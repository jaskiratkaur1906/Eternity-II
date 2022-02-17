package EternityII;

public class InsidePuzzle {
	importPieces piecesFromFile= new importPieces();
	puzzleBorder solvedBorder= new puzzleBorder();
	
	public piece[] solveInsidePuzzle()
	{
       int numberOfPieces=piecesFromFile.getNumberofPiecesFromFile();
       piece[] pieces=piecesFromFile.getPiecesFromFile();
       
       piece[] solvedBorderPieces= solvedBorder.solvePuzzle();
       
		
		//randomly initialize puzzle inside
		int numberOfBorderPieces= ((int)Math.sqrt(numberOfPieces))*2+(((int)Math.sqrt(numberOfPieces))-2)*2;
		
		int numberOfInsidePieces= numberOfPieces- numberOfBorderPieces; //compute the number of pieces in the inside of the puzzle
        piece[] randomizedInsidePieces= new piece[numberOfInsidePieces]; //initialize the array to store the pieces for the inside of the puzzle
		
	
		int iterator=0; //Store the pieces that do not have a 0 edge into the array
		while(iterator<numberOfInsidePieces)
		{
			if((pieces[iterator].edgeTop!=0)&&(pieces[iterator].edgeRight!=0)&&
					(pieces[iterator].edgeBottom!=0)&&(pieces[iterator].edgeLeft!=0))
				{
					randomizedInsidePieces[iterator]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft);
					iterator++;
				}
		}
		
		//Solve inside of puzzle
		for(int i=0;i<numberOfInsidePieces;i++)
		{
			if(i==0) //matching the first element in the inside of the puzzle
			{
				//First element in the inside of the puzzle has to have its left edge equal to the right edge of the border piece before it and it has to have its top edge equal to the bottom edge of the border piece that is above it
				if(randomizedInsidePieces[i].edgeLeft!=solvedBorderPieces[numberOfBorderPieces-1].edgeRight&&randomizedInsidePieces[i].edgeTop!=solvedBorderPieces[1].edgeBottom)
				{
					int DidNotBreak=0; //initialized to see if piece is rotated it would match without having to swap it
					for(int k=1;k<=3;k++)
					{
						//rotate the piece till it matches the border pieces around it
						//it is rotated 3 times as either the left edge and bottom edge, or the bottom edge and the top edge or the right edge and top edge match the border pieces around it
						randomizedInsidePieces[i].rotate(randomizedInsidePieces[i]);
						if(randomizedInsidePieces[i].edgeLeft==solvedBorderPieces[numberOfBorderPieces-1].edgeRight&&randomizedInsidePieces[i].edgeTop==solvedBorderPieces[1].edgeBottom)
						{
							DidNotBreak=1;
							break;
						}
					}
					
					if(DidNotBreak==0) //if after rotating 3 times it does not match then we consider swapping with another piece and rotating
					{
						for(int j=1;j<=3;j++) //rotate piece back to its original state
						{
							randomizedInsidePieces[i].rotate(randomizedInsidePieces[i]);
						}
						for(int j=i+1;j<numberOfInsidePieces;j++)
						{
							//assume the first element is piece y
							//if piece x's left edge matches the puzzle piece border's right edge (the piece before piece y) and piece x's top edge matches the puzzle piece border's bottom edge (the piece above piece y)
							if(randomizedInsidePieces[j].edgeLeft==solvedBorderPieces[numberOfBorderPieces-1].edgeRight&&randomizedInsidePieces[j].edgeTop==solvedBorderPieces[1].edgeBottom)
							{
								//swap the pieces
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
							//if piece x has the same matching edges in its bottom edge and left edge then we rotate piece x 3 times so that its bottom edge becomes the left edge and its left edge becomes its top edge 
							else if(randomizedInsidePieces[j].edgeBottom==solvedBorderPieces[numberOfBorderPieces-1].edgeRight&&randomizedInsidePieces[j].edgeLeft==solvedBorderPieces[1].edgeBottom)
							{
								for(int k=1;k<=3;k++)
								{
									randomizedInsidePieces[j].rotate(randomizedInsidePieces[j]);
								}
								//swap the pieces
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
							//if piece x has the same matching edges in its right edge and bottom edge then we rotate piece x 2 times so that its right edge becomes the left edge and its bottom edge becomes its top edge
							else if(randomizedInsidePieces[j].edgeRight==solvedBorderPieces[numberOfBorderPieces-1].edgeRight&&randomizedInsidePieces[j].edgeBottom==solvedBorderPieces[1].edgeBottom)
							{
								for(int k=1;k<=2;k++)
								{
									randomizedInsidePieces[j].rotate(randomizedInsidePieces[j]);
								}
								//swap the pieces
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
							//if piece x has the same matching edges in its top edge and right edge then we rotate piece x once so that its top edge becomes the left edge and its right edge becomes its top edge
							else if(randomizedInsidePieces[j].edgeTop==solvedBorderPieces[numberOfBorderPieces-1].edgeRight&&randomizedInsidePieces[j].edgeRight==solvedBorderPieces[1].edgeBottom)
							{
								randomizedInsidePieces[j].rotate(randomizedInsidePieces[j]);
								//swap the pieces
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
						}
					}
						
					
				}
			}
			
			//this is to match the rest of the pieces that are in the first row except the last piece that has a puzzle border piece above it and a puzzle border piece after it 
			//follows the same logic as before
			else if(i>0&&i<(int)Math.sqrt(numberOfInsidePieces)-1)
			{
				if(randomizedInsidePieces[i].edgeLeft!=randomizedInsidePieces[i-1].edgeRight&&randomizedInsidePieces[i].edgeTop!=solvedBorderPieces[i+1].edgeBottom)
				{
					int DidNotBreak=0;
					for(int k=1;k<=3;k++)
					{
						randomizedInsidePieces[i].rotate(randomizedInsidePieces[i]);
						if(randomizedInsidePieces[i].edgeLeft==randomizedInsidePieces[i-1].edgeRight&&randomizedInsidePieces[i].edgeTop==solvedBorderPieces[i+1].edgeBottom)
						{
							DidNotBreak=1;
							break;
						}
					}
					if(DidNotBreak==0)
					{
						for(int j=1;j<=3;j++) //rotate piece back to its original state
						{
							randomizedInsidePieces[i].rotate(randomizedInsidePieces[i]);
						}
						for(int j=i+1;j<numberOfInsidePieces;j++)
						{
							if(randomizedInsidePieces[j].edgeLeft==randomizedInsidePieces[i-1].edgeRight&&randomizedInsidePieces[j].edgeTop==solvedBorderPieces[i+1].edgeBottom)
							{
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
							else if(randomizedInsidePieces[j].edgeBottom==randomizedInsidePieces[i-1].edgeRight&&randomizedInsidePieces[j].edgeLeft==solvedBorderPieces[i+1].edgeBottom)
							{
								for(int k=1;k<=3;k++)
								{
									randomizedInsidePieces[j].rotate(randomizedInsidePieces[j]);
								}
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
							else if(randomizedInsidePieces[j].edgeRight==randomizedInsidePieces[i-1].edgeRight&&randomizedInsidePieces[j].edgeBottom==solvedBorderPieces[i+1].edgeBottom)
							{
								for(int k=1;k<=2;k++)
								{
									randomizedInsidePieces[j].rotate(randomizedInsidePieces[j]);
								}
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
							else if(randomizedInsidePieces[j].edgeTop==randomizedInsidePieces[i-1].edgeRight&&randomizedInsidePieces[j].edgeRight==solvedBorderPieces[i+1].edgeBottom)
							{
								randomizedInsidePieces[j].rotate(randomizedInsidePieces[j]);
								piece temp=randomizedInsidePieces[i];
								randomizedInsidePieces[i]=randomizedInsidePieces[j];
								randomizedInsidePieces[j]=temp;
							}
						}
					}
				}
			}
			
			/*else if(i==(int)Math.sqrt(numberOfInsidePieces)-1)
			{
				if(randomizedInsidePieces[i].edgeLeft!=randomizedInsidePieces[i-1].edgeRight&&randomizedInsidePieces[i].edgeTop!=solvedBorderPieces[i+1].edgeBottom&&randomizedInsidePieces[i].edgeRight!=solvedBorderPieces[i+3].edgeLeft)
				{
					
				}
			}*/
			
			//Unfortunately could not finish the code for the inside of the puzzle
			
			//However the way we would have finished it through: 
			
			//First we would have matched the last piece y that is in the first row through making sure that its left edge matches the right edge of the piece before it, its top edge matches the bottom edge of the puzzle border piece above it, and its right edge matches the left edge of the puzzle border piece on the right of it
			///// First, as seen before we rotate the last piece y a maximum of 3 times to see if it can match the pieces around it without needing to swap
			///// Then if that does not work we look at other pieces and similar to before we rotate the piece that we find has similar edges till it matches the piece y's edges that are around it
			//Then, for the rest of the pieces in the middle (the ones that are not in the first row and last row) we follow the same logic as before except we make sure that each piece's left edge matches the previous piece's right edge and that each piece's top edge matches the bottom edge of the piece above it
			//Then, for the last row we follow sort of the same logic as before where first 
			////We match the first piece of the row where we make sure that its left edge matches the border puzzle piece's right edge where the border piece is located right before the piece, its bottom edge matches the border puzzle piece's top edge where the border piece is located under it, and its top edge matches the bottom edge of the piece that is above it
			////Then we match the rest of the last row except the last piece where each piece's left edge should match the previous piece's right edge, bottom edge to the top edge of the puzzle border piece under it, and top edge to the bottom edge of the piece above it
			////For the last piece in the inside puzzle we just assume that it is already in its place as all the other pieces have been matched
		}
		
		return randomizedInsidePieces;
		
	
     }
}
