import java.lang.Math;

public class Player {

    private int field = 1;
    String name;

    Player(String name) {
        this.name = name;
    }

    private void move() {
      int dice = (int) (Math.random() * 6 + 1);
      field += dice;
    }
}
