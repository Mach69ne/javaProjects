import Pieces.Piece;
import Pieces.PieceManager;
import Pieces.Position;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// I know code quality in here sucks, but I practically stole it from the internet, so deal with it :)


public class UI
{
    JFrame frame;
    BufferedImage img;
    Image[] imgs = new Image[12];
    MouseListener mouseListener = new MouseListener();


    public UI() throws IOException
    {
        this.frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true); // Whether to have buttons and bar on UI
        this.img = ImageIO.read(new File("src/Images/chess.png"));

        int ind = 0;
        for (int y = 0; y < 400; y += 200)
        {
            for (int x = 0; x < 1200; x += 200)
            {
                imgs[ind] = img.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }

    }

    public void update()
    {


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


                for (int i = 0; i < 8; i++)
                {
                    for (int k = 0; k < 8; k++)
                    {

                        int ind = 0;
                        Piece piece = PieceManager.pieceOnSquare(new Position(i, 7 - k));


                        if (piece == null)
                        {
                            continue;
                        }

                        switch (piece.getSymbol())
                        {
                            case 'K':
                            {
                                break;
                            }
                            case 'Q':
                            {
                                ind = 1;
                                break;
                            }
                            case 'B':
                            {
                                ind = 2;
                                break;
                            }
                            case 'N':
                            {
                                ind = 3;
                                break;
                            }
                            case 'R':
                            {
                                ind = 4;
                                break;
                            }
                            case 'P':
                            {
                                ind = 5;
                                break;
                            }
                        }
                        if (!piece.isWhite())
                        {
                            ind += 6;
                        }
                        if (mouseListener.getOriginalPosition() != null)
                        {
                            int xPosition = Math.floorDiv(mouseListener.getOriginalPosition().x(), 64);
                            int yPosition = Math.floorDiv(mouseListener.getOriginalPosition().y(), 64);
                            yPosition -= 7;
                            yPosition *= -1;
                            System.out.println(xPosition + " " + yPosition);
                            if (piece.getPosition().x() == xPosition && piece.getPosition().y() == yPosition)
                            {
                                if (mouseListener.currentPosition != null)
                                {
                                    g.drawImage(imgs[ind], mouseListener.getCurrentPosition().x() - 32,
                                            mouseListener.getCurrentPosition().y() - 32, this);
                                    continue;
                                }

                            }
                        }


                        g.drawImage(imgs[ind], i * 64, k * 64, this);

                    }
                }
            }
        };
        frame.revalidate();
        frame.add(panel);
        panel.revalidate();
        panel.addMouseListener(mouseListener);
        frame.repaint();
        frame.setVisible(true);
    }

    private class MouseListener implements java.awt.event.MouseListener
    {
        private Position originalPosition = null;
        private Position currentPosition = null;
        private boolean isPressed = false;

        @Override
        public void mouseClicked(MouseEvent e)
        {
            isPressed = true;

            this.originalPosition = new Position(e.getX(), e.getY());

        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            if (isPressed)
            {
                this.currentPosition = new Position(e.getX(), e.getY());
                UI.this.update();
            }


        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            originalPosition = null;
            currentPosition = null;
            UI.this.update();
            isPressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {

        }

        @Override
        public void mouseExited(MouseEvent e)
        {

        }

        public Position getOriginalPosition()
        {
            return originalPosition;
        }

        public Position getCurrentPosition()
        {
            return currentPosition;
        }

    }
}
