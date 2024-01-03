import java.util.UUID;

public class TransactionsService {
	private UsersList users;

	public TransactionsService(){
		this.users = new UsersArrayList();
	}
	public void addUser(User user){
		this.users.addUser(user);
	}

	public int retriveBalance(int id){
		return this.users.retriveByID(id).getBalance();
	}

	public void transferTransaction(int senderID, int recipientID,int amount){
		User sender;
		User recipient;
		Transaction trs;
		if(amount < 0){
			throw new TransactionErrorException("Invalid amount for this transaction;");
		}
		sender = users.retriveByID(senderID);
		recipient = users.retriveByID(recipientID);
		trs = new Transaction(sender, recipient, Transaction.TransferCategory.DEBIT, -amount);
		sender.getTransaction().addTransaction(trs);
		trs = new Transaction(trs);
		trs.setTc(Transaction.TransferCategory.CREDIT);
		recipient.getTransaction().addTransaction(trs);
		sender.setBalance(sender.getBalance() - amount);
		recipient.setBalance(sender.getBalance() + amount);
	}

	public Transaction[] retriveValidity(){
		Transaction [] array;
		TransactionList	tmp;

		tmp = new TransactionLinkedList();
		for (int i = 0; i < this.users.numberUser(); i++) {
			array = this.users.retriveByIndex(i).getTransaction().intoArray();
			for (int x = 0; x < array.length; x++) {
				if (array[x].getRecipient().getTransaction().findTransaction(array[x].getIdentifier()) == null) {
					tmp.addTransaction(array[x]);
				}
				if (array[x].getSender().getTransaction().findTransaction(array[x].getIdentifier()) == null) {
					tmp.addTransaction(array[x]);
				}
			}
		}
		return (tmp.intoArray());
	}

	public void	removeUserTransaction(int userID, UUID transactionID) {
		User	user;

		user = this.users.retriveByID(userID);
		user.getTransaction().rmTransactionID(transactionID);
	}

	public Transaction[] retriveByUser(int id){
		User user;
		user = this.users.retriveByID(id);
		return user.getTransaction().intoArray();
	}
}
