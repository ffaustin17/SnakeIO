import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class Snake {
    Deque<Block> body = new ArrayDeque<Block>();
    Block head;
    boolean first_time = true;
    Coin coin = new Coin(500,500);

    Snake(){
        head = new Block(300, 150);
        body.addFirst(head);

        //append the rest of the body to the head
        this.addNewBlock();
        this.addNewBlock();
        this.addNewBlock();
        this.addNewBlock();


    }

    private void addNewBlock(){
        Block tail = body.getLast();

        int new_block_x_coord = 0;
        int new_block_y_coord = 0;

        switch(tail.current_direction){
            case LEFT :
                new_block_x_coord = tail.getX() + tail.getWidth();
                new_block_y_coord = tail.getY();
                break;
            case RIGHT :
                new_block_x_coord = tail.getX() - tail.getWidth();
                new_block_y_coord = tail.getY();
                break;
            case UP :
                new_block_x_coord = tail.getX();
                new_block_y_coord = tail.getY() + tail.getHeight();
                break;
            case DOWN :
                new_block_x_coord = tail.getX();
                new_block_y_coord = tail.getY() - tail.getHeight();
                break;
        }

        Block new_block = new Block(new_block_x_coord, new_block_y_coord);

        tail.after = new_block;
        new_block.before = tail;

        new_block.current_direction = tail.current_direction;

        body.add(new_block);
    }

    public void display(Frame frame){

        if(first_time){

            frame.snake = this;

            for(Block block:body){
                frame.add(block);
            }

            first_time = false;
        }
        else{
            frame.snake = this;
            frame.add(this.body.getLast());
            frame.revalidate();
        }
    }

    public void moveSnake(Frame frame, int delay){
        Snake finalTemp = this;

        Timer t = new Timer(delay, new
                ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        for (Block block : body) {
                            block.translate(frame.getWidth(), frame.getHeight() );
                        }

                        //System.out.println("snake's head coordinates: (" + head.getX() + " , " + head.getY() + ")");
                        //System.out.println("coin coordinates: (" + coin.getX() + " , " + coin.getY() + ")");

                        if(((head.getX() + ((int)(head.getWidth()/2))  >= coin.getX()) && (head.getX() + ((int)(head.getWidth()/2)) <= coin.getX() + coin.getWidth()) )&& ((head.getY() + ((int)(head.getHeight()/2)) >= coin.getY() )&& (head.getY() + ((int)(head.getHeight()/2)) <= coin.getY() + coin.getHeight()))){
                            coin.regenerate();
                            finalTemp.addNewBlock();
                            finalTemp.display(frame);
                        }

                    }
                });

        t.start();
    }


    public void registerCoin(Coin coin){
        this.coin = coin;
    }


}
