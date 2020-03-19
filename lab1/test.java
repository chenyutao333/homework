
public class test {
	public static void main(String[] args) {
		System.out.println("计算机商品一览表");
		component com1 = new component("CPU1","Intel","4",1500);
		component com2 = new component("CPU2","AMD","4",1300);
		component com3 = new component("内存1","Samsung","8G",400);
		component com4 = new component("内存2","Kingston","6G",300);
		component com5 = new component("硬盘1","Seagate","500G",1000);
		component com6 = new component("硬盘2","WestDigitals","1T",2100);
		component com7 = new component("主板1","Asus","4.8G",200);
		component com8 = new component("主板2","Gigabyte","5.1G",300);		
		ComputerStore c1 = new ComputerStore("c1",com1.getPrice()+com4.getPrice()+com5.getPrice()+com8.getPrice(),
				                            com1.getName()+com4.getName()+com5.getName()+com8.getName()+" work");

		ComputerStore c2 = new ComputerStore("c2",com2.getPrice()+com3.getPrice()+com6.getPrice()+com7.getPrice(),
				com2.getName()+com3.getName()+com6.getName()+com7.getName()+" work");
		
		ComputerStore c3 = new ComputerStore("c3",com1.getPrice()+com3.getPrice()+com6.getPrice()+com8.getPrice(),
				com1.getName()+com3.getName()+com6.getName()+com8.getName()+" work");

		c1.show(c1,com1,com4,com5,com8);
		c2.show(c2,com2,com3,com6,com7);
		c3.show(c3, com1, com3, com6, com8);

    }

}
