import java.util.UUID;

public class Transaction {
	static enum	TransferCategory {
		DEBIT,
		CREDIT
	}
	private UUID identifier;
	private User recipient;
	private User sender;
	private TransferCategory tc;
	private int amount;

	public Transaction(User sender, User recipient, TransferCategory tc, int amount){
		this.identifier = UUID.randomUUID();
		this.recipient = recipient;
		this.sender = sender;
		this.tc = tc;
		if((tc == TransferCategory.DEBIT && amount > 0) || (tc == TransferCategory.CREDIT && amount < 0)){
			System.out.println("Invalid amount for this transaction; The transfer amount is setted to 0");
			this.amount = 0;
		}else if(sender.getBalance() < amount) {
			System.out.println("Your balance is not enough to make this transaction; The transfer amount is setted to 0");
			this.amount = 0;
		}else{
			this.amount = amount;
		}
	}

	public UUID getIdentifier(){
		return this.identifier;
	}
	public TransferCategory getTc(){
		return this.tc;
	}
	public int getAmount(){
		return this.amount;
	}

	public User getRecipient(){
		return this.recipient;
	}

	public User getSender(){
		return this.sender;
	}
}
