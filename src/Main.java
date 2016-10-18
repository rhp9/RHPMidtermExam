import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class Main extends JFrame implements ActionListener
{
	
	StarkillerBase starkillerBase = new StarkillerBase();
	CommandShuttle ren = new CommandShuttle();
	Aal aal = new Aal();
	Finalizer fin= new Finalizer();
	StarkillerBase star= new StarkillerBase();
	
	JPanel panel1;
	JButton bPlay,bPause,bResume;
	static JTextArea taDatos;
	
	public Main()
	{
		setTitle("Main");
		setSize(712,194);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(0,550);
		
		panel1= new JPanel();
		panel1.setBounds(12, 31, 675, 155);
		getContentPane().setLayout(null);
		
		taDatos = new JTextArea();
		taDatos.setFont(new Font("Dialog", Font.PLAIN, 10));
		taDatos.setForeground(Color.WHITE);
		taDatos.setBackground(Color.GRAY);
		taDatos.setText("Beware of the First Order!");
		taDatos.setBounds(12, 58, 651, 63);
		panel1.add(taDatos);
		
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		bPlay = new JButton("Play");
		bPlay.setBounds(27, 12, 117, 25);
		bPlay.addActionListener(this);
		panel1.add(bPlay);
		
		bPause = new JButton("Pause");
		bPause.setBounds(225, 12, 117, 25);
		bPause.addActionListener(this);
		bPause.setVisible(false);
		panel1.add(bPause);
		
		bResume = new JButton("Resume");
		bResume.setBounds(469, 12, 117, 25);
		bResume.addActionListener(this);
		bResume.setVisible(false);
		panel1.add(bResume);
		
		ren.bCM.addActionListener(this);
		aal.bAal.addActionListener(this);
		fin.bFin.addActionListener(this);
;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource()==bPlay)
		{
			starkillerBase.Visible(true);
			ren.Visible(true);
			aal.Visible(true);
			fin.Visible(true);
			bPause.setVisible(true);
			bResume.setVisible(true);
			bPlay.setVisible(false);
		}
		
		if(evento.getSource()==bPause)
		{
				
				ren.suspend();
				aal.suspend();
				fin.suspend();
		}
		
		if(evento.getSource()==bResume)
		{
			bPlay.setVisible(false);
				ren.resume();
				aal.resume();
				fin.resume();
		}
		if(evento.getSource()==ren.bCM)
		{
			taDatos.setText(ren.Info());
		}
		if(evento.getSource()==aal.bAal)
		{
			taDatos.setText(aal.Info());
		}
		if(evento.getSource()==fin.bFin)
		{
			taDatos.setText(fin.Info());
		}
		/*if(evento.getSource()==star.bStarKiller)
		{
			taDatos.setText(star.Info());
		}*/
	}
	
    
	public static void main(String args[])
	 {
		
		new Main();
	 }
}

