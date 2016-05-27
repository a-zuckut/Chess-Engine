package chess_parts;

public enum PieceTypes {

	Bishop{
		@Override
		public String toString() {
			return "Bishop";
		}
		
		@Override
		public String abrev() {
			return "B";
		}
	},
	King{
		@Override
		public String toString() {
			return "King";
		}
		
		@Override
		public String abrev() {
			return "K";
		}
	},
	Knight{
		@Override
		public String toString() {
			return "Knight";
		}
		
		@Override
		public String abrev() {
			return "N";
		}
	},
	Pawn{
		@Override
		public String toString() {
			return "Pawn";
		}
		
		@Override
		public String abrev() {
			return "P";
		}
	},
	Queen{
		@Override
		public String toString() {
			return "Queen";
		}
		
		@Override
		public String abrev() {
			return "Q";
		}
	},
	Rook {
		@Override
		public String toString() {
			return "Rook";
		}
		
		@Override
		public String abrev() {
			return "R";
		}
	},
	NULL {
		@Override
		public String toString() {
			return "-";
		}
	};

	public String abrev() {
		return "-";
	}
	
}
