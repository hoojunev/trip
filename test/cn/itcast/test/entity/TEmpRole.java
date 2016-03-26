package cn.itcast.test.entity;

/**
 * TEmpRole entity. @author MyEclipse Persistence Tools
 */

public class TEmpRole implements java.io.Serializable {

	// Fields

	private TEmpRoleId id;
	private Boolean state;

	// Constructors

	/** default constructor */
	public TEmpRole() {
	}

	/** minimal constructor */
	public TEmpRole(TEmpRoleId id) {
		this.id = id;
	}

	/** full constructor */
	public TEmpRole(TEmpRoleId id, Boolean state) {
		this.id = id;
		this.state = state;
	}

	// Property accessors

	public TEmpRoleId getId() {
		return this.id;
	}

	public void setId(TEmpRoleId id) {
		this.id = id;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}