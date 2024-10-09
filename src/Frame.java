import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame{

    Snake snake = new Snake();

    Frame(String title, int x_dimension, int y_dimension){
        this.setTitle(title);
        this.setSize(x_dimension, y_dimension);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);


        //ImageIcon icon = new ImageIcon("src/rocket2.jpg");
        //this.setIconImage(icon.getImage());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_DOWN:
                        snake.head.setCurrent_direction(DIRECTIONS.DOWN);
                        break;
                    case KeyEvent.VK_UP:
                        snake.head.setCurrent_direction(DIRECTIONS.UP);
                        break;
                    case KeyEvent.VK_LEFT:
                        snake.head.setCurrent_direction(DIRECTIONS.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.head.setCurrent_direction(DIRECTIONS.RIGHT);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }


}
