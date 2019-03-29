<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%!
    PreparedStatement ps1, ps2;
    Connection con=null;
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String password="root";

    public void jspInit()
    {
        try 
        {
            //loading the driver
				Class.forName("com.mysql.jdbc.Driver");
            //establish the connection
            con = DriverManager.getConnection(url, username, password);
            //create statement object
            ps1 = con.prepareStatement("select count(*) from users where Email = ? and password= ?");
            ps2 = con.prepareStatement("select  * from users");
            
            System.out.println("Hello");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
%>
<%
    String param = request.getParameter("s1");
    if(param =="link")
    {
        ResultSet rs = ps2.executeQuery();
        out.println("<table>");
        while(rs.next())
        {
            out.println("<tr>");
            out.println("<td>"+rs.getString(1)+"</td>");
            out.println("<td>"+rs.getString(2)+"</td");
            out.println("</tr>");
            System.out.println("Hello1");

        }
        out.println("</table>");
        rs.close();
    }
    else
    {
        
        String user = request.getParameter("Email");
        String pass = request.getParameter("password");
       
        ps1.setString(1,user);
        ps1.setString(2,pass);
      
        ResultSet rs = ps1.executeQuery();
        int cnt = 0;
        if (rs.next())
            cnt = rs.getInt(1);
        if(cnt == 0)
            out.println("<b><i><font color=red>Invalid credential</fonr></i></b>");
        else
        {
            out.println("<form><fieldset style= width:25%; >");
            out.println("<b><i><font color=red>valid credential..</fonr></i></b><br>");
            out.println("<b><i><font size=6 color=blue>Welcome to My Page</fonr></i></b>");
            out.println("</fieldset></form>");
        }
    }
%>
<%! 
    public void jspDestroy()
    {
        try 
        {
            
            ps1.close();
            ps2.close();
            con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
%>