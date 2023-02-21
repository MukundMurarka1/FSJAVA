<%@ page language="java"  import='java.sql.*'%>

<%!
	Connection connection  = null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	PreparedStatement  pstmt3 = null;
	PreparedStatement pstmt4 = null;
	Statement  stmt = null;
	
	public void jspInit(){
		System.out.println("Bootstraping the logic....");
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("jdbcUrl");
		String username = config.getInitParameter("user");
		String userpassword = config.getInitParameter("password");
		
		String insertquery = "insert into studentdetails(first_name, last_name, roll_no, address, mobile_no) values(?,?,?,?,?)";
		String selectquery = "select * from studentdetails";
		String updateQuery = "UPDATE studentdetails set address = ? where roll_no= ? ";
		String deleteQuery =  "DELETE from studentdetails where roll_no= ? ";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully.........");
			connection = DriverManager.getConnection(url,username,userpassword);
			
			pstmt1 = connection.prepareStatement(insertquery);
			pstmt2 = connection.prepareStatement(selectquery);
			pstmt3 = connection.prepareStatement(updateQuery);
			pstmt4 = connection.prepareStatement(deleteQuery);
			
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();	
		}
		catch(SQLException e ){
			e.printStackTrace();
		}
	}
%>

<%
	//insert the record 
	
	String action = request.getParameter("s1");
	if(action.equalsIgnoreCase("register")){
		String sfname = request.getParameter("sfname");
		String slname  =request.getParameter("slname");
		String srollno = request.getParameter("srollno");
		String saddr = request.getParameter("saddr");
		String smobileno = request.getParameter("smobileno");
		
		pstmt1.setString(1, sfname);
		pstmt1.setString(2, slname);
		pstmt1.setString(3, srollno);
		pstmt1.setString(4, saddr);
		pstmt1.setString(5, smobileno);
		
		int rowcount = pstmt1.executeUpdate();
		
		if(rowcount == 1)	
		{
%>

	<h1 style='color: green; text-align: center;'>Student registered Successfully</h1>

<%
		}
		else
		{

%>	
	<h1 style='color: green; text-align: center;'>Student not registered</h1>		
<%
		}
%>



<%} 
	//Update the record 
	else if(action.equalsIgnoreCase("Update")){
		String srollno = request.getParameter("srollno");
		String saddr = request.getParameter("saddr");
		
		//through Statement object 
		//String updateQuery = "UPDATE studentdetails set address = '"+saddr+"' where roll_no= '"+srollno+"'";
		//stmt = connection.createStatement();
		//System.out.println(updateQuery);
		
	
		pstmt3.setString(1, saddr);
		pstmt3.setString(2, srollno);

		
		int rowcount1 = pstmt3.executeUpdate();
		
		if(rowcount1 == 1){
%>
	<h1 style='color: green; text-align: center;'>Student detail updated successfully </h1>
<% 			
		}else{
%>
	<h1 style='color: green; text-align: center;'>Student detail not updated successfully </h1>
<%		}
		
	}
	// Delete the record 
	else if(action.equalsIgnoreCase("Delete")){
		String sdelroll = request.getParameter("srollno");
		if(sdelroll.isEmpty()){
%>
	<h1 style='color: green; text-align: center;'>enter valid rollno </h1> 
	
<% 
		}
		else{		
		
		pstmt4.setString(1, sdelroll);
		
		int delrow = pstmt4.executeUpdate();
		
		if(delrow == 1){
%>
	<h1 style='color: green; text-align: center;'>Student detail deleted Successfully </h1> 

<%  
		}
		else{
%>
	<h1 style='color: green; text-align: center;'>Student detail not deleted  </h1>
	
<%
		}
	}
	}
	
	
	//Select the record 
	
	else
	{
		ResultSet result = pstmt2.executeQuery();	
%>
 <table bgcolor='pink' align="center" border="1">
  <tr>
    <th>Student first name</th>
    <th>Student last name</th>
    <td>Student roll no</td>
    <td>Student Address</td>
    <td>Student Mobile no</td>
  </tr>
<%
	while(result.next()){
%>		
	<tr>
		<td><%=result.getString(1) %></td>
		<td><%=result.getString(2) %></td>
		<td><%=result.getString(3) %></td>
		<td><%=result.getString(4) %></td>
		<td><%=result.getString(5) %></td>
	</tr>
<%
	}
%>

 
</table>
<%
	}
%>
 
 </br>
 </br>
 
 <h1 style='text-align:center;'><a href='./index.html'>|HOMEPAGE|</a></h1>
 
 
 <%!public void jspDestroy(){
	 System.out.println("Close the program.........");
	 try{
	 if(pstmt1 != null){
		 pstmt1.close();
		 
	 }}catch(SQLException se){
		 se.printStackTrace();
		 
	 }
	 try{
	 if(pstmt2 != null){
		 pstmt2.close();
	 }
	 }catch(SQLException se){
		 se.printStackTrace();
		 
	 }
	 try{
		 if(pstmt3 != null){
			 pstmt3.close();
		 }
		 }catch(SQLException se){
			 se.printStackTrace();
			 
		 }
	 try{
		 if(pstmt4 != null){
			 pstmt4.close();
		 }
		 }catch(SQLException se){
			 se.printStackTrace();
			 
		 }
	 try{
		 if(connection != null){
			 connection.close();
		 }
	 }catch(SQLException ce){
		 ce.printStackTrace();
		 
	 }
 } %>
 
 
 
 
 
 
 