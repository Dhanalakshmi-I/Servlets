package com.kce.book.service;

import com.kce.book.bean.BookBean;
import com.kce.book.dao.BookDAO;

public class Administrator {
public String addBook(BookBean bookBean) {
	if (bookBean == null
	        || bookBean.getBookName() == null || bookBean.getBookName().isEmpty()
	        || bookBean.getIsbn() == null || bookBean.getIsbn().isEmpty()
	        || (bookBean.getBookType() != 'G' && bookBean.getBookType() != 'T')
	        || bookBean.getCost() <= 0
	        || bookBean.getAuthor() == null
	        || bookBean.getAuthor().getAuthorName() == null
	        || bookBean.getAuthor().getAuthorName().isEmpty()) {

	    return "INVALID";
	}

	int result=new BookDAO().createBook(bookBean);
	if(result==1) {
		return "SUCCESS";
	}
	else {
		return "FAILURE";
	}
}
	public BookBean viewBook(String isbn) {
		if(isbn==null) {
			return null;
		}
		BookBean result=new BookDAO().fetchBook(isbn);
			return result;
	}

}