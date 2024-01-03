
public class Program {
	public static void main(String[] args){
		UsersArrayList list = new UsersArrayList();
		User alessio = new User("Alessio",1);
		User bugo = new User("Bugo",2);
		User carlo = new User("Carlo",3);
		User damiano = new User("Damiano",4);
		User emanuele = new User("Emanuele",5);
		User flaviano = new User("Flaviano",6);
		User giorgio = new User("Giorgio",7);
		User heisenberg = new User("Heisenberg",8);
		User iodato = new User("Iodato",9);
		User luca = new User("Luca",10);
		User mario = new User("Mario",11);
		list.addUser(alessio);
		list.addUser(bugo);
		list.addUser(carlo);
		list.addUser(damiano);
		list.addUser(emanuele);
		list.addUser(flaviano);
		list.addUser(giorgio);
		list.addUser(heisenberg);
		list.addUser(iodato);
		list.addUser(luca);
		list.print();
		list.addUser(mario);
		list.print();
		System.out.println("Retrive by ID (7)--> ");
		list.retriveByID(7).printUser();
		System.out.println("Retrive by index (5)--> ");
		list.retriveByIndex(5).printUser();
		System.out.println("Retrive number of Users--> " + list.numberUser());
	}
}
