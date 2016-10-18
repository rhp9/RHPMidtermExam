import java.awt.Color;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StarkillerBase extends JFrame implements ActionListener
{

	JButton bStarKiller;
	
	public StarkillerBase()
	{
		
		 setTitle("Starkiller Base");
		 setSize(150,150);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setUndecorated(true);
		 setLocation(650,320);

		 
		 setShape(new Ellipse2D.Double(0,0,150,150));

		 getContentPane().setBackground(Color.CYAN);
		 getContentPane().setLayout(null);
		 
		 bStarKiller = new JButton("StarKiller Base");
		 bStarKiller.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 10));
		 bStarKiller.setBackground(Color.CYAN);
		 bStarKiller.setForeground(Color.RED);
		 bStarKiller.setBounds(12, 56, 126, 46);
		 bStarKiller.addActionListener(this);
		 getContentPane().add(bStarKiller);
		 

	}
	
	public void Visible(Boolean x)
	{
		setVisible(x);
		
	}
	
	public String Info()
	{
		String name="StarKiller Base";
		
		String data="The deadly Starkiller harvests energy from its system’s star, contains it within magnetic fields inside its base’s planetary core, \nand then converts that energy into an ultra-powerful beam that blasts through hyperspace,able to sterilize the worlds \nof a distant star system with a single shot.The icy world that houses the Starkiller is the First Order’s greatest secret,\n and essential to its plan to conquer the galaxy";
		
		
		
		return "Name: " + name + "\nData: "+ data;
	}
	
	public static void main(String args[])
	 {
	 new StarkillerBase();
	 }


	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bStarKiller)
		{
			Main.taDatos.setText(Info());
		}
		
	}
}
