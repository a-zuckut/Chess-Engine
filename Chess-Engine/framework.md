
As I will plan it, you have your pieces on the board stored as objects.

```
Ex:
	RNBQKBNR
	PPPPPPPP
```

So, I will need to store all the pieces with their current position. I will also need to store the possible moves for the pieces. So, let's say you have a pawn. You can go forward 2 or 1 depending on your position. The question is, how am I going to store the possible moves. 

The answer will be that I will have to have moves as a class. As well as a board that is already created. 

So, for the project the structure should currently be something like:

 chess_pieces
  -> Containing all the respective pieces.
 chess_parts
  -> Contains all the extra parts - board and more
 chess_logic
  -> move, first position, other things important to chess.

