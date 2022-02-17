package EternityII;

public class puzzleBorder{
	importPieces piecesFromFile= new importPieces();
	
	public piece[] solvePuzzle()
	{
	
		int numberOfPieces=piecesFromFile.getNumberofPiecesFromFile(); //get the number of pieces from the importPieces class
		
		piece[] pieces=piecesFromFile.getPiecesFromFile(); //get the pieces from the importPieces class
		
		
	
		piece[] Usedpieces= new piece[numberOfPieces]; //define Usedpieces array to store the pieces that are in the randomizedBorderPieces array
		
		//randomly initialize puzzle border 
		int numberOfBorderPieces= ((int)Math.sqrt(numberOfPieces))*2+(((int)Math.sqrt(numberOfPieces))-2)*2; //equation to find number of border pieces
		
		piece[] randomizedBorderPieces= new piece[numberOfBorderPieces]; //define array to store randomly initialized border pieces
		
		int countFilledBorder=0; //define countFilledBorder to keep track of the pieces that are in the border
		int iterator=0; //define iterator that will iterate through the pieces array
		if(countFilledBorder==0) //Store Top left corner of the border of the puzzle
		{
			if((pieces[iterator].edgeTop==0)&&(pieces[iterator].edgeRight==0)) //Corner pieces have to have two grey (the edges that are 0) edges (in file the 0 edges for corner pieces are the top edge and right edge)
			{
				randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft); //store piece in randomizedBorderPieces
				Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft); //also store it in Usedpieces array so that when we add more pieces it does not store the same piece twice
				randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]); //rotate the piece so that the edges that are 0 are the top edge and left edge
				countFilledBorder++; //increase countFilledBorder by 1 since we now have one piece in the randomizedBorderPieces
				iterator++; 
			}
		}
		
		
	    while(countFilledBorder<(((int)Math.sqrt(numberOfPieces))-1)) // Store Top row of puzzle border up till piece before the top right corner of puzzle
		{
	    	if(pieces[iterator].edgeRight!=0) //condition to skip over the corner pieces
			{
				if(pieces[iterator].edgeTop==0) //all inner border pieces in file are stored with their top edge being equal to 0
				{
					//store piece in randomizedBorderPieces and Usedpieces
					randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft); 
					Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft);
					countFilledBorder++;
				}
			}
			iterator++;
		}
	    
	    iterator=0; //put iterator=0 so that we could get the next corner piece
	    
	   //Store the top right corner of the puzzle into the array and make sure that it is a corner that has not been used yet
	    for(int i=0;i<Usedpieces.length;i++) 
		{
			if((pieces[iterator].edgeTop==0)&&(pieces[iterator].edgeRight==0)&&pieces[iterator].NotequalTo(Usedpieces[i]))
			{
				randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft);;
				Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft);
				countFilledBorder++;
				iterator++;
				break;
			}
		}
	    
	  
	    //Store the pieces for the right side of the puzzle 
	    while(countFilledBorder<((int)Math.sqrt(numberOfPieces)+(int)Math.sqrt(numberOfPieces)-2)) //countFilledBorder would be at (int)Math.sqrt(numberOfPieces) so add that to (int)Math.sqrt(numberOfPieces)-2 to store the pieces for the right side of the puzzle up till the piece before the bottom right corner piece
		{
	    	for(int i=0;i<Usedpieces.length;i++)
	    	{
	    		if((pieces[iterator].edgeTop!=0)&&(pieces[iterator].edgeRight!=0))
				{
					if(pieces[iterator].edgeTop==0&&pieces[iterator].NotequalTo(Usedpieces[i]))
					{
						randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft);;
						Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft);
						//rotate 3 times so that the 0 edge would be on the left
						randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
						randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
						randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
						countFilledBorder++;
						iterator++;
					}
				}
				
	    	 }
		 }
	    	
	    	iterator=0;
	    	
	    	for(int i=0;i<Usedpieces.length;i++) //Store Bottom right corner of puzzle into randomizedBorderPieces array and Usedpieces array 
			{
				if((pieces[iterator].edgeTop==0)&&(pieces[iterator].edgeRight==0)&&pieces[iterator].NotequalTo(Usedpieces[i]))
				{
					randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft);
					Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft);
					//rotate 3 times so that the 0 edges are at the right edge and bottom edge
					randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
					randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
					randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
					countFilledBorder++;
					iterator++;
					break;
				}
			}
	    	
	    	//countFilledBorder is at (int)Math.sqrt(numberOfPieces)*2 so add (int)Math.sqrt(numberOfPieces)-2) to store the pieces of the bottom row of the puzzle
	    	while(countFilledBorder<((int)Math.sqrt(numberOfPieces)*2+(int)Math.sqrt(numberOfPieces)-2)) 
			{
		    	for(int i=0;i<Usedpieces.length;i++)
		    	{
		    		if((pieces[iterator].edgeTop!=0)&&(pieces[iterator].edgeRight!=0))
					{
						if(pieces[iterator].edgeTop==0&&pieces[iterator].NotequalTo(Usedpieces[i]))
						{
							randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft);
							Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft);
							//rotate the piece twice so that the 0 edge goes from being at the top edge to being at the bottom edge
							randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
							randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
							countFilledBorder++;
							iterator++;
						}
					}
					
		    	}
			}
	    	
	    	iterator=0;
	    	
	    	for(int i=0;i<Usedpieces.length;i++) //Store bottom left corner of puzzle
			{
				if((pieces[iterator].edgeTop==0)&&(pieces[iterator].edgeRight==0)&&pieces[iterator].NotequalTo(Usedpieces[i]))
				{
					randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft);;
					Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft);
					randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
					randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
					countFilledBorder++;
					iterator++;
					break;
				}
			}
	    
	    	while(countFilledBorder<((int)Math.sqrt(numberOfPieces)*3+(int)Math.sqrt(numberOfPieces)-2)) //Store Left side of puzzle
			{
		    	for(int i=0;i<Usedpieces.length;i++)
		    	{
		    		if((pieces[iterator].edgeTop!=0)&&(pieces[iterator].edgeRight!=0))
					{
						if(pieces[iterator].edgeTop==0&&pieces[iterator].NotequalTo(Usedpieces[i]))
						{
							randomizedBorderPieces[countFilledBorder]=new piece(pieces[iterator].edgeTop,pieces[iterator].edgeRight,pieces[iterator].edgeBottom,pieces[iterator].edgeLeft);;
							Usedpieces[countFilledBorder]=new piece(randomizedBorderPieces[countFilledBorder].edgeTop,randomizedBorderPieces[countFilledBorder].edgeRight,randomizedBorderPieces[countFilledBorder].edgeBottom,randomizedBorderPieces[countFilledBorder].edgeLeft);
							randomizedBorderPieces[countFilledBorder].rotate(randomizedBorderPieces[countFilledBorder]);
							countFilledBorder++;
							iterator++;
						}
					}
					
		    	}
			}
	    	
	    	//Solve puzzle Border
	    	for(int i=0;i<randomizedBorderPieces.length;i++)
	    	{
	    		if(i<(int)Math.sqrt(numberOfPieces)-1) //First match the pieces for the top row of the border
	    		{
	    			if(randomizedBorderPieces[i].edgeRight!=randomizedBorderPieces[i+1].edgeLeft) //check if the piece's right edge is equal to the next piece's left edge
		    		{
		    			for(int j=i+2;j<randomizedBorderPieces.length;j++) //start searching the pieces in the randomizedBorderPieces
		    			{
		    				if(i==(int)Math.sqrt(numberOfPieces)-3) //if we are at the second last piece of the top row of the border (exceptional case)
		    				{
		    					if((randomizedBorderPieces[i].edgeRight==randomizedBorderPieces[j+1].edgeTop)&&(randomizedBorderPieces[j+1].edgeRight==0)) //(randomizedBorderPieces[j+1].edgeRight==0) means that the piece at is in the right side of the puzzle
		    					{
		    						//if there is a piece at j+1 (not j since j would be a corner piece) where this piece is in the right side of the puzzle
		    						//and this piece's bottom edge is equal to the corner piece's left edge (corner piece at index i+2)
		    						if(randomizedBorderPieces[i+2].edgeLeft==randomizedBorderPieces[j+1].edgeBottom)
		    						{
		    							//rotate the piece at index j+1 so that its top edge becomes the left edge that matches the right edge of index i
		    							//and its bottom edge becomes the right edge that matches the corner piece's (piece at index i+2) left edge
		    							randomizedBorderPieces[j+1].rotate(randomizedBorderPieces[j+1]);
				    					
		    							piece temp=randomizedBorderPieces[i+1];
				    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j+1];
				    					randomizedBorderPieces[j+1]=temp;
		    						}
		    					}
		    					
		    					else if((randomizedBorderPieces[i].edgeRight==randomizedBorderPieces[j+1].edgeRight)&&(randomizedBorderPieces[j+1].edgeBottom==0)) //(randomizedBorderPieces[j+1].edgeBottom==0) means that the piece is in the bottom row of the puzzle
		    					{
		    						if(randomizedBorderPieces[i+2].edgeLeft==randomizedBorderPieces[j+1].edgeLeft)
		    						{
		    							randomizedBorderPieces[j+1].rotate(randomizedBorderPieces[j+1]);
				    					randomizedBorderPieces[j+1].rotate(randomizedBorderPieces[j+1]);
				    					piece temp=randomizedBorderPieces[i+1];
				    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j+1];
				    					randomizedBorderPieces[j+1]=temp;
		    						}
		    					}
		    					
		    					else if((randomizedBorderPieces[i].edgeRight==randomizedBorderPieces[j+1].edgeBottom)&&(randomizedBorderPieces[j+1].edgeLeft==0))
		    					{
		    						if(randomizedBorderPieces[i+2].edgeLeft==randomizedBorderPieces[j+1].edgeTop)
		    						{
		    							randomizedBorderPieces[j+1].rotate(randomizedBorderPieces[j+1]);
				    					randomizedBorderPieces[j+1].rotate(randomizedBorderPieces[j+1]);
				    					randomizedBorderPieces[j+1].rotate(randomizedBorderPieces[j+1]);
				    					piece temp=randomizedBorderPieces[i+1];
				    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j+1];
				    					randomizedBorderPieces[j+1]=temp;
		    						}
		    					}
		    				}
		    				else if((randomizedBorderPieces[i].edgeRight==randomizedBorderPieces[j].edgeLeft)&&(randomizedBorderPieces[j].edgeTop==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0)) 
		    				{
		    					//if the piece at index j that matches the piece at index i is in the same row as the piece at index i and the piece at index j is not a corner piece
		    					//swap the pieces at indexes i+1 and j
		    					piece temp=randomizedBorderPieces[i+1];
		    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
		    					randomizedBorderPieces[j]=temp;
		    				}
		    				
		    				else if((randomizedBorderPieces[i].edgeRight==randomizedBorderPieces[j].edgeTop)&&(randomizedBorderPieces[j].edgeRight==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					//if the piece at index j, that matches the piece at index i, is in the right side of the puzzle and the piece at index j is not a corner piece
		    					randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]); //rotate the piece once, so that its top edge becomes the left edge (where then 0 would be the top edge instead of being right edge) 
			    				//swap the pieces at indexes i+1 and j
		    					piece temp=randomizedBorderPieces[i+1];
			    				randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
			    				randomizedBorderPieces[j]=temp;	
		    				}
		    				
		    				else if((randomizedBorderPieces[i].edgeRight==randomizedBorderPieces[j].edgeRight)&&(randomizedBorderPieces[j].edgeBottom==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					//if the piece at index j, that matches the piece at index i, is at the bottom side of the puzzle and the piece at index j is not a corner piece
		    					//rotate the piece twice, so that its right edge becomes the left edge (where then 0 would be the top edge instead of the bottom edge) 
		    					randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				piece temp=randomizedBorderPieces[i+1];
			    				randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
			    				randomizedBorderPieces[j]=temp;
		    				}
		    				
		    				else if((randomizedBorderPieces[i].edgeRight==randomizedBorderPieces[j].edgeBottom)&&(randomizedBorderPieces[j].edgeLeft==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					//if the piece at index j, that matches the piece at index i, is at the left side of the puzzle and the piece at index j is not a corner piece
		    					//rotate the piece three times, so that its bottom edge becomes the left edge (where then 0 would be the top edge instead of the left edge)
		    					randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				piece temp=randomizedBorderPieces[i+1];
			    				randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
			    				randomizedBorderPieces[j]=temp;
		    				}
		    			}
		    		}
	    		}
	    		
	    		if((i>=(int)Math.sqrt(numberOfPieces)-1)&&(i<((int)Math.sqrt(numberOfPieces)-1)*2)) //Match the pieces for the right side of the border
	    		{
	    			if(randomizedBorderPieces[i].edgeBottom!=randomizedBorderPieces[i+1].edgeTop)
		    		{
		    			for(int j=i+2;j<randomizedBorderPieces.length;j++)
		    			{
		    				if(i==(((int)Math.sqrt(numberOfPieces)-1)*2)-2)
		    				{
		    					if((randomizedBorderPieces[i].edgeBottom==randomizedBorderPieces[j+1].edgeRight)&&(randomizedBorderPieces[j+1].edgeBottom==0))
		    					{
		    						if(randomizedBorderPieces[i+2].edgeTop==randomizedBorderPieces[j+1].edgeLeft)
		    						{
		    							randomizedBorderPieces[j+1].rotate(randomizedBorderPieces[j+1]);
				    					piece temp=randomizedBorderPieces[i+1];
				    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j+1];
				    					randomizedBorderPieces[j+1]=temp;
		    						}
		    					}
		    					else if((randomizedBorderPieces[i].edgeBottom==randomizedBorderPieces[j+1].edgeBottom)&&(randomizedBorderPieces[j+1].edgeLeft==0))
		    					{
		    						if(randomizedBorderPieces[i+2].edgeTop==randomizedBorderPieces[j+1].edgeTop)
		    						{
		    							randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
				    					randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
				    					piece temp=randomizedBorderPieces[i+1];
				    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
				    					randomizedBorderPieces[j]=temp;
		    						}
		    					}
		    				}
		    				else if((randomizedBorderPieces[i].edgeBottom==randomizedBorderPieces[j].edgeTop)&&(randomizedBorderPieces[j].edgeRight==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					piece temp=randomizedBorderPieces[i+1];
		    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
		    					randomizedBorderPieces[j]=temp;
		    				}
		    				
		    				else if((randomizedBorderPieces[i].edgeBottom==randomizedBorderPieces[j].edgeRight)&&(randomizedBorderPieces[j].edgeBottom==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				piece temp=randomizedBorderPieces[i+1];
			    				randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
			    				randomizedBorderPieces[j]=temp;
		    				}
		    				
		    				else if((randomizedBorderPieces[i].edgeBottom==randomizedBorderPieces[j].edgeBottom)&&(randomizedBorderPieces[j].edgeLeft==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
			    				piece temp=randomizedBorderPieces[i+1];
			    				randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
			    				randomizedBorderPieces[j]=temp;
		    				}
		    				
		    			}
		    		}
	    			
		    	}
	    		
	    		if((i>=((int)Math.sqrt(numberOfPieces)-1)*2)&&(i<((int)Math.sqrt(numberOfPieces)-1)*3)) //Match the pieces of the bottom border
	    		{
	    			if(randomizedBorderPieces[i].edgeLeft!=randomizedBorderPieces[i+1].edgeRight)
		    		{
		    			for(int j=i+2;j<randomizedBorderPieces.length;j++)
		    			{
		    				if(i==(((int)Math.sqrt(numberOfPieces)-1)*3)-2)
		    				{
		    					if((randomizedBorderPieces[i].edgeLeft==randomizedBorderPieces[j+1].edgeBottom)&&(randomizedBorderPieces[j+1].edgeLeft==0))
		    					{
		    						if(randomizedBorderPieces[i+2].edgeRight==randomizedBorderPieces[j+1].edgeTop)
		    						{
		    							randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
				    					piece temp=randomizedBorderPieces[i+1];
				    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
				    					randomizedBorderPieces[j]=temp;
		    						}
		    					}
		    				}
		    				if((randomizedBorderPieces[i].edgeLeft==randomizedBorderPieces[j].edgeRight)&&(randomizedBorderPieces[j].edgeBottom==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					piece temp=randomizedBorderPieces[i+1];
		    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
		    					randomizedBorderPieces[j]=temp;
		    				}
		    				else if((randomizedBorderPieces[i].edgeLeft==randomizedBorderPieces[j].edgeBottom)&&(randomizedBorderPieces[j].edgeLeft==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					randomizedBorderPieces[j].rotate(randomizedBorderPieces[j]);
		    					piece temp=randomizedBorderPieces[i+1];
		    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
		    					randomizedBorderPieces[j]=temp;
		    				}
		    				
		    			}
		    		}
	    		}
	    		
	    		if((i>=((int)Math.sqrt(numberOfPieces)-1)*3)&&(i<(((int)Math.sqrt(numberOfPieces)-1)*4)-2)) //Match the pieces for the left side of the puzzle
	    		{
	    			if(randomizedBorderPieces[i].edgeTop!=randomizedBorderPieces[i+1].edgeBottom)
		    		{
		    			for(int j=i+2;j<randomizedBorderPieces.length;j++)
		    			{
		    				if((randomizedBorderPieces[i].edgeTop==randomizedBorderPieces[j].edgeBottom)&&(randomizedBorderPieces[j].edgeLeft==0)&&(j%(int)Math.sqrt(numberOfPieces)-1!=0))
		    				{
		    					piece temp=randomizedBorderPieces[i+1];
		    					randomizedBorderPieces[i+1]=randomizedBorderPieces[j];
		    					randomizedBorderPieces[j]=temp;
		    				}
		    				
		    			}
		    		}
	    		}
	    	}
		
	    	return randomizedBorderPieces;
	}
}
