package chess;

import javax.swing.JFrame ;

public class ChessController implements ChessDelegate {
	private ChessModel chessModel = new ChessModel();
	private ChessView panel;
	ChessController(){
		chessModel.reset();
		JFrame frame = new JFrame("Chess");
		frame.setSize(616,640);
		//middle of screen
		frame.setLocationRelativeTo(null);
		
		panel = new ChessView();
		panel.chessDelegate = this;
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChessController();
		
	}

	@Override
	public ChessPiece pieceAt(int col, int row) {
		// TODO Auto-generated method stub
		return chessModel.pieceAt(col, row);
	}
	
}
