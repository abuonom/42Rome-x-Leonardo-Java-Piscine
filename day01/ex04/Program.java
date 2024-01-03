class	Program {
	static public void	main(String args[]) {
		TransactionsService	ts = new TransactionsService();
		Transaction			trs[];
		User				giovanni = new User("Giovanni", 1000);
		User				marco = new User("Marco", 2000);
		User				adistef = new User("Adistef", 3000);
		User				afraccal = new User("Afraccal", 4000);

		ts.addUser(giovanni);
		ts.addUser(marco);
		ts.addUser(adistef);
		ts.addUser(afraccal);
		System.out.println("Before: ");
		System.out.println("Marco's balance: " + ts.retriveBalance(marco.getID()));
		System.out.println("Giovanni's balance: " + ts.retriveBalance(giovanni.getID()));
		System.out.println("Adistef's balance: " + ts.retriveBalance(adistef.getID()));
		System.out.println("Afraccal's balance: " + ts.retriveBalance(afraccal.getID()));
		ts.transferTransaction(marco.getID(), giovanni.getID(), 1000);
		ts.transferTransaction(adistef.getID(), afraccal.getID(), 1000);
		ts.transferTransaction(afraccal.getID(), marco.getID(), 2000);
		System.out.println("------------------------------------------------");
		System.out.println("After: ");
		System.out.println("Marco's balance: " + ts.retriveBalance(marco.getID()));
		System.out.println("Giovanni's balance: " + ts.retriveBalance(giovanni.getID()));
		System.out.println("Adistef's balance: " + ts.retriveBalance(adistef.getID()));
		System.out.println("Afraccal's balance: " + ts.retriveBalance(afraccal.getID()));
		System.out.println("------------------------------------------------");
		trs = ts.retriveByUser(marco.getID());
		System.out.println("Marco's transactions: ");
		for (Transaction tr : trs) {
			System.out.println(tr);
		}
		System.out.println("------------------------------------------------");
		System.out.println("check validity: ");
		trs = ts.retriveValidity();
		if (trs == null) {
			System.out.println("Nothing to report");
		} else {
			for (Transaction tr : trs) {
				System.out.println(tr);
			}
		}
		System.out.println("------------------------------------------------");
		trs = ts.retriveByUser(marco.getID());
		ts.removeUserTransaction(marco.getID(), trs[1].getIdentifier());
		trs = ts.retriveByUser(marco.getID());
		System.out.println("Marco's transactions after remove: ");
		for (Transaction tr : trs) {
			System.out.println(tr);
		}
		System.out.println("------------------------------------------------");
		System.out.println("check validity: ");
		trs = ts.retriveValidity();
		for (Transaction tr : trs) {
			System.out.println(tr);
		}
		System.out.println("------------------------------------------------");
	}
}
