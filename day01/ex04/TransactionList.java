import java.util.UUID;

interface TransactionList {
	public void addTransaction(Transaction trs);
	public void rmTransactionID (UUID id);
	public Transaction[] intoArray ();
	public Transaction	findTransaction(UUID id);
}
