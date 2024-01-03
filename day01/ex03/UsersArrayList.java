public class UsersArrayList implements UsersList{
	private int size;
	private int number;
	private User[] array;

	public UsersArrayList(){
		this.size = 10;
		this.number = 0;
		this.array = new User[size];
	}

	private User[] resizeArray(int newSize, User[] array){
		User[] newArray = new User[newSize];
		int i = -1;
		while(++i < this.size){
			newArray[i] = array[i];
		}
		return newArray;
	}

public void addUser(User user){
	int newSize;
	int i = -1;
	if(this.number == this.size){
		newSize = this.size + (this.size / 2);
		array = resizeArray(newSize, array);
		this.size = newSize;
	}
	while(++i < this.size){
		if(this.array[i] == null){
			this.array[i] = user;
			break;
		}
	}
	System.out.println("Adedd User: \n");
	this.array[i].printUser();
	this.number++;
}

	public User retriveByID(int id) {
		int i = -1;
		while(++i < size) {
			if(this.array[i].getID() == id) {
				return this.array[i];
			}
		}
		throw new UserNotFoundException("User with id " + id +" not found");
	}

	public User retriveByIndex(int index){
		if(number < index){
			throw new UserNotFoundException("User with id " + index +" not found");
		}
		return (this.array[index]);
		}

	public int numberUser(){
		return this.number;
	}

	public void				print() {
	System.out.println("\nLIST OF USER\n");
	for (int i = 0; i < this.number; i++) {
		this.array[i].printUser();
	}
}
}
