package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class readfile {
	public static boolean code(File file) throws IOException {
		  InputStream ios=new FileInputStream(file);  
		  byte[] b=new byte[3]; 
		  ios.read(b);  
		  ios.close(); 
		  if(b[0]==-17&&b[1]==-69&&b[2]==-65) {
			  return true;
		  }
		  return false;
	}
	public static Map<String,Integer> readFile(String filePath){
		Map<String,Integer> map = new TreeMap<String,Integer>();
        try {
                File file=new File(filePath);
                if(!file.canRead()) {
                	System.out.println("文件无读权限");
                }else if(code(file)){
                	System.out.println("文件编码错误");
                }else if(file.isFile() && file.exists()){ 
                
                	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    String line = "";
                    while((line = br.readLine())!=null){
                        String[] wordline = line.split("\\s+");
                        for(String word:wordline){
                            if(map.containsKey(word)){ 
                                int n =1 + map.get(word);
                				map.remove(word);
                				map.put(word, (Integer)n);
                            }else{
                                map.put(word, 1);
                            }    
                        }
                    }
               
                    br.close();
                }else{
                    System.out.println("没有指定的文件");
                }
        } catch (Exception e) {
            System.out.println("无法读取文件");
            e.printStackTrace();
        }
		return map;
    }
	public static List<Map.Entry<String,Integer>> sort(Map<String,Integer> map) {
		List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        return list;
	}
	public static void write(List<Map.Entry<String,Integer>> list) throws IOException {
		try {
			File file = new File("D:" + File.separator +  "output.txt");
			Writer wrt = new FileWriter(file);
			for(Entry<String, Integer> mapping:list){ 
				String str = mapping.getKey()+"  "+mapping.getValue()+"\n";
				char[] c = str.toCharArray();
				wrt.write(c);
				
	            System.out.println(); 
	        } 
			wrt.flush();
			wrt.close();
		}catch (Exception e) {
            System.out.println("输出文件出错");
            e.printStackTrace();
        }
		
		
		
	}
    public static void main(String argv[]) throws IOException{
    	Map<String,Integer> map = new TreeMap<String,Integer>();
    	map = readFile("D:/Download/了不起的盖茨比英文.txt");
    	List<Map.Entry<String,Integer>> list = sort(map);
        write(list);
    }
}
