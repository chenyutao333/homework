

public class SingletonPattern {
	 private SingletonPattern(){}  //���ع��캯��
	 private static SingletonPattern Singleton = null;//����˽��ʵ����֤���ᱻ����ʹ��  
	 public static SingletonPattern getInstance() {  
    	if (Singleton == null) {  
    		Singleton = new SingletonPattern();//��ʵ��ʱ�ű�����
	        System.out.print("create one");
	    }  
	    return Singleton;  
	 }
	 
}
