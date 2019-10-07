import java.util.Arrays;

public class Game {

    boolean game_is_over = false;

    //2-4 players allowed, still has to be implemented
    public Player[] initialize_players(String[] player_names) {
        //create a list of the players (as objects) and declare the data field name
        Player[] player_objects = new Player[player_names.length];
        for (int i = 0; i < player_names.length; i++) {
            Player player = new Player(player_names[i]);
            player_objects[i] = player;
        }
        //put player in queue (according to the rules of how a queue works)
        return player_objects; //queue should be returned
    }

    public Square[] initialize_board(int number_of_squares) {
        Square[] square_objects = new Square[number_of_squares];
        for (int i = 0; i < number_of_squares; i++) {
            Square square = new Square();
            square_objects[i] = square;
        }

        //declare start and finish square
        StartSquare start_square = new StartSquare();
        square_objects[1] = start_square;
        start_square.is_occupied = true;

        FinishSquare finish_square = new FinishSquare();
        square_objects[square_objects.length - 1] = finish_square;

        return square_objects;
    }

    public void place_ladders_and_snakes(int board_size, Square[] square_objects) {
        //one snake or ladder per 4 squares
        for (int i = 0; i < board_size / 4; i++) {
            int initial = board_size;
            int end = 0;
            while (initial >= board_size || end >= board_size || initial - 1 == end && square_objects[initial].getClass() != LadderOrSnake.class) {
                initial = (int) (Math.random() * board_size + 3);
                end = (int) (Math.random() * board_size + 3);
            }
            LadderOrSnake ladder_or_snake = new LadderOrSnake(end);
            ladder_or_snake.number = initial - 1;
            square_objects[initial - 1] = ladder_or_snake;
        }
    }

    public void print_board(Square[] square_objects, Player[] player_objects) {
        for (int i = 1; i < square_objects.length; i++) {
            //could surely be written in a nicer way
            if (square_objects[i].getClass() == LadderOrSnake.class) {
                if (square_objects[i].is_occupied) {
                    System.out.print("[" + i + " " + Arrays.toString(square_objects[i].occupants) + "]");
                } else {
                    System.out.print("[" + square_objects[i].number + "->" + square_objects[i].end + "]");
                }
            } else {
                if (square_objects[i].is_occupied) {
                    System.out.print("[" + i + " " + Arrays.toString(square_objects[i].occupants) + "]");
                } else {
                    System.out.print("[" + i + "]");
                }
            }
        }
        //print last square
    }

    public static void main(String[] args) {
        Game game1 = new Game();
        String[] players = {"Jack", "Jill"};
        int board_size = 12;
        Player[] player_objects = game1.initialize_players(players);
        Square[] square_objects = game1.initialize_board(board_size);
        game1.place_ladders_and_snakes(board_size, square_objects);
        game1.print_board(square_objects, player_objects);
    }

}
