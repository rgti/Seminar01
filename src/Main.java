import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;


public class Main {
	
	public static void main(String[] args){
		
		// Kreiranje displaya
		initDisplay();
		// Game loop
		gameLoop();
		// Clean up
		cleanUp();
	}
	
	private static void gameLoop(){
		// Kreiranje kamere
		Camera camera = new Camera(70, (float)Display.getWidth()/(float)Display.getHeight(), 0.3f, 1000f);
		 float posX = 0, posY = -5f, posZ = -10f, rotX = 0, rotY = 0, rotZ = 0;
		 float movZ = 0;
		 float movY = 0;
		 int delay = 0;
		// Game loop
		while (!Display.isCloseRequested()){
			// Brisanje color bufferja in nalaganje identitete
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			// Setitanje pogleda kamere
			camera.useView();
			
			//Branje ukazov igralca
			if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
				if (rotY < 30) {
					rotY += 0.05f;
				}
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
				if (rotY > -30) {
					rotY -= 0.05f;
				}
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_UP)){
				posZ -= 0.1f;
				if (delay == 50){
					camera.moveZ(0.1f);
				} else {
					delay++;
				}
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
				posZ += 0.1f;
				if (delay == -20){
					camera.moveZ(-0.1f);
				} else {
					delay--;
				}
			}
			
			if (movZ == posZ && delay != 0){
				if (delay < 0){
					camera.moveZ(-0.1f);
					delay++;
				} else {
					camera.moveZ(0.1f);
					delay--;
				}
			}
			
			if (rotY == movY && rotY != 0){
				if (rotY > 0){
					rotY -= 0.05f;
				} else {
					rotY += 0.05f;
				}
			}
			
			movZ = posZ;
			movY = rotY;
			
			glPushMatrix();
			{
				
				glColor3f(1.0f,0.5f,0f);
				glTranslatef(posX,-4f,posZ);
				glRotatef(rotX,1,0,0);
				glRotatef(rotY,0,1,0);
				glRotatef(rotZ,0,0,1);
	
				glBegin(GL_QUADS);
				{
					//FrontFace
					glColor3f(1f,0f,0f);
					glVertex3f(-1,-1,1);
					glVertex3f(1,-1,1);
					glVertex3f(1,1,1);
					glVertex3f(-1,1,1);
		
					//BackFace
					glColor3f(0f,1f,0f);
					glVertex3f(-1,-1,-1);
					glVertex3f(-1,1,-1);
					glVertex3f(1,1,-1);
					glVertex3f(1,-1,-1);
		
					//BottomFace
					glColor3f(0f,0f,1f);
					glVertex3f(-1,-1,-1);
					glVertex3f(-1,-1,1);
					glVertex3f(-1,1,1);
					glVertex3f(-1,1,-1);
		
					//TopFace
					glColor3f(1f,1f,0f);
					glVertex3f(1,-1,-1);
					glVertex3f(1,-1,1);
					glVertex3f(1,1,1);
					glVertex3f(1,1,-1);
		
					//LeftFace
					glColor3f(0f,1f,1f);
					glVertex3f(-1,-1,-1);
					glVertex3f(1,-1,-1);
					glVertex3f(1,-1,1);
					glVertex3f(-1,-1,1);
		
					//Right Face
					glColor3f(1f,0f,1f);
					glVertex3f(-1,1,-1);
					glVertex3f(1,1,-1);
					glVertex3f(1,1,1);
					glVertex3f(-1,1,1);
				}
				glEnd();
			}
			glPopMatrix();
			
			glPushMatrix();
			{
				glColor3f(1.0f,0.5f,0f);
				glTranslatef(posX,posY,-10);
	
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
				glTranslatef(posX,posY+0.01f,-10);
	
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
			
			//  Posodabljanje displaya
			Display.update();
		}
	}

	private static void initDisplay(){
		// Kreiranje displaya
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	private static void cleanUp() {
		// Clean up displaya
		Display.destroy();
	}
}
