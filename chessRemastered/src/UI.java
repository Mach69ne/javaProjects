import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UI
{
    public static void start() throws IOException
    {
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true); // Whether to have buttons and bar on UI
        BufferedImage all = ImageIO.read(new File("e:\\downloads2/chess.png"));
        Image[] imgs = new Image[12];
        int ind = 0;
        for (int y = 0; y < 400; y += 200)
        {
            for (int x = 0; x < 1200; x += 200)
            {
                imgs[ind] = all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
        JPanel panel = new JPanel()
        {
            @Override
            public void paint(Graphics g)
            {
                boolean white = true;
                for (int i = 0; i < 8; i++)
                {
                    for (int k = 0; k < 8; k++)
                    {
                        if (white)
                        {
                            g.setColor(new Color(235, 235, 208));
                        }
                        else
                        {
                            g.setColor(new Color(119, 148, 85));
                        }
                        g.fillRect(i * 64, k * 64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }
            }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }
}
