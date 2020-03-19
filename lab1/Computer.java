
abstract public class Computer {
	private String name;
	private double totalPrice;
	private String work;
	abstract public String getName();
	abstract public void describe(component c1);
	abstract public double totalPrice();
	abstract public String getWork(); 
    abstract void show(ComputerStore computerStore,component component1,component component2,component component3,component component4);
}
