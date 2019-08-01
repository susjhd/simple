package tk.mybatis.simple.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SysRole implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer rid;
	 private String roleName;
	 private Integer enabled;
	 private Integer createBy;
	 private Date createTime;
	 private CreateInfo createInfo;
	 private List<SysPrivilege> privilegeList;
	 
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public CreateInfo getCreateInfo() {
		return createInfo;
	}
	public void setCreateInfo(CreateInfo createInfo) {
		this.createInfo = createInfo;
	}
	public List<SysPrivilege> getPrivilegeList() {
		return privilegeList;
	}
	public void setPrivilegeList(List<SysPrivilege> privilegeList) {
		this.privilegeList = privilegeList;
	}
	@Override
	public String toString() {
		return "SysRole [rid=" + rid + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy
				+ ", createTime=" + createTime + ", createInfo=" + createInfo + ", privilegeList=" + privilegeList
				+ "]";
	}
	
	
	 
}
