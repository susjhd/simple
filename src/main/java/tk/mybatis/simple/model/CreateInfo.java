package tk.mybatis.simple.model;

import java.io.Serializable;
import java.util.Date;

public class CreateInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer createBy;
	private Date createTime;
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
	@Override
	public String toString() {
		return "CreateInfo [createBy=" + createBy + ", createTime=" + createTime + "]";
	}
	
	
}
