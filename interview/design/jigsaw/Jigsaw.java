package com.interview.design.jigsaw;

import static com.interview.design.jigsaw.Jigsaw.Edge.BOTTOM;
import static com.interview.design.jigsaw.Jigsaw.Edge.LEFT;
import static com.interview.design.jigsaw.Jigsaw.Edge.RIGHT;
import static com.interview.design.jigsaw.Jigsaw.Edge.TOP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implement a NxN jigsaw puzzle and solver. This implementation is pretty incomplete because I feel like enough is
 * there. I realize that I maybe should have avoided going into the display, but that is kind of how I might lay out the
 * simple Jigsaw app, though maybe this should be a JigsawPuzzleApp that has a Jigsaw in it along with the other things.
 * I could have done more about the edge and inner and outer, but figured, I wasn't like actually drawing these and it
 * doesn't matter that much. It depends how close to simulating the logic to solve it I was going to do, but didn't do
 * it so, didn't matter much in the end.
 */
public class Jigsaw {

    private Piece[][] board;
    private PieceGenerator generator = new PieceGenerator();
    Set<Piece> unconnectedPieces = new HashSet<>();

    //
    public Jigsaw(int n, byte[] image) {
        board = new Piece[n][n];
        unconnectedPieces.addAll(generator.generatePieces(image));
    }

    public void displayBoard() {
        for (Piece[] element : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.println(element[j]);
            }
        }
    }

    public boolean isSolved() {
        return unconnectedPieces.isEmpty();
    }

    public void solve() {
        // start with a piece

        while (!isSolved()) {
            // get an unconnected edge from the connected graph.
            // find the connection for that edge.

            // TODO remove break
            break;
        }
    }

    public boolean fitsWith(PieceEdge a, PieceEdge b) {
        if (a.edge.isOpposite(b.edge)) {
            if (a.edge == TOP) {
                return a.piece.y == b.piece.y && a.piece.x == b.piece.x + 1;
            } else if (a.edge == BOTTOM) {
                return a.piece.y == b.piece.y && a.piece.x == b.piece.x - 1;
            } else if (a.edge == LEFT) {
                return a.piece.x == b.piece.x && a.piece.x == b.piece.x - 1;
            } else if (a.edge == RIGHT) {
                return a.piece.x == b.piece.x && a.piece.x == b.piece.x + 1;
            }
        }
        return false;
    }

    public class PieceGenerator {
        public List<Piece> generatePieces(byte[] image) {
            // generates Pieces from an image
            List<Piece> pieces = null;
            return shuffle(pieces);
        }

        public List<Piece> shuffle(List<Piece> pieces) {
            return null;
        }
    }

    public enum Edge {
        LEFT, TOP, RIGHT, BOTTOM;
        public boolean isOpposite(Edge e) {
            return (this == TOP && e == BOTTOM) || (this == BOTTOM && e == TOP) || (this == LEFT && e == RIGHT)
                    || (this == RIGHT && e == LEFT);
        }
    }

    public enum Shape {
        INNER, OUTER, FLAT;
    }

    public class PieceEdge {
        Edge edge;
        Shape orientation;
        Piece piece;

        public PieceEdge(Edge edge) {
            this.edge = edge;
        }

    }

    public class Piece {
        // actual position of piece on board
        int x;
        int y;
        Picture picture;
        PieceEdge[] edges = {new PieceEdge(LEFT), new PieceEdge(RIGHT), new PieceEdge(BOTTOM), new PieceEdge(TOP) };

        public void rotateRight() {

        }

        public void rotateLeft() {

        }

        public boolean isCorner() {
            return false;
        }

        public boolean isBorder() {
            return false;
        }
    }

    public class Picture {
        final byte[] image;

        public Picture(byte[] image) {
            this.image = image;
        }
    }

}