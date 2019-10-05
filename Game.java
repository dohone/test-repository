public class Game {

    boolean game_is_over = false;

    //input: list of the player names, number of total squares and nested list of ladders and snakes (first number in each nested list is start, second is where you end up)
    //desired result: board should be set up
    //method might be too big, maybe we should create one method for each code block?

    public static void initialize_game(String[] player_names, int number_of_squares, int[][] ladder_or_snake) {

        //create a list of the players (as objects) and declare the data field name
        Player[] player_objects = new Player[player_names.length];
        for (int i = 0; i < player_names.length; i++) {
            Player player = new Player(player_names[i]);
            player_objects[i] = player;
            //put player in queue (according to the rules of how a queue works)
        }

        //create a list of the squares (as objects)
        Square[] square_objects = new Square[number_of_squares];
        for (int i = 0; i < number_of_squares; i++) {
            Square square = new Square();
            square_objects[i] = square;
        }

        //placing the ladders and snakes
        for (int[] item : ladder_or_snake) {
            LadderOrSnake ladder_snake = new LadderOrSnake(item[0], item[1]);
            square_objects[item[0]] = ladder_snake;
        }

        //declare start and finish square
        StartSquare start_square = new StartSquare();
        square_objects[1] = start_square;
        start_square.is_occupied = true;

        FinishSquare finish_square = new FinishSquare();
        square_objects[square_objects.length - 1] = finish_square;

        //print board
        for (int i = 1; i < number_of_squares + 1; i++) {
            //could surely be written in a nicer way
            if (square_objects[i].getClass() == Square.class || square_objects[i].getClass() == StartSquare.class || square_objects[i].getClass() == FinishSquare.class) {
                System.out.println("[" + i + "]");
            } else {
                System.out.println("[" + i + "->" + square_objects[i].end + "]");
            }
        }
    }

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

    public Square[] initialize_board(int number_of_squares, int[][] ladder_or_snake) {
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

        //placing the ladders and snakes
        for (int[] item : ladder_or_snake) {
            LadderOrSnake ladder_snake = new LadderOrSnake(item[0], item[1]);
            square_objects[item[0]] = ladder_snake;
        }

        return square_objects;
    }

    public



    public static void main(String[] args) {

        initialize_game(["Robert", "Michael"]; 12; [[3, 5], [8, 10], [7, 2]]);

        while (game_is_over = false) {
            for (player: player_objects) {

            }
        }
    }
}
