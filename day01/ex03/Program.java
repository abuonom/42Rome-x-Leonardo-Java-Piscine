public class Program {
	public static void main(String[] args)
	{
		int i;
		User alessio = new User("Alessio",1000);
		User bugo = new User("Bugo",2000);
		Transaction tr1 = new Transaction(alessio, bugo, Transaction.TransferCategory.CREDIT, 1);
		Transaction tr2 = new Transaction(bugo, alessio, Transaction.TransferCategory.DEBIT, 2);
		Transaction tr3 = new Transaction(alessio, bugo, Transaction.TransferCategory.DEBIT, -3);
		Transaction tr4 = new Transaction(alessio, bugo, Transaction.TransferCategory.CREDIT, 4);
		Transaction tr5 = new Transaction(bugo, alessio, Transaction.TransferCategory.DEBIT, -5);
		Transaction tr6 = new Transaction(bugo, alessio, Transaction.TransferCategory.CREDIT, 6);
		Transaction tr7 = new Transaction(alessio, bugo, Transaction.TransferCategory.DEBIT, -7);
		UsersArrayList list = new UsersArrayList();
		list.addUser(alessio);
		list.addUser(bugo);
		list.print();
		TransactionsList trs = list.retriveByID(1).getTransaction();
		System.out.println("Created Transaction: ");
		tr1.printTrans();
		tr2.printTrans();
		tr3.printTrans();
		tr4.printTrans();
		tr5.printTrans();
		tr6.printTrans();
		tr7.printTrans();
		System.out.println("Now we use the list: ");
		trs.addTransaction(tr1);
		trs.addTransaction(tr3);
		trs.addTransaction(tr4);
		trs.addTransaction(tr7);
		trs = list.retriveByID(2).getTransaction();
		trs.addTransaction(tr2);
		trs.addTransaction(tr5);
		trs.addTransaction(tr6);
		System.out.println("--------------------------------");
		System.out.println("ALESSIO TRANSACTIONS");
		System.out.println("--------------------------------");
		Transaction [] array = list.retriveByID(1).getTransaction().intoArray();
		for(i = 0; i < array.length ; i++){
			System.out.println(array[i]);
		}
		list.retriveByID(1).getTransaction().rmTransactionID(array[array.length - 1].getIdentifier());
		i = 0;
		System.out.println("--------------------------------");
		System.out.println("ALESSIO AFTER REMOVE TRANSACTION ");
		System.out.println("--------------------------------");
		for(i = 0; i < array.length ; i++){
			System.out.println(array[i]);
		}
	}
}
