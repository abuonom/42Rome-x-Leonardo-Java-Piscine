public class User {
	private int identifier;
	private String name;
	private int balance;

	public User(int balance){
		if(balance < 0){
			System.out.println("User balance cannot be negative");
			this.balance = 0;
		}
		else{
			this.balance = balance;
		}
	}

	public User(String name, int balance){
		this(balance);
		this.name = name;
	}

	public int getID(){
		return this.identifier;
	}

	public String getName(){
		return this.name;
	}

	public int getBalance(){
		return this.balance;
	}

	public void setID(int identifier){
		this.identifier = identifier;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setBalance(int balance){
		if(balance < 0){
			System.out.println("User balance cannot be negative");
			this.balance = 0;
		}
		else{
			this.balance = balance;
		}
	}

	public String printUser(){
		return ("Name: " + this.name + "\nIdentifier: " + this.identifier + "\nBalance: " + this.balance);
	}
  }
