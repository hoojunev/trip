package cn.itcast.nsfw.reserve.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import cn.itcast.nsfw.item.entity.Item;

/**
 * Reserve entity. @author MyEclipse Persistence Tools
 */

public class Reserve implements java.io.Serializable {

	// Fields

	private String reserveId;
	private Item item;
	private String reserveNo;
	private Timestamp reserveTime;
	private String reservePlace;
	private String reserveDeclare;
	private String name;
	private String reserveMobile;
	private Timestamp replyTime;
	private String result;
	private String content;
	private String userId;

	// Constructors
	
	public static String RESERVE_STATE_UNDONE="0";
	public static String RESERVE_STATE_SUCCESS="1";
	public static String RESERVE_STATE_FAIL="2";
	public static Map<String,String> RESERVE_STATE_MAP;
	static{
		RESERVE_STATE_MAP=new HashMap<String,String>();
		RESERVE_STATE_MAP.put(RESERVE_STATE_UNDONE, "待受理");
		RESERVE_STATE_MAP.put(RESERVE_STATE_SUCCESS, "预约成功");
		RESERVE_STATE_MAP.put(RESERVE_STATE_FAIL, "预约失败");
	}
	
	
	/** default constructor */
	public Reserve() {
	}

	/** minimal constructor */
	public Reserve(String reserveId, Item item) {
		this.reserveId = reserveId;
		this.item = item;
	}

	/** full constructor */
	public Reserve(String reserveId, Item item, String reserveNo,
			Timestamp reserveTime, String reservePlace,
			String reserveDeclare, String name, String reserveMobile,
			Timestamp replyTime, String result, String content, String userId) {
		this.reserveId = reserveId;
		this.item = item;
		this.reserveNo = reserveNo;
		this.reserveTime = reserveTime;
		this.reservePlace = reservePlace;
		this.reserveDeclare = reserveDeclare;
		this.name = name;
		this.reserveMobile = reserveMobile;
		this.replyTime = replyTime;
		this.result = result;
		this.content = content;
		this.userId = userId;
	}

	// Property accessors

	public String getReserveId() {
		return this.reserveId;
	}

	public void setReserveId(String reserveId) {
		this.reserveId = reserveId;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getReserveNo() {
		return this.reserveNo;
	}

	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}

	public Timestamp getReserveTime() {
		return this.reserveTime;
	}

	public void setReserveTime(Timestamp reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getReservePlace() {
		return this.reservePlace;
	}

	public void setReservePlace(String reservePlace) {
		this.reservePlace = reservePlace;
	}

	public String getReserveDeclare() {
		return this.reserveDeclare;
	}

	public void setReserveDeclare(String reserveDeclare) {
		this.reserveDeclare = reserveDeclare;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReserveMobile() {
		return this.reserveMobile;
	}

	public void setReserveMobile(String reserveMobile) {
		this.reserveMobile = reserveMobile;
	}

	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}