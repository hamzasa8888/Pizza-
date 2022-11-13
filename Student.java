package application;

public class Student 
{
	String FirstName = "";
	String LastName = "";
	String ASURITEID = "";
	String email = "";
	
    /*public Student(String firstName, String lastName, String ASURITEid, String email) 
    {
    	this.FirstName = firstName;
    	this.LastName = lastName;
	    this.email = email;
	    this.ASURITEID = ASURITEid;
	}
	   */
    public boolean CheckStudent(String ASURITEid) throws Exception
    {
		if(ASURITEid.equals("jerin24"))
		{
			this.FirstName = "Jerin";
			this.LastName = "Joseph";
			this.ASURITEID = "jerin24";
			this.email = "jerin24@asu.edu";
			return true;
		}
		else if(ASURITEid.equals("hamza24"))
		{
			this.FirstName = "Jerin";
			this.LastName = "Joseph";
			this.ASURITEID = "jerin24";
			this.email = "jerin24@asu.edu";
			return true;
		}
		else if(ASURITEid.equals("salmon24"))
		{
			this.FirstName = "Salmon";
			this.LastName = "Rahman";
			this.ASURITEID = "salmon24";
			this.email = "salmon24@asu.edu";
			return true;
		}
		else if(ASURITEid.equals("jose24"))
		{
			this.FirstName = "Jose";
			this.LastName = "Galvan";
			this.ASURITEID = "jose24";
			this.email = "jose24@asu.edu";
			return true;
		}
		else if(ASURITEid.equals("jacob24"))
		{
			this.FirstName = "Jacob";
			this.LastName = "Fait";
			this.ASURITEID = "jacob24";
			this.email = "jacob24@asu.edu";
			return true;
		}
		else
		{
			return false;
		} 	
    }
	public String getStudentName() {
		String studentName = this.FirstName + " " + this.LastName;
	    return studentName;
	}

	public String getASURITEID() {
	        return ASURITEID;
	}
	
	public String getEmail() {
        return email;
}


}
