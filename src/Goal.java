import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Goal extends GameObject {
	public static Image graphic; 
	private Image eye;
	private double rot = 0;
	private double dis = 30;
	private double dir = 0.5;
	public Goal(double x, double y,GraphicsContext gc) {
		super(graphic, x, y,gc);
		eye = new Image("/res/goaleye.png");
	}
	
	public void update(){
		//rot += 0.01;
		rot = Math.PI/8;
		dis += dir;
		if(dis > 50)
			dir = -0.5;
		else if(dis < 30)
			dir = 0.5;
		
		double dirx = Math.cos(rot)*dis;
		double diry = Math.sin(rot)*dis;
		gc.drawImage(eye, x+dirx-3, y+diry-3);
		gc.drawImage(eye, x-dirx-3, y+diry-3);
		gc.drawImage(eye, x-dirx-3, y-diry-3);
		gc.drawImage(eye, x+dirx-3, y-diry-3);
		gc.drawImage(eye, x+diry-3, y+dirx-3);
		gc.drawImage(eye, x-diry-3, y+dirx-3);
		gc.drawImage(eye, x-diry-3, y-dirx-3);
		gc.drawImage(eye, x+diry-3, y-dirx-3);
		super.update();
		//gc.fillRect(x-3, y-3, 10, 10);
	}

}
