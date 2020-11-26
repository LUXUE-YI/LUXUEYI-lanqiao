import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;

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

class MainCanvas extends Canvas implements Runnable {
	
    Random rd = new Random();

	Thread thread;
	Image bossImg;
	int bossX,bossY;

	Image heroImage[][] =new Image[4][3];
    Image currentImg;

	int heroX,heroY;
	int flag;

	public MainCanvas(){

		try{

			for(int i=0; i < heroImage.length; i++){
			    for (int j=0; j < heroImage[i].length; j++) {
                     heroImage[i][j] = Image.createImage("/sayo" + i + j +".png");
			    }
			}

           currentImg = heroImage[3][1] ;
		   bossImg=Image.createImage("/zuzu000.png");
           System.out.println("ss");
           bossX=0;
		   bossY=0;

		   heroX=120;
		   heroY=100;

		   flag = 0;

		   thread=new Thread(this);
		   thread.start();

		}
		catch(IOException e){
			e.printStackTrace();
		}

	
	}


	public void run(){
		while(true){

			int rdNumber = rd.nextInt(10);

			try{
				Thread.sleep(200);//FPS£ºÆÁÄ»Ë¢ÐÂÂÊ
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}

            if(rdNumber%3 == 0){
			
				if(bossX<heroX){
					bossX++;
				}else{
					bossX--;
				}

				if(bossY<heroY){
					bossY++;
				}else{
					bossY--;
				}
			}
			repaint();

		}
	}


	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);

	}

	public void keyPressed(int keyCode){
		int action = getGameAction(keyCode);

        if(action == UP){
		   currentImg=heroImage[2][1];
           changePicAndDirection(2);
		   heroY = heroY - 1;
		}

		else if(action == DOWN){
		   currentImg=heroImage[3][1];

           changePicAndDirection(3);

		   heroY = heroY + 1;
		}

		else if(action == LEFT){
		   currentImg=heroImage[0][1];
		   
		   changePicAndDirection(0);

		   heroX = heroX-1;
		}
		
		else if(action == RIGHT){
		   currentImg=heroImage[1][1];

		   changePicAndDirection(1);

		   heroX = heroX+1;
		}
	}

	void changePicAndDirection(int direction){
		   if(flag == 0){
			   currentImg=heroImage[direction][0];
			   flag = 1;
		   }else if(flag == 1){
			   currentImg=heroImage[direction][2];
			   flag = 0;	
		   }
	}

}