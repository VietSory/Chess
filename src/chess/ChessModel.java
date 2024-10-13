package chess;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChessModel {
	private Set<ChessPiece> pieces = new HashSet<ChessPiece>();

	void reset() {
		for (int i=0;i<2;i++) {
			pieces.add(new ChessPiece(i*7, 7, Player.BLACK, Rank.ROOK, "rookbl"));
			pieces.add(new ChessPiece(i*7, 0,  Player.WHITE, Rank.ROOK, "rookw"));
			
			pieces.add(new ChessPiece(i*5+1, 7,  Player.BLACK, Rank.KNIGHT, "horsebl"));
			pieces.add(new ChessPiece(i*5+1, 0,  Player.WHITE, Rank.KNIGHT, "horsew"));
			

			pieces.add(new ChessPiece(i*3+2, 7,  Player.BLACK, Rank.BISHOP, "bishopbl"));
			pieces.add(new ChessPiece(i*3+2, 0,  Player.WHITE, Rank.BISHOP, "bishopw"));
		}
		for (int i=0;i<8;i++) {
			pieces.add(new ChessPiece( i, 6, Player.BLACK, Rank.PAWN, "pawnbl"));
			pieces.add(new ChessPiece( i, 1, Player.WHITE, Rank.PAWN, "pawnw"));
		}
		pieces.add(new ChessPiece(3, 7,  Player.BLACK, Rank.QUEEN, "queenbl"));
		pieces.add(new ChessPiece(4, 7, Player.BLACK, Rank.KING, "kingbl"));
		pieces.add(new ChessPiece(3, 0, Player.WHITE, Rank.QUEEN, "queenw"));
		pieces.add(new ChessPiece(4, 0, Player.WHITE, Rank.KING, "kingw"));
	}

	ChessPiece pieceAt(int row, int col) {
		for (ChessPiece chessPiece : pieces) {
			if (chessPiece.row == row && chessPiece.col == col) {
				return chessPiece;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String desc = "";
		for (int row = 7; row >= 0; row--) {
			desc += "" + row;
			for (int col = 0; col < 8; col++) {
				ChessPiece p = pieceAt(row, col);
				if (p == null) {
					desc += " .";
				} else {
					desc += " ";
					switch (p.rank) {
					case KING: {
						desc += p.player == Player.WHITE ? "k" : "K";
						break;
					}
					case QUEEN: {
						desc += p.player == Player.WHITE ? "q" : "Q";
						break;
					}
					case BISHOP: {
						desc += p.player == Player.WHITE ? "b" : "B";
						break;
					}
					case ROOK: {
						desc += p.player == Player.WHITE ? "r" : "R";
						break;
					}
					case KNIGHT: {
						desc += p.player == Player.WHITE ? "n" : "N";
						break;
					}
					case PAWN: {
						desc += p.player == Player.WHITE ? "p" : "P";
						break;
					}
				  }
				}
			}
			desc += "\n";
		}
		desc += "  0 1 2 3 4 5 6 7";
		return desc;
	}

}
