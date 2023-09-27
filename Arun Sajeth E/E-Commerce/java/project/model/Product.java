package project.model;

public class Product {
	
	int pid;
	String pName;
	String pDesp;
	double pPrice;
	int pQty;
	
	public Product()
	{
		
	}

	public Product(int pid, String pName, String pDesp, double pPrice, int pQty) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pDesp = pDesp;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDesp() {
		return pDesp;
	}

	public void setpDesp(String pDesp) {
		this.pDesp = pDesp;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", pDesp=" + pDesp + ", pPrice=" + pPrice + ", pQty=" + pQty
				+ "]";
	}

}
