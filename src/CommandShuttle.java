import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

class CommandShuttle extends JFrame implements Runnable
{
	public Thread t;
	public volatile boolean flag = false;
	public JButton bCM;
	
   public CommandShuttle()
	 {
	
		 
		 setTitle("Command Shuttle");
		 setSize(100,100);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setUndecorated(true);
		 setShape(new Ellipse2D.Double(0,0,100,100));
		
		 getContentPane().setBackground(Color.RED);
		 getContentPane().setLayout(null);
		 
		  bCM = new JButton("Command Shuttle");
		  bCM.setForeground(Color.WHITE);
		  bCM.setFont(new Font("DejaVu Sans", Font.PLAIN, 8));
		  bCM.setBackground(Color.RED);
		 bCM.setBounds(12, 23, 76, 53);
		 getContentPane().add(bCM);
		
		 t=new Thread(this);
			t.start();
	 
	 }

	public void run()
	{
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		 int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		 int diameter = Math.min(width, height);
		 int radius = (int) ((diameter / 2f) - 5);
		 int posx =0,posy =0,x,y;
		 			
					 try
					 {
						 float degrees = 0;
						
						 System.out.println(width +" "+height);
						
						  
						  for(int i=0;i<=width;i++)
						  {
						
							 
							  if(i == width || i == height) 
							  { 
								  i=0;
							  }
							  
							  x=(Toolkit.getDefaultToolkit().getScreenSize().width)/2;
							  y=(Toolkit.getDefaultToolkit().getScreenSize().height)/2;
							  
							  
							 	int theta = (int) (Math.toRadians(degrees -90));
								  posx = (int) (x + radius*Math.cos(theta));
								  posy = (int) (y+ radius*Math.sin(theta));
						
							  setLocation(posx,posy);
							
							  Thread.sleep(6);
							  	
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
		String name="Kylo Ren's Command Shuttle";
		
		String data="Kylo Ren's command shuttle was an Upsilon-class command shuttle utilized by Kylo Ren.\nHis ship led a group of Atmospheric Assault Landers to the Star Destroyer Finalizer.";
		
		
		
		return "Name: "+name+ "\nData: " + data;
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
		
		 new Finalizer();
		 
	 }
}
