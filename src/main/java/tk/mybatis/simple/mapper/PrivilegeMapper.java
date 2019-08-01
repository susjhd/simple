package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.provider.PrivilegeProvider;

public interface PrivilegeMapper {
	
	@SelectProvider(type = PrivilegeProvider.class, method = "selectByPid")
	SysPrivilege selectByPid(Integer pid);
	
	List<SysPrivilege> selectPrivilegeByRoleId(Integer roleId);
}
