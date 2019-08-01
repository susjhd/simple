package tk.mybatis.simple.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BasicMapperTest{
	
	@Test
	public void testSelectByUid() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser user = userMapper.selectByUid(1001);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAll();
			for (SysUser sysUser : userList) {
				System.out.println(sysUser);
			}
		}finally {
			sqlSession.close();
		}
		
	}

	@Test
	public void testSelectRoleByUid() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<SysRole> roleList = userMapper.selectRoleByUid(1);
		for (SysRole sysRole : roleList) {
			System.out.println(sysRole);
		}
		sqlSession.close();
	}
	
	@Test
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test1");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("test1@mybatis.tk");
			sysUser.setUserInfo("test1 info");
			sysUser.setHeadImg(new byte[] {1, 2, 3});
			sysUser.setCreateTime(new Date());
			int row = userMapper.insert(sysUser);
			System.out.println(row);
			System.out.println(sysUser);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByUid() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = userMapper.selectByUid(1);
			sysUser.setUserName("admin_test");
			sysUser.setUserEmail("admin_test@mybatis.tk");
			userMapper.updateByUid(sysUser);
			SysUser user = userMapper.selectByUid(1);
			System.out.println(user);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteByUid() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			int row = userMapper.deleteByUid(1001);
			List<SysUser> userList = userMapper.selectAll();
			System.out.println(row);
			System.out.println(userList.size());
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRoleByUidAndRoleEnabled() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser sysUser = new SysUser();
		sysUser.setUid(1);
		SysRole sysRole = new SysRole();
//		sysRole.setEnabled(1);
		List<SysRole> roleList = userMapper.selectRoleByUidAndRoleEnabled(sysUser, sysRole);
		for (SysRole Role : roleList) {
			System.out.println(Role);
		}
		sqlSession.close();
	}
	
	@Test
	public void testSelectByUser() {
		SqlSession sqlSession = getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser sysUser = new SysUser();
		sysUser.setUserName("a");
		sysUser.setUserEmail("");
		List<SysUser> userList = userMapper.selectByUser(sysUser);
		for (SysUser user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}
	
	@Test
	public void testUpdateByUidSelective() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUid(1);
			sysUser.setUserName("admin_test");
			sysUser.setUserPassword("654321");
			sysUser.setUserInfo("user_info");
			sysUser.setUserEmail("admin_test@mybatis.tk");
			sysUser.setHeadImg(new byte[] {1,2,3});
			sysUser.setCreateTime(new Date());
			userMapper.updateByUidSelective(sysUser);
			SysUser user = userMapper.selectByUid(1);
			System.out.println(user);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("test1");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("");
			sysUser.setUserInfo("test1 info");
			sysUser.setHeadImg(new byte[] {1, 2, 3});
			sysUser.setCreateTime(new Date());
			userMapper.insert2(sysUser);
			SysUser user = userMapper.selectByUid(sysUser.getUid());
			System.out.println(user);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByUidOrUserName() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUid(null);
			sysUser.setUserName("");
			SysUser user = userMapper.selectByUidOrUserName(sysUser);
			System.out.println(user);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectByUidList() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<Integer> uidList = new ArrayList<Integer>();
			uidList.add(1);
			uidList.add(1001);
			List<SysUser> userList = userMapper.selectByUidList(uidList);
			for (SysUser sysUser : userList) {
				System.out.println(sysUser);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsertList() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = new ArrayList<SysUser>();
			SysUser sysUser = new SysUser();
			sysUser.setUserName("admin1");
			sysUser.setUserPassword("111111");
			sysUser.setUserEmail("admin1@mybatis.tk");
			sysUser.setUserInfo("admin1_info");
			sysUser.setHeadImg(new byte[] {1,1,1});
			sysUser.setCreateTime(new Date());
			userList.add(sysUser);
			SysUser sysUser1 = new SysUser();
			sysUser1.setUserName("admin2");
			sysUser1.setUserPassword("222222");
			sysUser1.setUserEmail("admin2@mybatis.tk");
			sysUser1.setUserInfo("admin2_info");
			sysUser1.setHeadImg(new byte[] {2,2,2});
			sysUser1.setCreateTime(new Date());
			userList.add(sysUser1);
			int row = userMapper.insertList(userList);
			System.out.println(row);
			System.out.println(sysUser);
			System.out.println(sysUser1);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	@Test
	public void testUpdateByMap() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uid", 1);
			map.put("user_name", "admin_test");
			map.put("user_email", "admin_test@mybatis.tk");
			int row = userMapper.updateByMap(map);
			SysUser user = userMapper.selectByUid(1);
			System.out.println(row);
			System.out.println(user);
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoleByUid() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoleByUid(1001);
			System.out.println(user);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserAndRoleByUidSelect() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoleByUidSelect(1001);
			System.out.println(user);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAllUserAndRoles() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> userList = userMapper.selectAllUserAndRoles();
			for (SysUser sysUser : userList) {
				System.out.println(sysUser);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAllUserAndRolesSelect() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectAllUserAndRolesSelect(1);
			System.out.println(user);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserByUid() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser user = new SysUser();
//			user.setUid(1);
//			userMapper.selectUserByUid(user);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uid", 1);
			userMapper.selectUserByUid(map);
			System.out.println(map);
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectUserPage() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//			SysUser user = new SysUser();
//			user.setUid(1);
//			userMapper.selectUserByUid(user);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userName", "ad");
			params.put("offset", 0);
			params.put("limit", 10);
			List<SysUser> userList = userMapper.selectUserPage(params);
			System.out.println(params);
			for (SysUser sysUser : userList) {
				System.out.println(sysUser);
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsertUserAndRoles() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test1@mybatis.tk");
			user.setUserInfo("测试用户1");
			user.setHeadImg(new byte[] {1,2,3});
			
			int row = userMapper.insertUserAndRoles(user, "1,2");
			System.out.println(row);
			System.out.println(user);
			int row2 = userMapper.deleteUserByUid(user.getUid());
			System.out.println(row2);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteUserByUid() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			int row = userMapper.deleteUserByUid(1013);
			System.out.println(row);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
}











