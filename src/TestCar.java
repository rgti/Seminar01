import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL21;

public class TestCar extends Refactored 
{
	
  Obj3D obj3d;
  boolean forward, backward, left, right;
  float carSpeed = 0;

  protected void setupView()
  {
    super.setupView();   

    // lights
    GL11.glEnable(GL11.GL_LIGHTING);
    GL11.glEnable(GL11.GL_LIGHT0);

    GL11.glLightModel(GL11.GL_LIGHT_MODEL_AMBIENT, allocFloats(new float[] {0.1f, 0.1f, 0.1f, 1.0f }));
    
    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, allocFloats(new float[] { 0f, 2f, 1.0f, 0f}));
    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, allocFloats(new float[] { 1.0f, 1.0f, 1.0f, 0.1f}));
    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE , allocFloats(new float[] { 1.0f, 1.0f, 1.0f, 1.0f}));      
    GL11.glLight( GL11.GL_LIGHT0, GL11.GL_SPECULAR, allocFloats(new float[] { 1.0f, 1.0f, 1.0f, 1.0f}) );    
    
    GL11.glLightf( GL11.GL_LIGHT0, GL11.GL_CONSTANT_ATTENUATION, 0.0f ); 
    GL11.glLightf( GL11.GL_LIGHT0, GL11.GL_LINEAR_ATTENUATION , 0.0f );  
    GL11.glLightf( GL11.GL_LIGHT0, GL11.GL_QUADRATIC_ATTENUATION , 0.0002f );

  }

  protected void initializeModels()
  {
    obj3d = new Obj3D("police_car.obj");
    obj3d.setScaling(0.15f, 0.15f, 0.15f);
  } 

  /**
   * Renders current frame
   */
  protected void renderFrame()
  {
    obj3d.setPosition(posX, posY, posZ);
    obj3d.setRotation(rotX, rotY ,0);
    obj3d.render3D();
        
  }

  /**
   * Processes Keyboard and Mouse input and spawns actions
   */  
  	protected void processInput(){
  		forward = Keyboard.isKeyDown(Keyboard.KEY_UP);
  		backward = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
  		left = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
  		right = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
  		
  		
  		if (left){
  			if (rotY < 210) {
				rotY += 0.1f;
			}
  			
  			if(forward){
  				
  			}else if(backward){
  				
  			}
  		}
  		
  		if (right){
  			if (rotY > 150) {
				rotY -= 0.1f;
			}
  			
  			if(forward){
  				
  			}else if(backward){
  				
  			}
  		}
  	
  		if (forward){
  			if(carSpeed<1){
  				carSpeed += 0.001;
  			}
  			posZ -= calculateSpeed(carSpeed)/8000;
  			camera.moveZ(calculateSpeed(carSpeed)/8000);
  		}
  		
  		if (backward){
  			if(carSpeed<1){
  				carSpeed += 0.001;
  			}
  			posZ += calculateSpeed(carSpeed)/16000;
  			camera.moveZ(-calculateSpeed(carSpeed)/16000);
  			
  		}
  		
  		
  		System.out.println("Hitrost: " + carSpeed);
  		super.processInput();
  	}
  	
  protected float calculateSpeed(float carSpeed){
	  return (float) (carSpeed * Math.exp(10-carSpeed));
  }

  public static void main(String[] args) {
    (new TestCar()).execute();
  }  
}
