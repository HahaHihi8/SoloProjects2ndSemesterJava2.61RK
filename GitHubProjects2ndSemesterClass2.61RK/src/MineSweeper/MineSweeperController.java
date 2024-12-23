package MineSweeper;

import MineSweeper.MineSweeperModel.Boom;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MineSweeperController {
	
	// 1. Attribute erstellen
	private MineSweeperModel model;
	private MineSweeperView view;
	
	// 3. Game-Grösseoptionen zuerst hardcoded, spöter per Input
	private int width = 10;
	private int height = 8;

	public MineSweeperController(MineSweeperModel model, MineSweeperView view) {
		// 2. Attribute initialisieren
		this.model = model;
		this.view = view;
		
		// 4. Methode schreiben um eine neues Game zu starten
		this.newGame();
	}
	// 4.
	private void newGame() {
		model.newGame(width, height); // 5. Methode wird im Model erstellt
		view.newGame(width, height);	
		
		// 6 . EventListener für die View erstellen
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				view.buttons[row][col].setOnMouseClicked(this::mouseClicked);
			}
		}
		
	}
	// 7. Methode für das Klicken auf ein Feld
	private void mouseClicked(MouseEvent e) {
		int row = -1;
		int col = -1;
		for (int r = 0; row == -1 && r < height; r++) {
            for (int c = 0; col == -1 && c < width; c++) {
                if (e.getSource() == view.buttons[r][c]) {
                    row = r; col = c; 
                }
            }
        }
		
	// 8. Klick definieren	
	if(e.getButton() == MouseButton.PRIMARY) {
		// Markiert Feld und gibt Bombe oder Anzahl zurück (Model-Class)
		try {
			int numBombs = model.revealCell(row, col);
			view.buttons[row][col].setText(Integer.toString(numBombs));
		} catch (Boom boom) { //Boom Exception muss importiert werden von der Model Klasse
			view.showBoom(); // Klasse im Model
		}
		
		
	} else if (e.getButton() == MouseButton.SECONDARY) {
		// Mark this Button
	} else {
		//we dont care about other inputs here
	}
	}
}