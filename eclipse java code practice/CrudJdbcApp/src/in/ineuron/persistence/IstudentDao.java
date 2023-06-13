package in.ineuron.persistence;

public interface IstudentDao {
	
	//operation to be implemented 
	
	public String addStudent(String sname, Integer sage, String saddress);
	
	public Student selectdata(Integer sid);

}
