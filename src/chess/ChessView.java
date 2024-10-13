package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChessView extends JPanel {

	private static final long serialVersionUID = 2830999099569753904L;
	ChessDelegate chessDelegate;
	int originX = 75;
	int originY = 75;
	int cellSize = 600 / 8;
	private Color myColor = new Color(129, 182, 76);
	Map<String, Image> keyNameValueImage = new HashMap<String, Image>();

	public ChessView() {
		String[] imgNames = { "bishopbl", "bishopw", "horsebl", "horsew", "kingbl", "kingw", "pawnbl", "pawnw",
				"queenbl", "queenw", "rookbl", "rookw", };
		for (String imgN : imgNames) {
			try {
				Image img = loadImage(imgN + ".png");
				keyNameValueImage.put(imgN, img);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintChildren(Graphics g) {
		// TODO Auto-generated method stub
		super.paintChildren(g);
		Graphics2D g2 = (Graphics2D) g;
		drawBoard(g2);
		drawPieces(g2);
	}
	private void drawPieces(Graphics2D g2) {
		for (int row=7;row>=0;row--) {
			for (int col = 0;col<8;col++) {
				ChessPiece p =chessDelegate.pieceAt(col, row);
				if (p!=null) {
					System.out.println(p.rank+" "+p.player+" "+p.col+" "+p.row);
					drawImage(g2, p.imgName, col, row);
				}
				
			}
		}
	}
	private void drawImage(Graphics2D g2,String imgName,int col,int row) {
		Image img = keyNameValueImage.get(imgName);
		g2.drawImage(img, row*cellSize, col*cellSize, cellSize, cellSize , null);
	}
	private Image loadImage(String imgFileName) throws URISyntaxException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resURL = classLoader.getResource("img/"+imgFileName);
		if (resURL == null) {
			return null;
		} else {
			File imgFile = new File(resURL.toURI());
			return ImageIO.read(imgFile);

		}

	}

	private void drawBoard(Graphics2D g2) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				drawSquare(g2, 2 * j, 2 * i, true);
				drawSquare(g2, 2 * j + 1, 2 * i + 1, true);
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				drawSquare(g2, 2 * i, 2 * j + 1, false);
				drawSquare(g2, 2 * i + 1, 2 * j, false);
			}
		}
	}

	private void drawSquare(Graphics2D graphic2d, int row, int col, boolean light) {
		graphic2d.setColor(light ? Color.white : myColor);
		graphic2d.fillRect(cellSize * row, cellSize * col, cellSize, cellSize);
	}
}
