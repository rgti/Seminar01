import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;


public class Refactored extends BasicWindow{
	
	float posX = 0, posY = 0, posZ = 0, rotX = 0, rotY = 0, scale = 1;
	int user=1;
	
	protected void setupView() {    
		initializeModels();
		
		// enable depth buffer (off by default)
		GL11.glEnable(GL11.GL_DEPTH_TEST); 
		// enable culling of back sides of polygons
		GL11.glEnable(GL11.GL_CULL_FACE);
		
		// mapping from normalized to window coordinates
		GL11.glViewport(0, 0, 1024, 768);
		
		// setup projection matrix stack
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluPerspective(45, 1024 / (float)768, 1.0f, 30.0f);
		
		setCameraMatrix();    
	}
	    
	protected void setCameraMatrix() {
		
	}
	
	
	protected void initializeModels() {
		
	}
	
	protected void resetView() {
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
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
