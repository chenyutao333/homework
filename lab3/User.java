package lab3;

@Table(value="user")
public class User {
	
	@Column(value="编号") 
	private int id = -1;

	@Column(value="用户姓名")
    private String username = null;
	

    @Column(value="电话号码")
    private String telephone = null;
    @Column(value="邮件")
    private String email = null;
    
	@Column(value="年龄")
	private int age = -1;


	public void setId(int i) {
		// TODO Auto-generated method stub
		id = i;	
    }

	public void setUsername(String name) {
		// TODO Auto-generated method stub
		username = name;
	}

	public void setTelephone(String number) {
		// TODO Auto-generated method stub
		telephone = number;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

}
