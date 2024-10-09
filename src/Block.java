import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.*;

public class Block extends JPanel {

    DIRECTIONS current_direction;
    static int speed = 10;
    Block before =null;
    Block after = null;
    Queue<Position> moving_positions;
    Queue<DIRECTIONS> next_directions;

    Block(int x_coord, int y_coord){
        this.setBounds(x_coord, y_coord, 10, 10);
        this.setBackground(Color.GREEN);

        current_direction = DIRECTIONS.RIGHT;

        moving_positions = new LinkedList<Position>();
        next_directions = new LinkedList<DIRECTIONS>();

    }

    public void translate(int frame_width, int frame_height){
        if((this.getX() <= (frame_width - 30) && this.getX() >= 0) && (this.getY() <= (frame_height - 30) && this.getY() >= 0)) {
            switch (current_direction) {
                case LEFT:
                    this.setLocation(this.getX() - speed, this.getY());
                    break;
                case RIGHT:
                    this.setLocation(this.getX() + speed, this.getY());
                    break;
                case UP:
                    this.setLocation(this.getX(), this.getY() - speed);
                    break;
                case DOWN:
                    this.setLocation(this.getX(), this.getY() + speed);
                    break;
                default:
                    break;

            }

            if (!this.moving_positions.isEmpty()) {
                if (this.getX() == this.moving_positions.element().getX() && this.getY() == this.moving_positions.element().getY()) {
                    this.setCurrent_direction(this.next_directions.element());

                    this.moving_positions.remove();
                    this.next_directions.remove();
                }
            }
        }



    }



    public void setCurrent_direction(DIRECTIONS direction){
        Block block_after = this.after;

        if(block_after != null) {

            Position pos_before_move = new Position(this.getX(), this.getY());

            block_after.moving_positions.add(pos_before_move);
            block_after.next_directions.add(direction);
        }

        this.current_direction = direction;
    }

}
