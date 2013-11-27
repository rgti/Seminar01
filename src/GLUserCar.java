
public class GLUserCar extends Refactored{
	Obj3D usersCar;
	
	protected void initializeModels(){
		usersCar = new Obj3D("carUser.obj");
	} 
	
	 protected void setupView(){
	    super.setupView(); 
	  }
	
	protected void renderFrame(){
		usersCar.setPosition(5, 5, 5);
		usersCar.setRotation(0, 0, 0);
		usersCar.render3D();
	}

	
	protected void processInput(){
	    super.processInput();
	}
	
	public static void main(String[] args) {
	    (new GLUserCar()).execute();
	}  
		
}
