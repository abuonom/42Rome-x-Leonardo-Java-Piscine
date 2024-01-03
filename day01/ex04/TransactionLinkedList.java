import java.util.UUID;

public class TransactionLinkedList implements TransactionList{
	private int size;
	private Transaction head;

	public TransactionLinkedList(){
		this.head = null;
		this.size = 0;
	}
	public int getSize() {
		return this.size;
	}

	public void addTransaction(Transaction trans) {
		if(this.head != null){
			trans.setNext(this.head);
		}
		this.head = trans;
		this.size++;
	}

	public void rmTransactionID (UUID id) {
		Transaction tmp = this.head;
		if(id == tmp.getIdentifier()){
			this.head = tmp.getNext();
			this.size--;
			return;
		}
		for(int i = 0; i < size ; i++) {
			if(id == tmp.getNext().getIdentifier()) {
				tmp.setNext(tmp.getNext().getNext());
				this.size--;
				return;
			}
			tmp = tmp.getNext();
		}
		throw new TransactionNotFoundException("Transaction with id " + id +" not found");
	}

	public Transaction[] intoArray () {
		Transaction [] array = new Transaction[this.size];
		Transaction temp = this.head;
		for(int i = 0; i < this.size; i++){
			array[i] = temp;
			temp = temp.getNext();
		}
		return array;
	}

	public Transaction	findTransaction(UUID id) {
		Transaction	tmp;

		tmp = this.head;
		while (tmp != null) {
			if (tmp.getIdentifier() == id) {
				return tmp;
			}
			tmp = tmp.getNext();
		}
		return null;
	}
}
