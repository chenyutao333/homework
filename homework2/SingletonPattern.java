

public class SingletonPattern {
	 private SingletonPattern(){}  //隐藏构造函数
	 private static SingletonPattern Singleton = null;//创造私有实例保证不会被其它使用  
	 public static SingletonPattern getInstance() {  
    	if (Singleton == null) {  
    		Singleton = new SingletonPattern();//无实例时才被创建
	        System.out.print("create one");
	    }  
	    return Singleton;  
	 }
	 
}
