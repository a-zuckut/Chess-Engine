package board_creator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import chess_logic.Location;
import chess_logic.OpeningAndHelpers;
import chess_parts.Board;
import chess_parts.Piece;

public class ChessBoard {
	public final static double version = 0.0;

	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private JButton[][] chessBoardSquares = new JButton[8][8];
	private JPanel chessBoard;
	private final JLabel message = new JLabel("READY!");
	private static final String COLS = "ABCDEFGH";

	private ImageIcon possiblePositionImage;

	private Board board;

	private boolean pieceSelected = false;
	private boolean toGoWhite = true;
	
	private Piece prev_position = null;

	public ChessBoard(Board board) {
		this.board = board;
		try {
			Image image = ImageIO.read(new File("res/possible_position.png"));
			possiblePositionImage = new ImageIcon(image);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		initializeGui();
	}

	@SuppressWarnings("serial")
	public final void initializeGui() {

		// set up the main GUI
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		JToolBar tools = new JToolBar();
		tools.setFloatable(false);
		gui.add(tools, BorderLayout.PAGE_START);
		Action newGameAction = new AbstractAction("New") {
			@Override
			public void actionPerformed(ActionEvent e) {
				OpeningAndHelpers.setupNewBoard(board.getBoard());
				repaintBoard();
				pieceSelected = false;
				toGoWhite = true;
				prev_position = null;
			}
		};
		tools.add(newGameAction);
		tools.add(new JButton("Save")); // TODO - add functionality!
		tools.add(new JButton("Restore")); // TODO - add functionality!
		tools.addSeparator();
		tools.add(new JButton("Resign")); // TODO - add functionality!
		tools.addSeparator();
		tools.add(message);

		gui.add(new JLabel("?"), BorderLayout.LINE_START);

		chessBoard = new JPanel(new GridLayout(0, 9)) {

			@Override
			public final Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				Dimension prefSize = null;
				Component c = getParent();
				if (c == null) {
					prefSize = new Dimension((int) d.getWidth(), (int) d.getHeight());
				} else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
					prefSize = c.getSize();
				} else {
					prefSize = d;
				}
				int w = (int) prefSize.getWidth();
				int h = (int) prefSize.getHeight();
				// the smaller of the two sizes
				int s = (w > h ? h : w);
				return new Dimension(s, s);
			}
		};
		chessBoard.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.BLACK)));
		Color ochre = new Color(204, 119, 34);
		chessBoard.setBackground(ochre);
		JPanel boardConstrain = new JPanel(new GridBagLayout());
		boardConstrain.setBackground(ochre);
		boardConstrain.add(chessBoard);
		gui.add(boardConstrain);

		// create the chess board squares
		Insets buttonMargin = new Insets(0, 0, 0, 0);
		for (int ii = 0; ii < chessBoardSquares.length; ii++) {
			for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
				JButton b = new JButton();
				b.setMargin(buttonMargin);
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
				b.setIcon(icon);
				if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
					b.setBackground(Color.WHITE);
				} else {
					b.setBackground(Color.BLACK);
				}

				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton button = ((JButton) (e.getSource()));
						if (!pieceSelected) {
							repaintBoard();
							System.out.println(button.getAlignmentX());
							int i = (int)((button.getX()) / button.getWidth() - 1);
							int j = (int)(7 - ((button.getY()) / button.getHeight() - 1));
							System.out.println(i + " " + j);

							Piece piece = board.getBoard()[j][i];
							prev_position = piece;
							piece.validMoves(board);

							if ((piece.color == chess_logic.Color.WHITE && !toGoWhite)
									|| (piece.color == chess_logic.Color.BLACK && toGoWhite))
								return;

							ArrayList<Location> x = piece.possibleMovesDependingOnBoard;
							for (Location loc : x) {
								chessBoardSquares[loc.getX()][7 - loc.getY()].setIcon(possiblePositionImage);
							}
							pieceSelected = true;
						} else {
							if(button.getIcon() == possiblePositionImage) {
								int i = button.getX() / 70 - 1;
								int j = 7 - (button.getY() / 70 - 1);
								int fi = prev_position.getPos().getX();
								int fj = prev_position.getPos().getY();
								Location prev_position = new Location(fj, fi);
								Location final_position = new Location(i, j);
								if(board.move(prev_position, final_position)) {
									System.out.println("move");
									toGoWhite = !toGoWhite;
								} 
							}
							repaintBoard();
							prev_position = null;
							pieceSelected = false;
						}
					}
				});
				chessBoardSquares[jj][ii] = b;
			}
		}

		/*
		 * fill the chess board
		 */
		chessBoard.add(new JLabel(""));
		for (int ii = 0; ii < 8; ii++) {
			chessBoard.add(new JLabel(COLS.substring(ii, ii + 1), SwingConstants.CENTER));
		}
		for (int ii = 0; ii < 8; ii++) {
			for (int jj = 0; jj < 8; jj++) {
				switch (jj) {
				case 0:
					chessBoard.add(new JLabel("" + (9 - (ii + 1)), SwingConstants.CENTER));
				default:
					chessBoard.add(chessBoardSquares[jj][ii]);
				}
			}
		}

		OpeningAndHelpers.setupNewBoard(board.getBoard());
		repaintBoard();

	}

	public void repaintBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoardSquares[i][7 - j]
						.setIcon(new ImageIcon(ImageGetter.getImageForPiece(board.getBoard()[j][i])));
			}
		}
	}

	public final JComponent getGui() {
		return gui;
	}

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				ChessBoard board = new ChessBoard(new Board());
				JFrame f = new JFrame("Chess-Engine V" + version);
				f.add(board.getGui());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setLocationByPlatform(true);
				f.pack();
				f.setMinimumSize(f.getSize());
				f.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
}
