import org.lwjgl.opengl.GL11;


public class DrawCar extends Refactored {
	
	Obj3D obj3d;
	
	protected void setupView(){
		super.setupView();
		
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
	
	protected void initializeModels(){
		obj3d = new Obj3D("vaz_2106.obj");
		obj3d.setScaling(0.015f, 0.015f, 0.015f);
	}
	
	protected void renderFrame(){
		obj3d.setPosition(posX, posY, posZ);
		obj3d.setRotation(rotX, rotY, 0);
		obj3d.render3D();
	}
	
	protected void processInput(){
		super.processInput();
	}
	
	public static void main(String[] args) {
	    (new DrawCar()).execute();
	} 
}
