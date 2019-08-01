package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import test1.model.Country;
import test1.model.CountryExample;
import test1.dao.CountryMapper;
public class ExampleTest extends BasicMapperTest{
	@Test
	public void testExample() {
		
		SqlSession sqlSession = getSqlSession();
		try {
			//获取CountryMapper接口
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			//创建Example对象
			CountryExample example = new CountryExample();
			//设置排序规则
			example.setOrderByClause("id desc, countryname asc");
			//设置是否去重
			example.setDistinct(true);
			//创建条件
			CountryExample.Criteria criteria = example.createCriteria();
			//id>=1
			criteria.andIdGreaterThanOrEqualTo(1);
			//id<4
			criteria.andIdLessThan(4);
			//countrycode like "%u%"
			criteria.andCountrycodeLike("%u%");
			//or的情况
			CountryExample.Criteria or = example.or();
			//countryname = '中国'
			or.andCountrynameEqualTo("中国");
			//执行查询
			List<Country> countryList = countryMapper.selectByExample(example);
			for (Country country : countryList) {
				System.out.println(country.getId()+","+country.getCountryname()+","+country.getCountrycode());
			}
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateByExampleSelective() {
		
		SqlSession sqlSession = getSqlSession();
		try {
			//获取CountryMapper接口
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			//创建Example对象
			CountryExample example = new CountryExample();
			//创建条件
			CountryExample.Criteria criteria = example.createCriteria();
			//id>2
			criteria.andIdGreaterThan(2);
			//创建要设置的对象
			Country country1 = new Country();
			country1.setCountryname("中国");
			//执行更新
			int row = countryMapper.updateByExampleSelective(country1, example);
			//受影响行数
			System.out.println(row);
			//查询更新后的信息
			List<Country> countryList = countryMapper.selectByExample(example);
			for (Country country : countryList) {
				System.out.println(country.getId()+","+country.getCountryname()+","+country.getCountrycode());
			}
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteByExampleSelective() {
		
		SqlSession sqlSession = getSqlSession();
		try {
			//获取CountryMapper接口
			CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
			//创建Example对象
			CountryExample example = new CountryExample();
			//创建条件
			CountryExample.Criteria criteria = example.createCriteria();
			//id>2
			criteria.andIdGreaterThan(2);
			//执行删除
			int row = countryMapper.deleteByExample(example);
			//受影响行数
			System.out.println(row);
			//更新后查询信息
			example = new CountryExample();
			criteria = example.createCriteria();
			criteria.andIdGreaterThan(1);
			List<Country> countryList = countryMapper.selectByExample(example);
			for (Country country : countryList) {
				System.out.println(country.getId()+","+country.getCountryname()+","+country.getCountrycode());
			}
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
}



















