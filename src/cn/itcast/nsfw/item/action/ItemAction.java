package cn.itcast.nsfw.item.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import cn.itcast.core.action.BaseAction;
import cn.itcast.core.util.Constant;
import cn.itcast.core.util.QueryHelper;
import cn.itcast.nsfw.item.entity.Item;
import cn.itcast.nsfw.item.service.ItemService;
import cn.itcast.nsfw.user.entity.User;
import cn.itcast.nsfw.user.service.UserService;

import com.opensymphony.xwork2.ActionContext;

public class ItemAction extends BaseAction {
	 
	@Resource
	ItemService itemService;
	@Resource
	UserService userService;
	private String strItemNo;
	private String strItemTitle;
	private String strItemDept;
	private Item item;
	private Map<String,Object> resultMap;
	
	public String listUI(){
		QueryHelper queryHelper = new QueryHelper(Item.class, "i");
		if(item!=null){
			System.out.println(item.getItemName()+","+item.getItemDept());
			
			if(StringUtils.isNotBlank(item.getItemNo())){
				item.setItemNo(item.getItemNo());
				queryHelper.addCondition(" i.itemNo like ?", "%"+ item.getItemNo()+"%" );
				
			}
			
			if(StringUtils.isNotBlank(item.getItemName())){
				item.setItemName(decodeStr(item.getItemName()));
				queryHelper.addCondition(" i.itemName like ? ", "%"+item.getItemName()+"%");
			}
			
			if(StringUtils.isNotBlank(item.getItemDept())){
				item.setItemDept(decodeStr(item.getItemDept()));
				queryHelper.addCondition(" i.itemDept = ?", item.getItemDept());
			}
			
		}
		queryHelper.addOrderByProperty(" i.itemState ",QueryHelper.ORDER_BY_DESC);
		
		pageResult = itemService.getPageResult(queryHelper, getPageNo(), getPageSize());
		
		return "listUI";
	}
	
	public String addUI(){
		if(item!=null){
			if(StringUtils.isNotBlank(item.getItemName())){
				strItemTitle = item.getItemName();
			}
			if(StringUtils.isNotBlank(item.getItemDept())){
				strItemDept = item.getItemDept();
			}
		}
		return "addUI";
	}
	
	public String add(){
		if(item!=null){
			itemService.save(item);
		}
		item =null;
		return "list";
	}
	
	public String editUI() {
		if(item!=null && StringUtils.isNotBlank(item.getItemId())){
			
			if(StringUtils.isNotBlank(item.getItemName())){
				strItemTitle = item.getItemName();
			}
			if(StringUtils.isNotBlank(item.getItemDept())){
				strItemDept = item.getItemDept();
			}
			item = itemService.findObjectById(item.getItemId());
			
			QueryHelper queryHelper = new QueryHelper(User.class,"u");
			queryHelper.addCondition("u.dept like ?", "%"+item.getItemDept()+"%");
			List<User> userList = userService.findObjects(queryHelper);
			List<String> dealerList = new ArrayList<String>();
			for (User user : userList) {
				dealerList.add( user.getName());
			}
			ActionContext.getContext().put("dealerList", dealerList);
			
		}
		return "editUI";
	}
	public String edit() {
		if(item!=null){
			QueryHelper qh = new QueryHelper(User.class,"u");
			
			qh.addCondition(" u.name = ?", item.getItemDealDeptr());
			List<User> list = userService.findObjects(qh);
			System.out.println(item.getItemState());
			item.setUserId(list.get(0).getId());
			itemService.update(item);
		}
		item = null;
		return "list";
	}
	
	public String delete(){
		if(item!=null &&StringUtils.isNotBlank(item.getItemId())){
			if(StringUtils.isNotBlank(item.getItemName())){
				strItemTitle = item.getItemName();
			}
			if(StringUtils.isNotBlank(item.getItemDept())){
				strItemDept = item.getItemDept();
			}
			itemService.delete(item.getItemId());
		}
		
		return "list";
	}
	
	public String batchDelete(){
		
		if(StringUtils.isNotBlank(item.getItemName())){
			strItemTitle = item.getItemName();
		}
		if(StringUtils.isNotBlank(item.getItemDept())){
			strItemDept = item.getItemDept();
		}
		itemService.delete(item.getItemId());
		if(selectedRow != null){
			for (int i = 0; i < selectedRow.length; i++) {
				itemService.delete(selectedRow[i]);
			}
		}
		return "list";
	}
	
	
	public String getDealDeptr(){
		if(item !=null && StringUtils.isNotBlank(item.getItemDept())){
			QueryHelper queryHelper = new QueryHelper(User.class,"u");
			queryHelper.addCondition("u.dept like ?", "%"+item.getItemDept()+"%");
			List<User> userList = userService.findObjects(queryHelper);
			
			resultMap = new HashMap<String,Object>();
			resultMap.put("msg", "success");
			resultMap.put("userList", userList);
		}
		return "jsonResult";
	}
	
	
	public String noPermission(){
		return "noPermission";
	}

	public String getStrItemNo() {
		return strItemNo;
	}

	public void setStrItemNo(String strItemNo) {
		this.strItemNo = strItemNo;
	}

	public String getStrItemTitle() {
		return strItemTitle;
	}

	public void setStrItemTitle(String strItemTitle) {
		this.strItemTitle = strItemTitle;
	}

	public String getStrItemDept() {
		return strItemDept;
	}

	public void setStrItemDept(String strItemDept) {
		this.strItemDept = strItemDept;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
}
