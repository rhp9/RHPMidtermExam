import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

class Aal extends JFrame implements Runnable
{
	public Thread t;
	public volatile boolean flag = false;
	public JButton bAal;
	
   public Aal()
	 {
	
		 setTitle("Aal");
		 setSize(100,100);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setUndecorated(true);
		 setShape(new Ellipse2D.Double(0,0,100,100));
		
		 getContentPane().setBackground(Color.LIGHT_GRAY);
		 getContentPane().setLayout(null);
		 
		bAal = new JButton("AAL");
		bAal.setBackground(Color.LIGHT_GRAY);
		 bAal.setBounds(12, 44, 70, 15);
		 getContentPane().add(bAal);
		

		 t=new Thread(this);
		
			t.start();
	 
	 }

	public void run()
	{
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		 int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		 int diameter = Math.min(width, height);
		 int radius = (int) ((diameter / 2f) - 200);
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
								  posx = (int) (x + radius*Math.cos(theta));
								  posy = (int) (y+ radius*Math.sin(theta));
							  
							  setLocation(posx,posy);
							
							  Thread.sleep(4);
							  	
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
		String name="Atmospheric Assault Lander";
		
		String data="An Atmospheric Assault Lander (AAL), also known as a First Order Transporter,\n was anarmored troop carrier operated by the First Order,\n designed to ferry up to twenty stormtroopers from orbital vessels to planetary surfaces.";
		
		
		
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
		
		 new Finalizer();
		 
	 }
}
