package tk.mybatis.simple.model;

public class SysPrivilege {

	 private Integer pid;
	 private String privilegeName;
	 private String privilegeUrl;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getPrivilegeUrl() {
		return privilegeUrl;
	}
	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}
	@Override
	public String toString() {
		return "SysPrivilege [pid=" + pid + ", privilegeName=" + privilegeName + ", privilegeUrl=" + privilegeUrl + "]";
	}
	 
	 
}
