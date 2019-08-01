package tk.mybatis.simple.provider;

import org.apache.ibatis.jdbc.SQL;

public class PrivilegeProvider {
	public String selectByPid(final Integer pid) {
		return new SQL() {
			{
				SELECT("pid, privilege_name, privilege_url");
				FROM("sys_privilege");
				WHERE("pid = #{pid}");
			}
		}.toString();
	}
}
