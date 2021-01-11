package put.io.testing.mocks;

public class Expense {
	private String title;
	private String category;
	private long amount;

	public Expense(){};

	public Expense(String t, String c, long a){
		this.title = t;
		this.category = c;
		this.amount = a;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public long getAmount() {
		return amount;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
}
