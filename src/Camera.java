import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera {
	
	private float x, y, z;
	private float rX, rY, rZ;
	
	private float fov;
	private float aspect;
	private float near;
	private float far;
	
	public Camera (float fov, float aspect, float near, float far){
		x = 0;
		y = 0;
		z = 0;
		rX = 0;
		rY = 0;
		rZ = 0;
		this.fov = fov;
		this.aspect = aspect;
		this.near = near;
		this.far = far;
		initProjection();
	}
	
	private void initProjection(){
		// Preklop na projekcijsko matriko
		glMatrixMode(GL_PROJECTION);
		// Resetiranje matrike
		glLoadIdentity();
		gluPerspective(fov, aspect, near, far);
		// Preklopimo nazaj na model view
		glMatrixMode(GL_MODELVIEW);
		// Vklop globine
		glEnable(GL_DEPTH_TEST);
	}
	
	public void useView(){
		// Rotacija
		glRotatef(rX, 1, 0, 0);
		glRotated(rY, 0, 1, 0);
		glRotated(rZ, 0, 0, 1);
		// Transacija
		glTranslatef(x, y, z);
	}
	
	// Premikanje kamere
	public void moveZ(float speed){
		z += speed;
	}
	
	public void moveX(float speed){
		x += speed;
	}
	
	// Rotiranje kamere
	public void rotateY(float alpha){
		rY += alpha;
	}
	
	/*----------------------*/
	/* Getterji in setterji */
	/*----------------------*/

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getrX() {
		return rX;
	}

	public void setrX(float rX) {
		this.rX = rX;
	}

	public float getrY() {
		return rY;
	}

	public void setrY(float rY) {
		this.rY = rY;
	}

	public float getrZ() {
		return rZ;
	}

	public void setrZ(float rZ) {
		this.rZ = rZ;
	}

	public float getFov() {
		return fov;
	}

	public void setFov(float fov) {
		this.fov = fov;
	}

	public float getAspect() {
		return aspect;
	}

	public void setAspect(float aspect) {
		this.aspect = aspect;
	}

	public float getNear() {
		return near;
	}

	public void setNear(float near) {
		this.near = near;
	}

	public float getFar() {
		return far;
	}

	public void setFar(float far) {
		this.far = far;
	}
}
