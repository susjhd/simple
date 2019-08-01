package tk.mybatis.simple.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	
	SysUser selectByUid(Integer uid);
	
	List<SysUser> selectAll();
	
	List<SysRole> selectRoleByUid(Integer uid);
	
	int insert(SysUser sysUser);
	
	int updateByUid(SysUser sysUser);
	
	int deleteByUid(Integer uid);
	
	List<SysRole> selectRoleByUidAndRoleEnabled(@Param("sysUser")SysUser sysUser, @Param("sysRole")SysRole sysRole);

	List<SysUser> selectByUser(SysUser sysUser);
	
	int updateByUidSelective(SysUser sysUser);
	
	int insert2(SysUser sysUser);
	
	SysUser selectByUidOrUserName(SysUser sysUser);
	
	List<SysUser> selectByUidList(List<Integer> uidList);
	
	int insertList(List<SysUser> userList);
	
	int updateByMap(Map<String, Object> map);
	
	SysUser selectUserAndRoleByUid(Integer uid);
	
	SysUser selectUserAndRoleByUidSelect(Integer uid);
	
	List<SysUser> selectAllUserAndRoles();
	
	SysUser selectAllUserAndRolesSelect(Integer uid);
	
	void selectUserByUid(Map<String, Object> map);
	
	List<SysUser> selectUserPage(Map<String, Object> params);
	
	int insertUserAndRoles(@Param("user")SysUser user, @Param("roleIds")String roleIds);
	
	int deleteUserByUid(Integer uid);
}









