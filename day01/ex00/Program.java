
public class Program {
	public static void main(String[] args){
		User sender = new User("Alessio",10);
		sender.setID(10);
		User recipient = new User("Buonomo",-5);
		recipient.setID(42);
		System.out.println("Sender Data: \nName: " + sender.getName() + "\nIdentifier:" + sender.getID() +"\nBalance: " + sender.getBalance() + "\n");
		System.out.println("Recipient Data: \nName: " + recipient.getName() + "\nIdentifier:" + recipient.getID() + "\nBalance: " + recipient.getBalance());
		System.out.println("Debit -> -5");
		Transaction tu = new Transaction(sender,recipient,Transaction.TransferCategory.DEBIT, -5);
		System.out.println("Debit -> 5");
		Transaction tu2 = new Transaction(sender,recipient,Transaction.TransferCategory.DEBIT, 5);
		System.out.println("Credit -> -5");
		Transaction tu3 = new Transaction(sender,recipient,Transaction.TransferCategory.CREDIT, -5);
		System.out.println("Debit -> 5");
		Transaction tu4 = new Transaction(sender,recipient,Transaction.TransferCategory.CREDIT, 5);
		System.out.println("\n");
		System.out.println("Sender Data: \nName: " + sender.getName() + "\nIdentifier:" + sender.getID() +"\nBalance: " + sender.getBalance() + "\n");
		System.out.println("Recipient Data: \nName: " + recipient.getName() + "\nIdentifier:" + recipient.getID() + "\nBalance: " + recipient.getBalance());
	}
}
