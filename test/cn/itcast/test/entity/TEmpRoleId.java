package cn.itcast.test.entity;

/**
 * TEmpRoleId entity. @author MyEclipse Persistence Tools
 */

public class TEmpRoleId implements java.io.Serializable {

	// Fields

	private TRole TRole;
	private TEmp TEmp;

	// Constructors

	/** default constructor */
	public TEmpRoleId() {
	}

	/** full constructor */
	public TEmpRoleId(TRole TRole, TEmp TEmp) {
		this.TRole = TRole;
		this.TEmp = TEmp;
	}

	// Property accessors

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public TEmp getTEmp() {
		return this.TEmp;
	}

	public void setTEmp(TEmp TEmp) {
		this.TEmp = TEmp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TEmpRoleId))
			return false;
		TEmpRoleId castOther = (TEmpRoleId) other;

		return ((this.getTRole() == castOther.getTRole()) || (this.getTRole() != null && castOther.getTRole() != null && this.getTRole().equals(castOther.getTRole())))
				&& ((this.getTEmp() == castOther.getTEmp()) || (this.getTEmp() != null && castOther.getTEmp() != null && this.getTEmp().equals(castOther.getTEmp())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTRole() == null ? 0 : this.getTRole().hashCode());
		result = 37 * result + (getTEmp() == null ? 0 : this.getTEmp().hashCode());
		return result;
	}

}