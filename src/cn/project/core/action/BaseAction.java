package cn.project.core.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import cn.project.core.util.PageResult;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {

	protected String[] selectedRow;

	private int pageNo;

	private int pageSize;

	public static int DEFAULT_PAGE_SIZE = 10;

	protected PageResult pageResult;

	/**
	 * 将encodeStr对应的字符串进行decode
	 * 
	 * @param encodeStr encode过的字符串
	 * @return 原字符串（decode过后的字符串）
	 */
	public String decodeStr(String encodeStr) {
		try {
			return URLDecoder.decode(encodeStr, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		if (pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}

}
