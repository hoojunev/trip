package cn.project.home.action;

import com.opensymphony.xwork2.ActionSupport;
// import cn.project.travel.item.entity.Item;
// import cn.project.travel.item.service.ItemService;
// import cn.project.travel.reserve.entity.Reserve;
// import cn.project.travel.reserve.service.ReserveService;

public class HomeAction extends ActionSupport {

	// @Resource
	// private UserService userService;
	// @Resource
	// private InfoService infoService;
	// @Resource
	// private ItemService itemService;
	// @Resource
	// private ReserveService reserveService;
	// private Map<String, Object> return_map;
	// private Info info;
	// private Item item;
	// private Reserve reserve;
	// private String reserveTime;
	// 跳转到系统首页
	@Override
	public String execute() {
		// // 加载信息列表
		// ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		// QueryHelper queryHelper = new QueryHelper(Info.class, "");
		// queryHelper.addCondition("state=?", Info.INFO_STATE_PUBLIC);
		// queryHelper.addOrderByProperty("createTime", QueryHelper.ORDER_BY_DESC);
		// List<Info> infoList = infoService.getPageResult(queryHelper, 1, 6).getItems();
		// ActionContext.getContext().getContextMap().put("infoList", infoList);
		// // 加载我的投诉列表
		// User user = (User) ServletActionContext.getRequest().getSession().getAttribute(Constant.USER);
		// ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		// QueryHelper queryHelper2 = new QueryHelper(Complain.class, "");
		// queryHelper2.addCondition("compName = ?", user.getName());
		// List<Complain> complainList = complainService.getPageResult(queryHelper2, 1, 7).getItems();
		// ActionContext.getContext().getContextMap().put("complainList", complainList);
		// // 加载我的预约列表
		// ActionContext.getContext().getContextMap().put("reserveStateMap", Reserve.RESERVE_STATE_MAP);
		// QueryHelper queryHelper3 = new QueryHelper(Reserve.class, "");
		// queryHelper3.addCondition("userId = ?", user.getId());
		// List<Reserve> reserveList = reserveService.getPageResult(queryHelper3, 1, 8).getItems();
		// ActionContext.getContext().getContextMap().put("reserveList", reserveList);
		return "home";
	}
	// // 跳转到我要投诉
	// public String complainAddUI() {
	// return "complainAddUI";
	// }
	// **
	// 跳转到我要预约页面：需要先查询有效的可选预约事项，转发到我要预约页面
	//
	// @return
	// /
	//
	// public String reserveAddUI() {
	// QueryHelper queryHelper = new QueryHelper(Item.class, "");
	// queryHelper.addCondition("itemState = ?", Item.ITEM_STATE_VALID);
	// List<Item> items = itemService.findObjects(queryHelper);
	// Map<String, String> itemMaps = new HashMap<String, String>();
	// for (Item item : items) {
	// itemMaps.put(item.getItemId(), item.getItemName());
	// }
	// ServletActionContext.getContext().put("itemMaps", itemMaps);
	// return "reserveAddUI";
	// }
	// **
	// 添加新的预约：用户的预约信息会提交到该action方法，进行保存
	//
	// @throws ParseException
	// /
	//
	// public void reserveAdd() throws ParseException {
	// try {
	// // 1、获取表单内容
	// if (reserve != null) {
	// // 保存预约的事项信息
	// reserve.setItem(itemService.findObjectById(item.getItemId()));
	// User user = (User) ServletActionContext.getRequest().getSession().getAttribute("SYS_USER");
	// reserve.setName(user.getName());
	// reserve.setUserId(user.getId());
	// reserve.setReserveMobile(user.getMobile());
	// reserve.setResult(Reserve.RESERVE_STATE_UNDONE);
	// reserve.setReserveTime(new Timestamp(DateUtils.parseDate(reserveTime, "yyyy-MM-dd HH:mm").getTime()));
	// ;
	// // 创建预约编号
	// String reserveNo = new SimpleDateFormat("yyyyMMdd").format(DateUtils.parseDate(reserveTime,
	// "yyyy-MM-dd HH:mm"));
	// QueryHelper queryHelper = new QueryHelper(Reserve.class, "");
	// queryHelper.addCondition("reserveNo like ?", reserveNo + "%");
	// List<Reserve> reserves = reserveService.findObjects(queryHelper);
	// int length = reserves.size();
	// if (length < 9) {
	// reserveNo = reserveNo + "00" + (length + 1);
	// } else if (length >= 9 && length < 99) {
	// reserveNo = reserveNo + "0" + (length + 1);
	// } else {
	// reserveNo = reserveNo + (length + 1);
	// }
	// reserve.setReserveNo(reserveNo);
	// reserveService.save(reserve);
	// // 3、输出预约信息提交成功的提示信息
	// HttpServletResponse response = ServletActionContext.getResponse();
	// response.setContentType("text/html;charset=utf-8");
	// ServletOutputStream outputStream = response.getOutputStream();
	// outputStream.write("success".getBytes("utf-8"));
	// outputStream.close();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// **
	// 查看详细的预约信息
	//
	// @return
	// /
	//
	// public String reserveViewUI() {
	// ActionContext.getContext().getContextMap().put("reserveStateMap", Reserve.RESERVE_STATE_MAP);
	// if (reserve != null) {
	// reserve = reserveService.findObjectById(reserve.getReserveId());
	// }
	// return "reserveViewUI";
	// }
	// public void reserveFullorNot() throws ParseException {
	// try {
	// String reserveNo = reserveTime.substring(0, 10).replace("-", "");
	// QueryHelper queryHelper = new QueryHelper(Reserve.class, "");
	// queryHelper.addCondition("reserveNo like ?", reserveNo + "%");
	// List<Reserve> reserves = reserveService.findObjects(queryHelper);
	// if (reserves.size() >= 999) {
	// ServletOutputStream sos = ServletActionContext.getResponse().getOutputStream();
	// sos.write("full".getBytes("utf-8"));
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// // 根据部门获取该部门下的人员列表并输出Json格式字符串
	// public void getUserJson() {
	// try {
	// // 1、获取部门
	// String dept = ServletActionContext.getRequest().getParameter("dept");
	// if (StringUtils.isNotBlank(dept)) {
	// // 2、根据部门获取该部门下的人员列表
	// QueryHelper queryHelper = new QueryHelper(User.class, "");
	// queryHelper.addCondition("dept like ?", "%" + dept);
	// List<User> userList = userService.findObjects(queryHelper);
	// // 创建json对象
	// JSONObject jso = new JSONObject();
	// jso.put("msg", "success");
	// jso.accumulate("userList", userList);
	// // 3、输出Json格式字符串
	// HttpServletResponse response = ServletActionContext.getResponse();
	// response.setContentType("text/html;charset=utf-8");
	// ServletOutputStream outputStream = response.getOutputStream();
	// outputStream.write(jso.toString().getBytes("utf-8"));
	// outputStream.close();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// // 根据部门获取该部门下的人员列表并输出Json格式字符串
	// public String getUserJson2() {
	// try {
	// // 1、获取部门
	// String dept = ServletActionContext.getRequest().getParameter("dept");
	// if (StringUtils.isNotBlank(dept)) {
	// // 2、根据部门获取该部门下的人员列表
	// QueryHelper queryHelper = new QueryHelper(User.class, "");
	// queryHelper.addCondition("dept like ?", "%" + dept);
	// List<User> userList = userService.findObjects(queryHelper);
	// return_map = new HashMap<String, Object>();
	// return_map.put("msg", "success");
	// return_map.put("userList", userList);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return "success";
	// }
	// // 保存我要投诉
	// public void complainAdd() {
	// try {
	// // 1、获取表单内容
	// if (comp != null) {
	// // 2、保存投诉信息
	// comp.setCompTime(new Timestamp(new Date().getTime()));
	// comp.setState(Complain.COMPLAIN_STATE_UNDONE);
	// complainService.save(comp);
	// // 3、输出投诉结果
	// HttpServletResponse response = ServletActionContext.getResponse();
	// response.setContentType("text/html;charset=utf-8");
	// ServletOutputStream outputStream = response.getOutputStream();
	// outputStream.write("success".getBytes("utf-8"));
	// outputStream.close();
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// // 查看信息
	// public String infoViewUI() {
	// ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
	// if (info != null) {
	// info = infoService.findObjectById(info.getInfoId());
	// }
	// return "infoViewUI";
	// }
	// // 查看投诉信息
	// public String complainViewUI() {
	// ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
	// if (comp != null) {
	// comp = complainService.findObjectById(comp.getCompId());
	// }
	// return "complainViewUI";
	// }
	// public Map<String, Object> getReturn_map() {
	// return return_map;
	// }
	// public Info getInfo() {
	// return info;
	// }
	// public void setInfo(Info info) {
	// this.info = info;
	// }
	// public Item getItem() {
	// return item;
	// }
	// public void setItem(Item item) {
	// this.item = item;
	// }
	// public Reserve getReserve() {
	// return reserve;
	// }
	// public void setReserve(Reserve reserve) {
	// this.reserve = reserve;
	// }
	// public String getReserveTime() {
	// return reserveTime;
	// }
	// public void setReserveTime(String reserveTime) {
	// this.reserveTime = reserveTime;
	// }
}
