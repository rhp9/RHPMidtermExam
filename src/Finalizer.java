import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

class Finalizer extends JFrame implements Runnable
{
	public Thread t;
	public volatile boolean flag = false;
	public JButton bFin;
	
   public Finalizer()
	 {
   	setBackground(Color.GRAY);
	
		
		 setTitle("Finalizer");
		 setSize(100,100);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setUndecorated(true);
		 setShape(new Ellipse2D.Double(0,0,100,100));
		
		 getContentPane().setBackground(Color.GRAY);
		 getContentPane().setLayout(null);
		 
		 bFin = new JButton("Finalizer");
		 bFin.setForeground(Color.WHITE);
		 bFin.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 8));
		 bFin.setBackground(Color.GRAY);
		 bFin.setBounds(12, 44, 76, 23);
		 getContentPane().add(bFin);
			
		 t=new Thread(this);

			t.start();
	 
	 }

	public void run()
	{
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		 int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		 int diameter = Math.min(width, height);
		 int radius = (int) ((diameter / 2f) - 50);
		 int posx =0,posy =0,x,y;
		 			
					 try
					 {
						 float degrees = 0;

						
						  
						  for(int i=0;i<=width;i++)
						  {
						
							  
							  if(i == width || i == height) 
							  { 
								  i=0;						 
							  }
							  
							  x=(Toolkit.getDefaultToolkit().getScreenSize().width)/2;
							  y=(Toolkit.getDefaultToolkit().getScreenSize().height)/2;
							  
							  
							 	int theta = (int) (Math.toRadians(degrees -90));
								  posx = (int) (x - radius*Math.cos(theta));
								  posy = (int) (y+ radius*Math.sin(theta));
							  
							  
							
							  setLocation(posx,posy);
							
							  Thread.sleep(3);
							  	
							  degrees += 0.5f;			
							  
							  synchronized(this)
							  {
								  while(flag)
								  {
									  wait();
									  
								  }
							  }
							  
						  	}
					  
					 }
					 catch(Exception e)
					 {
						e.printStackTrace(); 
					 }
			
	
	}

	public void Visible(Boolean x)
	{
		setVisible(x);
		
	}

	public String Info()
	{
		String name="Finalizer";
		
		String data="The Finalizer was a Resurgent-class Star Destroyer used by the First Order approximately thirty years after the Battle of Endor.\nThe ship was under command of General Armitage Hux during Kylo Ren'sassault on the planet Jakku in an attempt to obtain\n Luke Skywalker's hiding position from a member of the Resistance.";
		
		
		
		return "Name: " + name + "\nData: "+ data;
	}
	
	
	public void suspend()
	{
		flag=true;
	}
	
	synchronized void resume()
	{
		flag=false;
		notify();
		
	}
	
 	public static void main(String args[])
	 {
		
		 new Aal();
		 
	 }
}
