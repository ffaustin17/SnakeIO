import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Coin extends JPanel {

    Position pos;
    enum size{BIG, SMALL};

    size actual_size;
    int frame_width;
    int frame_height;
    Coin(int frame_width, int frame_length){
        Random rand = new Random();

        this.frame_width = frame_width - 40;
        this.frame_height = frame_length - 40;


        int a = rand.nextInt(2);

        switch(a){
            case 0:
                this.actual_size = size.BIG;
                break;
            case 1:
                this.actual_size = size.SMALL;
                break;
            default:
                this.actual_size = size.SMALL;
                break;
        }

        int x_coord = rand.nextInt(frame_width);
        int y_coord = rand.nextInt(frame_length);

        if(this.actual_size == size.BIG) {
            x_coord = x_coord - (x_coord % 10);
            y_coord = y_coord - (y_coord % 10);
        }
        else{
            x_coord = (x_coord - (x_coord % 10)) + 2;
            y_coord = (y_coord - (y_coord % 10)) + 2;
        }

        this.pos = new Position(x_coord,y_coord);

        switch(this.actual_size){
            case BIG :
                this.setBounds(this.pos.x, this.pos.y, 10, 10);
                break;
            case SMALL:
            default:
                this.setBounds(this.pos.x, this.pos.y, 5, 5);
                break;
        }

        this.setBackground(Color.WHITE);



    }

    public void regenerate(){
        Random rand = new Random();


        int a = rand.nextInt(2);

        switch(a){
            case 0:
                this.actual_size = size.BIG;
                break;
            case 1:
                this.actual_size = size.SMALL;
                break;
            default:
                this.actual_size = size.SMALL;
                break;
        }


        int x_coord = rand.nextInt(frame_width);
        int y_coord = rand.nextInt(frame_height);

        if(this.actual_size == size.BIG) {
            x_coord = x_coord - (x_coord % 10);
            y_coord = y_coord - (y_coord % 10);
        }
        else{
            x_coord = (x_coord - (x_coord % 10)) + 2;
            y_coord = (y_coord - (y_coord % 10)) + 2;
        }


        this.pos.x = x_coord;
        this.pos.y = y_coord;

        switch(this.actual_size){
            case BIG :
                this.setBounds(this.pos.x, this.pos.y, 10, 10);
                break;
            case SMALL:
            default:
                this.setBounds(this.pos.x, this.pos.y, 5, 5);
                break;
        }

        this.setBackground(Color.WHITE);


        this.setLocation(pos.x, pos.y);

    }
}
