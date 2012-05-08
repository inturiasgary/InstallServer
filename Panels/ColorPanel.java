package panels;

import java.awt.*;
import javax.swing.JPanel;

public class ColorPanel extends JPanel
{
    public ColorPanel(Color col)
    {
        this.setBackground(col);
    }
    public ColorPanel(Color col, int width, int height)
    {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(col);
    }
}
