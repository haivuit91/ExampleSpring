package com.asiantech.haivu.spring.entity;

public class Page {

	private int pageNumber; // So trang
	private int pageSize; // So trang hien thi
	private int currentPage; // Trang hien tai
	private int rowCount; // Tong so trang

	public Page() {
		pageNumber = 0;
		pageSize = 5;
		currentPage = 0;
		rowCount = 0;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage < 0)
			this.currentPage = 0;
		else if (currentPage > getPageCount() - 1)
			this.currentPage = getPageCount() - 1;
		else
			this.currentPage = currentPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return (int) Math.ceil(rowCount * 1.0 / pageSize);
	}

}
