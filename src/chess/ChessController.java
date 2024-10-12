package chess;

import javax.swing.JFrame;

public class ChessController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Chess");
		frame.setSize(616,640);
		//middle of screen
		frame.setLocationRelativeTo(null);
		
		ChessView panel = new ChessView();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
