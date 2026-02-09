package com.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.book.bean.AuthorBean;
import com.kce.book.util.DBUtil;


public class AuthorDAO {
public AuthorBean getAuthor(int authorCode) {
	 Connection connection= DBUtil.getDBConnection();
	   String query="select * from Author_Tbl WHERE Author_code=?";
	   try {
		   PreparedStatement ps=connection.prepareStatement(query);
    	   ps.setInt(1,authorCode);
    	   ResultSet rs=ps.executeQuery();
    	   if(rs.next()) {
    		   AuthorBean authorBean=new AuthorBean();
    		   authorBean.setAuthorCode(rs.getInt(1));
    		   authorBean.setAuthorName(rs.getString(2));
    		   authorBean.setContactNo(rs.getLong(3));
    		   return authorBean;
    	   }
    	   else {
    		   return null;
    	   }}
	   catch(SQLException e) {
		   e.printStackTrace();
		   return null;
	   }
	   }
public AuthorBean getAuthor(String authorName) {

    AuthorBean author = null;

    try {
        Connection con = DBUtil.getDBConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT * FROM Author_Tbl WHERE Author_name = ?");

        ps.setString(1, authorName);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            author = new AuthorBean();
            author.setAuthorCode(rs.getInt("Author_code"));
            author.setAuthorName(rs.getString("Author_name"));
            author.setContactNo(rs.getLong("Contact_no"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return author;   
}

}