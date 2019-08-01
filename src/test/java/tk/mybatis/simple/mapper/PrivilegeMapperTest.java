package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysPrivilege;

public class PrivilegeMapperTest extends BasicMapperTest{
	@Test
	public void testSelectByPid() {
		SqlSession sqlSession = getSqlSession();
		try {
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			SysPrivilege sysPrivilege = privilegeMapper.selectByPid(2);
			System.out.println(sysPrivilege);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectPrivilegeByRoleId() {
		SqlSession sqlSession = getSqlSession();
		try {
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			List<SysPrivilege> privilegeList = privilegeMapper.selectPrivilegeByRoleId(1);
			for (SysPrivilege sysPrivilege : privilegeList) {
				System.out.println(sysPrivilege);
			}
		} finally {
			sqlSession.close();
		}
	}
}
