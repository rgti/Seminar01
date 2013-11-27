import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;


public class BasicWindow {

	protected static boolean isRunning = false;

	public static void main(String[] args) {
	    (new BasicWindow()).execute();
	}
	
	protected void execute() {
	    try {
	      initDisplay();
	    } catch (LWJGLException e) {
	      System.err.println("Can't open display.");
	      System.exit(0);
	    }

	    BasicWindow.isRunning = true;
	    mainLoop();
	    Display.destroy();
	}

	protected void mainLoop() {
	    setupView();

	    while (BasicWindow.isRunning) {
	    	resetView();

	    	renderFrame();

	    	processInput();

	    	Display.update();
	    }
	}

	protected void setupView() {

	}

	protected void resetView() {

	}

	protected void renderFrame() {
		  
	}

	protected void processInput() {
	    if (Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
	    	BasicWindow.isRunning = false;
	    }
	}

	protected void initDisplay() throws LWJGLException {
	    DisplayMode bestMode = null;
	    DisplayMode[] dm = Display.getAvailableDisplayModes();
	    for (int nI = 0; nI < dm.length; nI++) {
	    	DisplayMode mode = dm[nI];
	    	if (mode.getWidth() == 1024 && mode.getHeight() == 768
	    			&& mode.getFrequency() <= 85) {
	    		if (bestMode == null || (mode.getBitsPerPixel() >= bestMode.getBitsPerPixel() && mode
	    				.getFrequency() > bestMode.getFrequency())) {
	    			bestMode = mode;
	    		}
	    	}
	    }

	    Display.setDisplayMode(bestMode);
//	    FSAA
	    Display.create(new PixelFormat(8, 8, 8, 4));
//	    No FSAA
//	    Display.create();
	    Display.setTitle(this.getClass().getName());
	    
	    System.out.println("Version: " + GL11.glGetString(GL11.GL_VERSION));
	    System.out.println("Vendor: " + GL11.glGetString(GL11.GL_VENDOR));
	}

	public static ByteBuffer allocBytes(int howmany) {
	    return ByteBuffer.allocateDirect(howmany).order(ByteOrder.nativeOrder());
	}

	public static IntBuffer allocInts(int howmany) {
	    return ByteBuffer.allocateDirect(howmany).order(ByteOrder.nativeOrder())
	    .asIntBuffer();
	}

	public static FloatBuffer allocFloats(int howmany) {
	    return ByteBuffer.allocateDirect(howmany).order(ByteOrder.nativeOrder())
	    .asFloatBuffer();
	}

	public static ByteBuffer allocBytes(byte[] bytearray) {
	    ByteBuffer bb = ByteBuffer.allocateDirect(bytearray.length * 1).order(
	        ByteOrder.nativeOrder());
	    bb.put(bytearray).flip();
	    return bb;
	}

	public static IntBuffer allocInts(int[] intarray) {
	    IntBuffer ib = ByteBuffer.allocateDirect(intarray.length * 4).order(
	        ByteOrder.nativeOrder()).asIntBuffer();
	    ib.put(intarray).flip();
	    return ib;
	}

	public static FloatBuffer allocFloats(float[] floatarray) {
	    FloatBuffer fb = ByteBuffer.allocateDirect(floatarray.length * 4).order(
	        ByteOrder.nativeOrder()).asFloatBuffer();
	    fb.put(floatarray).flip();
	    return fb;
	}
}
