package MineSweeper;

public class MineSweeperModel {
	
	// 1. Zellenklasse definieren
	private class Cell{
		public boolean isMine = false;
		public boolean isRevealed = false;
	}
	
	// 4. Wenn eine Bombe gefunden wird, wird das Spiel beendet
	public  static class Boom extends Exception{
		public Boom() {
			super("Mine found! Game Over!");
		}
	}
	
	
	
	private Cell[][] gameBoard;
	
	// 2. Methode erstellen um ein neues Spiel zu starten
	protected void newGame(int width, int height) {
		gameBoard = new Cell[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
                gameBoard[row][col] = new Cell();
			}
		}
		
	// 3. Bomben setzen
	for (int i = 0; i < width * height / 6; i++) {
		int row = (int) (Math.random() * height);
		int col = (int) (Math.random() * width);
		gameBoard[row][col].isMine = true;
        }
	}	
	
	// 5. Mouse-Klicks definieren (Primary & Secondary) + Exception Boom TRY and CATCH im Controller
	public int revealCell(int row, int col) throws Boom {
		if (gameBoard[row][col].isMine) throw new Boom();
		gameBoard[row][col].isRevealed = true;
		return countMines(row, col);
	}
	
	
	private int countMines(int row, int col) {
		int count = 0;
		int minRow = Math.max(row-1, 0);
		int maxRow = Math.min(gameBoard.length-1, row+1);
		int minCol = Math.max(0, col-1);
		int maxCol = Math.min(gameBoard[0].length-1, col+1);
		
		for (int r = minRow; r <= maxRow; r++) {
            for (int c = minCol; c <= maxCol; c++) {
                if (gameBoard[r][c].isMine) count++;
                }
		}
		return count;
	}
}

	