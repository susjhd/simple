package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;

public class RoleMapperTest extends BasicMapperTest{
	@Test
	public void testSelectByRid() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = roleMapper.selectByRid(2);
			System.out.println(sysRole);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByRid2() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = roleMapper.selectByRid2(2);
			System.out.println(sysRole);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<SysRole> roleList = roleMapper.selectAll();
			System.out.println(roleList.size());
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = new SysRole();
			sysRole.setRid(4);
			sysRole.setRoleName("测试用户");
//			sysRole.setEnabled(1);
			sysRole.setCreateBy(1);
			sysRole.setCreateTime(new Date());
			roleMapper.insert(sysRole);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = new SysRole();
			sysRole.setRoleName("测试用户");
//			sysRole.setEnabled(1);
			sysRole.setCreateBy(1);
			sysRole.setCreateTime(new Date());
			roleMapper.insert2(sysRole);
			System.out.println(sysRole);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = new SysRole();
			sysRole.setRoleName("测试用户");
//			sysRole.setEnabled(1);
			sysRole.setCreateBy(1);
			sysRole.setCreateTime(new Date());
			roleMapper.insert2(sysRole);
			System.out.println(sysRole);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAllRoleAndPrivileges() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<SysRole> roleList = roleMapper.selectAllRoleAndPrivileges();
			for (SysRole sysRole : roleList) {
				System.out.println(sysRole);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRoleByUserId() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<SysRole> roleList = roleMapper.selectRoleByUserId(1);
			for (SysRole sysRole : roleList) {
				System.out.println(sysRole);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRoleByUserIdChoose() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			List<SysRole> roleList = roleMapper.selectRoleByUserIdChoose(1);
			for (SysRole sysRole : roleList) {
				System.out.println(sysRole);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByRid() {
		SqlSession sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role = new SysRole();
			role.setRid(2);
			role.setRoleName("用户普通");
			roleMapper.updateByRid(role);
			SysRole role2 = roleMapper.selectByRid(2);
			System.out.println(role2);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
		
	}
}
















