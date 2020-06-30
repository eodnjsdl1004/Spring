package ex03.setter;


public class MemberDAO {

	private DatabaseDev datasource;

	//getter
	public DatabaseDev getDatasource() {
		return datasource;
	}
	
	//setter
	public void setDatasource(DatabaseDev datasource) {
		this.datasource = datasource;
	}
	
	public void info() {
		System.out.println("DB주소:"+ datasource.getUrl());
		System.out.println("DB아이디:"+ datasource.getUid());
		System.out.println("DB비밀번호:"+ datasource.getUpw());
	}
	
}
