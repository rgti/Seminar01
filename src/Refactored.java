import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;


public class Refactored extends BasicWindow{
	
	float posX = 0, posY = 0, posZ = 0, rotX = 0, rotY = 180, scale = 1;
	int user=1;
	Camera camera;
	
	protected void setupView() {    
		initializeModels();
		
		// enable depth buffer (off by default)
		//GL11.glEnable(GL11.GL_DEPTH_TEST); 
		// enable culling of back sides of polygons
		GL11.glEnable(GL11.GL_CULL_FACE);
		
		// mapping from normalized to window coordinates
		GL11.glViewport(0, 0, 1024, 768);
		
		// setup projection matrix stack
		//GL11.glMatrixMode(GL11.GL_PROJECTION);
		//GL11.glLoadIdentity();
		//GLU.gluPerspective(45, 1024 / (float)768, 1.0f, 30.0f);
		
		setCameraMatrix();    
	}
	    
	protected void setCameraMatrix() {
		camera = new Camera(70, (float)Display.getWidth()/(float)Display.getHeight(), 0.3f, 1000f);
		camera.setY(-0.6f);
		camera.setZ(-2f);
		camera.useView();
	}
	
	
	protected void initializeModels() {
		
	}
	
	protected void resetView() {
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	    glLoadIdentity();
	    camera.useView();
	    glPushMatrix();
		{
			glColor3f(1.0f,0.5f,0f);
			glTranslatef(0, +3f,-10);

			glBegin(GL_QUADS);
			{
				//"Road"
				glColor3f(1f,1f,1f);
				glVertex3f(-2,0,-500);
				glVertex3f(2,0,-500);
				glVertex3f(2,0,0);
				glVertex3f(-2,0,0);
	
			}
			glEnd();
		}
		glPopMatrix();
		
		glPushMatrix();
		{
			glColor3f(1.0f,0.5f,0f);
			glTranslatef(0, +2.99f,-10);

			glBegin(GL_QUADS);
			{
				// Lines
				glColor3f(0f,0f,0f);
				glVertex3f(-0.5f,0,-90);
				glVertex3f(0.5f,0,-90);
				glVertex3f(0.5f,0,0);
				glVertex3f(-0.5f,0,0);
				
				glVertex3f(-0.5f,0,-190);
				glVertex3f(0.5f,0,-190);
				glVertex3f(0.5f,0,-100);
				glVertex3f(-0.5f,0,-100);
				
				glVertex3f(-0.5f,0,-290);
				glVertex3f(0.5f,0,-290);
				glVertex3f(0.5f,0,-200);
				glVertex3f(-0.5f,0,-200);
				
				glVertex3f(-0.5f,0,-390);
				glVertex3f(0.5f,0,-390);
				glVertex3f(0.5f,0,-300);
				glVertex3f(-0.5f,0,-300);
				
				glVertex3f(-0.5f,0,-490);
				glVertex3f(0.5f,0,-490);
				glVertex3f(0.5f,0,-400);
				glVertex3f(-0.5f,0,-400);
	
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	protected void renderFrame() {
		
	}
	
	protected void processInput() {
		super.processInput();
	}
	  
	public static void main(String[] args) {
	    (new Refactored()).execute();
	}  
}
