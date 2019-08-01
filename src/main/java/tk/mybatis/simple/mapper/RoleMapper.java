package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import tk.mybatis.simple.model.SysRole;
//配置二级缓存，接口文件和xml文件必须同时配置
@CacheNamespaceRef(RoleMapper.class)
//@CacheNamespace(
//		eviction = FifoCache.class,
//		flushInterval = 60000,
//		size = 512,
//		readWrite = false
//	)
public interface RoleMapper {
	@Select({"select * from sys_role where rid = #{rid}"})
	SysRole selectByRid(Integer rid);
	
	@Results({
		@Result(property = "rid", column = "rid", id = true),
		@Result(property = "roleName", column = "role_name"),
		@Result(property = "enabled", column = "enabled"),
		@Result(property = "createBy", column = "create_by"),
		@Result(property = "createTime", column = "create_time") 
	})
	@Select({"select rid, role_name, enabled, create_by, create_time from sys_role where rid = #{rid}"})
	SysRole selectByRid2(Integer rid);
	
	/* @ResultMap("roleResultMap") */
	@Select({"select * from sys_role"})
	List<SysRole> selectAll();
	
	@Insert("insert into sys_role (rid, role_name, enabled, create_by, create_time) values (#{rid}, #{roleName}, #{enabled},"
			+ "#{createBy}, #{createTime, jdbcType=TIMESTAMP})")
	int insert(SysRole sysRole);
	
	@Insert("insert into sys_role (role_name, enabled, create_by, create_time) values (#{roleName}, #{enabled},"
			+ "#{createBy}, #{createTime, jdbcType=TIMESTAMP})")
	@Options(useGeneratedKeys = true, keyProperty = "rid")
	int insert2(SysRole sysRole);
	
	@Insert("insert into sys_role (role_name, enabled, create_by, create_time) values (#{roleName}, #{enabled},"
			+ "#{createBy}, #{createTime, jdbcType=TIMESTAMP})")
	@SelectKey(statement = "SELECT_LAST_ID()", keyProperty = "rid", resultType = Integer.class, before = false)
	int insert3(SysRole sysRole);
	
	@Update({"update sys_role set role_name=#{roleName}, enabled=#{enabled}, create_by=#{createBy}, create_time=#{createTime, jdbcType=TIMESTAMP} where rid=#{rid}"})
	int updateByRid(SysRole sysRole);
	
	SysRole selectRoleByRid(Integer rid);
	
	List<SysRole> selectAllRoleAndPrivileges();
	
	List<SysRole> selectRoleByUserId(Integer userId);
	
	List<SysRole> selectRoleByUserIdChoose(Integer userId);
	
}



















