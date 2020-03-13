
public class ComputerStore extends Computer {
	private String name = null;
	private double totalPrice = 0;
	private String work = null;

	public ComputerStore(String name,double totalPrice,String work) {
		this.name = name;
		this.totalPrice = totalPrice;
		this.work = work;
	}
	public String getName() {
		return name;
	}

	public void describe(component c1) {
		// TODO Auto-generated method stub
		if(c1.getBrand().equals("Intel")||c1.getBrand().equals("AMD")) {
			System.out.println("CPU: "+c1.getName()+", brand�� "+c1.getBrand()+", "+c1.getCPUAttribute()+", price�� "+c1.getPrice());
    	}else if(c1.getBrand().equals("Samsung")||c1.getBrand().equals("Kingston")) {
    		System.out.println("�ڴ�: "+c1.getName()+", brand�� "+c1.getBrand()+", "+c1.getRAMAttribute()+", price�� "+c1.getPrice());
    	}else if(c1.getBrand().equals("Seagate")||c1.getBrand().equals("WestDigitals")){
    		System.out.println("Ӳ��: "+c1.getName()+", brand�� "+c1.getBrand()+", "+c1.gethardDiskAttribute()+", price�� "+c1.getPrice());
    	}else {
    		System.out.println("����: "+c1.getName()+", brand�� "+c1.getBrand()+", "+c1.getmainBoardAttribute()+", price�� "+c1.getPrice());
    	}
    	
		
	}

	public double totalPrice() {
		// TODO Auto-generated method stub
		return totalPrice;
	}
	public String getWork() {
		// TODO Auto-generated method stub
		return work;
	}
	
    public void show(ComputerStore computerStore,component component1,component component2,component component3,component component4) {
    	System.out.println("��������ƣ� "+computerStore.getName());
		System.out.println("����: ");
		computerStore.describe(component1);
		computerStore.describe(component2);
		computerStore.describe(component3);
		computerStore.describe(component4);
		System.out.println("����: "+computerStore.getWork());
		System.out.println("������۸� "+computerStore.totalPrice());
    }

}

