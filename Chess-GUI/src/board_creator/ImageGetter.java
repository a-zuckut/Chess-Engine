package board_creator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import chess_logic.Color;
import chess_parts.Piece;

public class ImageGetter {

	public static BufferedImage getImageForPiece(Piece piece) {
		int i = 0;
		int j = (piece.getColor() == Color.BLACK) ? 0:1;
		
		File f = new File("res/chess_pieces_64x64_top-b_bot-w_brown_white.png");
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch (piece.getPieceType()) {
		case Pawn:
			i = 64 * 5;
			return bi.getSubimage(i, j * 64, 64, 64);
		case Knight:
			i = 64 * 3;
			return bi.getSubimage(i, j * 64, 64, 64);
		case Bishop:
			i = 64 * 4;
			return bi.getSubimage(i, j * 64, 64, 64);
		case Rook:
			i = 64 * 2;
			return bi.getSubimage(i, j * 64, 64, 64);
		case Queen:
			i = 64 * 1;
			return bi.getSubimage(i, j * 64, 64, 64);
		case King:
			i = 64 * 0;
			return bi.getSubimage(i, j * 64, 64, 64);
		case NULL:
		default:
			return new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
		}
	}

}
