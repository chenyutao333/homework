package lab3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lab3.User;
public class SqlUtil implements util{
	/**
     * 根据传入的参数返回查询语句
     * @param user
	 * @return 
     * @return 返回查询语句
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
     */
    public String query(User user){
    	
    	Class c = user.getClass();
    	Field[] fields = c.getDeclaredFields();
    	//获得user类全部属性
    	for (Field field : fields) {
			field.setAccessible(true);
			//设置允许访问
			try {
				if(field.getType().getCanonicalName()=="int"&&field.getInt(user)!=-1) {
					return "SELECT * FROM 'user' WHERE '" + field.getName() + "' = " + field.get(user);
				}else if(field.getType().getCanonicalName()=="java.lang.String"&&field.get(user)!=null){
					return "SELECT * FROM 'user' WHERE '" + field.getName() + "' LIKE '" + field.get(user)+"'";
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return null;
    }
    /**
     * 根据传入的参数返回插入语句
     * @param user
     * @return 返回插入语句
     * @throws Exception 
     * @throws IllegalArgumentException 
     */
    public String insert(User user) {
    	Class c = user.getClass();
    	Field[] fields = c.getDeclaredFields();
    	
    	//获得user类全部属性
    	String[] value = new String[5];
    	//存储被插入属性对应的值
    	String[] name = {"id","username","telephone","email","age"};
    	fields[1].setAccessible(true);
    	String result = new String();
		try {
			result = "INSERT INTO `user' (";
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//存储属性名
    	int cnt = 0;
    	//用于标记某属性是否被改变
    	int last = -1;
    	//记录最后一个被插入的属性
    	for (Field field : fields) {
    	//记录属性是否被插入并记录值
			field.setAccessible(true);
			//设置允许访问
			try {
				if(field.getType().getCanonicalName()=="int"&&field.getInt(user)!=-1) {
					value[cnt] = field.get(user).toString();
					last = cnt;
					
				}else if(field.getType().getCanonicalName()=="java.lang.String"&&field.get(user)!=null){
					value[cnt] = "'"+field.get(user).toString()+"'";
					last = cnt;
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cnt++;
			
		}
    	for(int i=0;i<5;i++) {
    		if(value[i]!=null&&i<last) {
    			result += "'"+name[i]+"', ";
    		}else if(value[i] != null && i == last) {
    			result += "'"+name[i]+"') VALUES (";
    		}
    	}
    	for(int i=0;i<5;i++) {
    		
    		if(value[i]!=null&&i<last) {
    			result += value[i]+", ";
    		}else if(value[i] != null && i == last) {
    			result += value[i]+")";
    		}
    	}
		return result;
    	
    }

//    /**
//     * 根据传入的参数返回插入语句
//     * @param users
//     * @return 返回插入语句
//     */
    public String insert(List<User> users) {
    	String result = "INSERT INTO `user' ('username', 'telephone', 'email', 'age') VALUES ";
    	
    	for(int i=0;i<users.size();i++) {
    		//
    		Class c = users.get(i).getClass();
    		Field[] fields = c.getDeclaredFields();
    		//获得user类全部属性
    		String[] value = new String[5];
        	//存储被插入属性对应的值
        	for (int j=0;j<fields.length;j++) {
        	//记录属性是否被插入并记录值
    			fields[j].setAccessible(true);
    			
    			//设置允许访问
    			try {
					if(fields[j].getType().getCanonicalName()=="int"&&fields[j].getInt(users.get(1))!=-1) {
						value[j] = fields[j].get(users.get(i)).toString();
						
					}else if(fields[j].getType().getCanonicalName()=="java.lang.String"&&fields[j].get(users.get(1))!=null){
 
						value[j] = "'"+(String)fields[j].get(users.get(i))+"'";
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    		}
        	result += "(";
        	for(int k=1;k<value.length;k++) {
        		if(value[k]!=null&&k<fields.length-1) {
           			result += value[k]+", ";
           		}else if(value[k] != null && k == fields.length-1) {
           			result += value[k]+")";
           		}
       		}
       		if(i<users.size()-1) {
       			result += ", ";
       		}
        	
    	}
    	return result;
    }
//
//    /**
//     * 根据传入的参数返回删除语句（删除id为user.id的记录）
//     * @param user
//     * @return 返回删除语句
//     */
    public String delete(User user) {
    	Class c = user.getClass();
    	Object o = User.class;
    	String[] name = {"setId","setUsername","setTelephone","setEmail","setAge"};
    	Field[] fields = c.getDeclaredFields();
    	//获得user类全部属性
    	for (int i=0;i<fields.length;i++) {
    	//记录属性是否被插入并记录值
			fields[i].setAccessible(true);
			//设置允许访问
			if(fields[i].getType().getCanonicalName()=="int") {
				try {
					if(fields[i].getInt(user)!=-1) {
						return "DELETE FROM `user` WHERE '"+fields[i].getName()+"' = "+fields[i].getInt(user);
					}
						Method m = c.getMethod(name[i], new Class[]{int.class});
						try {
							Object result = m.invoke(User.class.newInstance(), new Object[]{0});
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if(fields[i].getType().getCanonicalName()=="java.lang.String"){
				try {
					if(fields[i].getInt(user)!=-1) {
						return "DELETE FROM `user` WHERE '"+fields[i].getName()+"' = '"+fields[i].getInt(user)+"'";
					}
					Method m = c.getMethod(name[i], new Class[]{String.class});
					try {
						Object result = m.invoke(User.class.newInstance(), new Object[]{null});
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	
		return null;
    	
    }
///**
//     * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
//     * @param user
//     * @return 返回更新语句
//     */
    public String update(User user){
    	String result = "UPDATE `user` SET `";
    	Class c = user.getClass();
    	Object o = User.class;
    	String[] name = {"setId","setUsername","setTelephone","setEmail","setAge"};
    	Field[] fields = c.getDeclaredFields();
    	//获得user类全部属性
    	for (int i=1;i<fields.length;i++) {
    	//记录属性是否被插入并记录值
			fields[i].setAccessible(true);
			//设置允许访问
			if(fields[i].getType().getCanonicalName()=="int") {
				try {
					if(fields[i].getInt(user)!=-1) {
						Method m = c.getMethod(name[i], new Class[]{int.class});
						try {
							Object update = m.invoke(User.class.newInstance(), new Object[]{fields[i].getInt(user)});
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						result += fields[i].getName()+"' = '"+fields[i].get(user)+"' ";
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(fields[i].getType().getCanonicalName()=="java.lang.String"){
				try {
					if(fields[i].get(user) != null) {
						Method m = c.getMethod(name[i], new Class[]{String.class});
						try {
							try {
								Object update = m.invoke(User.class.newInstance(), new Object[]{fields[i].get(user)});
							} catch (InstantiationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						result += fields[i].getName()+"' = '"+fields[i].get(user)+"' ";
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	fields[0].setAccessible(true);
    	try {
			result += "WHERE `id` = " + fields[0].getInt(user);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
    }
}
