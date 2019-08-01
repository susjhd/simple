package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class CacheTest extends BasicMapperTest{
	@Test
	public void testL1Cache() {
		SqlSession sqlSession = getSqlSession();
		SysUser sysUser1 = null;
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			sysUser1 = userMapper.selectByUid(1);
			System.out.println(sysUser1.hashCode());
			sysUser1.setUserName("ADMIN");
			SysUser sysUser2 = userMapper.selectByUid(1);
			System.out.println(sysUser2.hashCode());
			//第二次查询从缓存中取，sysUser1和sysUser2是同一个实例，所以sysUser2.getUserName=ADMIN
			//mybatis的一级缓存存在于一个sqlSession的生命周期中
			sqlSession = getSqlSession();
			userMapper = sqlSession.getMapper(UserMapper.class);
			sysUser2 = userMapper.selectByUid(1);
			userMapper.deleteByUid(1001);
			SysUser sysUser3 = userMapper.selectByUid(1);
			System.out.println(sysUser2.hashCode());
			System.out.println(sysUser3.hashCode());
			//执行任何的INSERT、UPDATE、DELETE都会清除一级缓存
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testL2Cache() {
		SqlSession sqlSession = getSqlSession();
		SysRole role1 = null;
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			role1 = roleMapper.selectByRid(2);
			role1.setRoleName("用户普通");
			SysRole role2 = roleMapper.selectByRid(2);
			System.out.println(role1.hashCode());
			System.out.println(role2.hashCode());
			System.out.println(role2);
			
//			sqlSession = getSqlSession();
//			userMapper = sqlSession.getMapper(UserMapper.class);
//			sysUser2 = userMapper.selectByUid(1);
//			userMapper.deleteByUid(1001);
//			SysUser sysUser3 = userMapper.selectByUid(1);
//			System.out.println(sysUser2.hashCode());
//			System.out.println(sysUser3.hashCode());
//			//执行任何的INSERT、UPDATE、DELETE都会清除一级缓存
		} finally {
			sqlSession.close();//该方法执行后才会保存查询数据到二级缓存
		}
		
		sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role2 = roleMapper.selectByRid(2);
			SysRole role3 = roleMapper.selectByRid(2);
			//因为是可读写缓存，role2和role3是反序列化的结果所以不是相同的实例
			System.out.println(role2.hashCode());
			System.out.println(role2);
			System.out.println(role3.hashCode());
			System.out.println(role3);
			
//			sqlSession = getSqlSession();
//			userMapper = sqlSession.getMapper(UserMapper.class);
//			sysUser2 = userMapper.selectByUid(1);
//			userMapper.deleteByUid(1001);
//			SysUser sysUser3 = userMapper.selectByUid(1);
//			System.out.println(sysUser2.hashCode());
//			System.out.println(sysUser3.hashCode());
//			//执行任何的INSERT、UPDATE、DELETE都会清除一级缓存
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testL2Cache2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectUserAndRoleByUid(1001);
			System.out.println("修改前的user："+user);
		} finally {
			sqlSession.close();
		}
		
		sqlSession = getSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role = new SysRole();
			role.setRid(2);
			role.setRoleName("脏数据");
			roleMapper.updateByRid(role);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		
		sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole role = roleMapper.selectByRid(2);
			System.out.println("修改后的role："+role);
			SysUser user = userMapper.selectUserAndRoleByUid(1001);
			System.out.println("修改后的user："+user);
		} finally {
			sqlSession.close();
		}
	}
}




































