import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        Frame mainFrame = new Frame("Swing Practice", 600, 480);
        mainFrame.setLayout(null);

        Snake snake =new Snake();
        Coin coin = new Coin(mainFrame.getWidth(), mainFrame.getHeight());

        mainFrame.add(coin);

        snake.registerCoin(coin);
        snake.display(mainFrame);
        snake.moveSnake(mainFrame, 80);



    }
}