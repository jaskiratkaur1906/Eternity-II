package Eternity2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class importPieces {

	public static piece[] main(String[] args) {
		// TODO Auto-generated method stub
		
		piece[] pieces= new piece[256];
		
		Scanner pieceFile=null;
		try 
		{
			File Pieces= new File("16x16pieces.txt");
			pieceFile= new Scanner(Pieces);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("file not found");
		}
			
		if(pieceFile.hasNextLine())
		{
			pieceFile.nextLine();
			pieceFile.nextLine();
			pieceFile.nextLine();
		}
		int countPieces=0;
		while (pieceFile.hasNextLine()) 
		{
			pieces[countPieces].setEdgeofPiece(Integer.parseInt(pieceFile.next()), Integer.parseInt(pieceFile.next()),Integer.parseInt(pieceFile.next()), Integer.parseInt(pieceFile.next()));
			pieceFile.nextLine();
			countPieces++;
		}
		
		return pieces;
	}

}
