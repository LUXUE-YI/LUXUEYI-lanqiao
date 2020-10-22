import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet{
	Display display;
	MainCanvas mc;

	public AI(){
		display = Display.getDisplay(this);
		mc = new MainCanvas();
		display.setCurrent(mc);
	}

	public void startApp(){
	}

	public void destroyApp(boolean unc){
	}

	public void pauseApp(){
	}
}

class MainCanvas extends Canvas{
	Image left[] = new Image[3];
	Image right[] = new Image[3];
	Image up[] = new Image[3];
	Image down[] = new Image[3];

    Image currentImg;
	int x,y;
	int flag;

	public MainCanvas(){

		try{

			for (int i = 0;i<3 ;i++ ){ 
				down[i] = Image.createImage("/sayo" + i +"0.png");
			}

			for (int i = 0;i<3 ;i++ ){ 
				left[i] = Image.createImage("/sayo" + i +"2.png");
			}
			
			for (int i = 0;i<3 ;i++ ){ 
				up[i] = Image.createImage("/sayo" + i +"4.png");
			}
			for (int i = 0;i<3 ;i++ ){ 
				right[i] = Image.createImage("/sayo" + i +"6.png");
			}

           currentImg = down[1];

		   x=120;
		   y=100;
		   flag = 0;

		}
		catch(IOException e){
			e.printStackTrace();
		}

	
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}

	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);

        if(action == UP){
		   currentImg=up[1];

		   if(flag == 0){
			   currentImg=up[0];
			   flag = 1;
			   repaint();
		   }else if(flag == 1){
			   currentImg=up[2];
			   flag = 0;	
			   repaint();
		   }

		   y = y - 5;
		   repaint();
		   System.out.println("向上转");
		}

		else if(action == DOWN){
		   currentImg=down[1];

           if(flag == 0){
			   currentImg=down[0];
			   flag = 1;
			   repaint();
		   }else if(flag == 1){
			   currentImg=down[2];
			   flag = 0;	
			   repaint();
		   }
		   y = y + 5;
		   repaint();
		   System.out.println("向下转");

		}

		else if(action == LEFT){
		   currentImg=left[1];
		   
		   if(flag == 0){
			   currentImg=left[0];
			   flag = 1;
			   repaint();
		   }else if(flag == 1){
			   currentImg=left[2];
			   flag = 0;	
			   repaint();
		   }
		   x = x-5;
		   repaint();
		   System.out.println("向左转");

		}
		
		else if(action == RIGHT){
		   currentImg=right[1];

		   if(flag == 0){
			   currentImg=right[0];
			   flag = 1;
			   repaint();
		   }else if(flag == 1){
			   currentImg=right[2];
			   flag = 0;	
			   repaint();
		   }

		   x = x+5;
		   repaint();
		   System.out.println("向右转");

		}

		
	}

}