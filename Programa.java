import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Panels.ColorPanel;

public class Programa extends JFrame
{
    public Programa()
    {
        //Paneles en el frame
        ColorPanel CPOeste  = new ColorPanel(Color.white, 50, 50);
        ColorPanel CPEste   = new ColorPanel(Color.red);
        ColorPanel CPNorte  = new ColorPanel(Color.yellow);
        ColorPanel CPSur    = new ColorPanel(Color.green);
        ColorPanel CPCentro = new ColorPanel(Color.blue);

        //Adicionando los paneles al frame
        this.getContentPane().add(CPOeste, BorderLayout.WEST);
        this.getContentPane().add(CPEste, BorderLayout.EAST);
        this.getContentPane().add(CPNorte, BorderLayout.NORTH);
        this.getContentPane().add(CPSur, BorderLayout.SOUTH);
        this.getContentPane().add(CPCentro, BorderLayout.CENTER);
        
        this.setSize(200, 200);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrarFrame(){
        this.setVisible(true);
    }

    public void mostrarFrame(String title){
        this.setTitle(title);
        this.setVisible(true);
    }

    public void mostrarFrame(String title, int x, int y){
        this.setTitle(title);
        this.setLocation(x,y);
        this.setVisible(true);
    }

    public void ocultarFrame(){
        this.setVisible(false);
    }

    public static void main(String[] args)
    {
        Programa sFrame = new Programa();
        sFrame.mostrarFrame("Instalador de Servidores", 300, 300);
    }
}
