public class UserIdsGenerator {
	static private UserIdsGenerator instance;
	static private int generatedID;

	private UserIdsGenerator(){
		this.generatedID = 0;
	}
	public static UserIdsGenerator getInstance(){
		if(instance == null){
			instance = new UserIdsGenerator();
		}
		return instance;
	}
	public int generateId(){
		generatedID++;
		return generatedID;
	}
}
