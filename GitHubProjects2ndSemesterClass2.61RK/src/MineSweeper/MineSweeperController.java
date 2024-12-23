package MineSweeper;

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
		// noch nicht programmiert model.newGame(width, height);
		view.newGame(width, height);	
	}
	
}
