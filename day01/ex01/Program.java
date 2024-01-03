
public class Program {
	public static void main(String[] args){
		User user1 = new User("Alessio",10);
		User user2 = new User("Ciro",50);
		User user3 = new User("Gennaro",42);
		System.out.println("Name: " + user1.getName() + "\nIdentifier:" + user1.getID() +"\nBalance: " + user1.getBalance() + "\n");
		System.out.println("\nName: " + user2.getName() + "\nIdentifier:" + user2.getID() + "\nBalance: " + user2.getBalance());
		System.out.println("\nName: " + user3.getName() + "\nIdentifier:" + user3.getID() + "\nBalance: " + user3.getBalance());
	}
}
