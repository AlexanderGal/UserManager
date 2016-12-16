package main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.util.StringUtils;

import main.model.User;

//TODO - Spring Data JPA/Hibernate 	

public class UserDaoImpl implements UserDao{
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate npJdbcT){
		this.namedParameterJdbcTemplate = npJdbcT;
	}
	
	@Override
	public User findById(Long id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM users";
		List<User> result = namedParameterJdbcTemplate.query(sql,new UserMapper());
		return result;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM USERS WHRE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id",id));
	}
	
	private SqlParameterSource getSqlParameterByModel(User user){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		//TODO add value
		return paramSource;
	}
	
	private static final class UserMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
			user.setAddress(rs.getString("address"));
			user.setCountry(rs.getString("country"));
			user.setNewsletter(rs.getBoolean("newsletter"));
			user.setNumber(rs.getInt("number"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
			return user;
		}
	}	
	
	private static List<String> convertDelimitedStringToList(String delimitedString) {
			List<String> result = new ArrayList<String>();
			if(!StringUtils.isEmpty(delimitedString)){
				result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
			}
			return result;
	}
	
	private static String convertListToDelimitedString(List<String> list){
		String result = "";
		if (list!=null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;
	}
}