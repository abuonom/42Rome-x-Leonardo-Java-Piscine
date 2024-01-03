import java.util.UUID;

interface TransactionsList {
	public void addTransaction(Transaction trs);
	public void rmTransactionID (UUID id);
	public Transaction[] intoArray ();
}
