package EternityII;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class importPieces {
	private int numberOfPieces=0;
	
	public int getNumberofPiecesFromFile()
	{
		File countPieces=new File("3x3pieces.txt");
		Scanner countPiecesFile=null;
		try
		{
			countPiecesFile= new Scanner(countPieces);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("file not found");
		}
		
		while (countPiecesFile.hasNextLine()) 
		{
			numberOfPieces++;
			countPiecesFile.nextLine();
		}
		
		countPiecesFile.close();
		
		
		return numberOfPieces;
		
	}
	
	public piece[] getPiecesFromFile()
	{
		
		piece[] pieces= new piece[numberOfPieces];
		
		File Pieces= new File("3x3pieces.txt");
		Scanner pieceFile=null;
		try 
		{
			pieceFile= new Scanner(Pieces);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("file not found");
		}
		int countPieces=0;
		while (pieceFile.hasNextLine()) 
		{
			pieces[countPieces]=new piece(Integer.parseInt(pieceFile.next()), Integer.parseInt(pieceFile.next()),Integer.parseInt(pieceFile.next()), Integer.parseInt(pieceFile.next()));
			countPieces++;
			if(!pieceFile.hasNextLine())
				break;
			pieceFile.nextLine();
		}
		
		
		
		pieceFile.close();
		
		
		return pieces;
	}

}
