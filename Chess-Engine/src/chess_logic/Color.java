package chess_logic;

public enum Color {
	BLACK {
		@Override
		public String toString() {
			return "BLACK";
		}

		@Override
		public String abrev() {
			return "B";
		}
	},
	WHITE {
		@Override
		public String toString() {
			return "WHITE";
		}

		@Override
		public String abrev() {
			return "W";
		}
	},
	NULL;

	public String toString() {
		return "N";
	}

	public String abrev() {
		return "-";
	}

	public static Color next(Color turn) {
		return ((turn == WHITE) ? BLACK : WHITE);
	}
}
