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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import main.model.User;

//TODO - Spring Data JPA/Hibernate 	

@Repository
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
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO USERS(NAME,EMAIL,ADDRESS,PASSWORD,NEWSLETTER,FRAMEWORK,SEX,NUMBER,COUNTRY,SKILL)"
				+ " VALUES ( :name, :email, :address, :password, :newsletter, :framework, :sex, :number, :country, :skill)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user),keyHolder);
		user.setId(keyHolder.getKey().longValue());
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE USERS SET NAME=:name, EMAIL=:email, ADDRESS=:address,"
				+ "PASSWORD=:password, NEWSLETTER=:newsletter, FRAMEWORK=:framework,"
				+ "SEX=:sex, NUMBER=:number, COUNTRY=:country, SKILL=:skill WHERE id=:id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM USERS WHRE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id",id));
	}
	
	private SqlParameterSource getSqlParameterByModel(User user){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", user.getId());
		paramSource.addValue("name", user.getName());
		paramSource.addValue("email", user.getEmail());
		paramSource.addValue("address", user.getAddress());
		paramSource.addValue("password", user.getPassword());
		paramSource.addValue("newsletter", user.isNewsletter());
		
		//join String
		paramSource.addValue("framework", convertListToDelimitedString(user.getFramework()));
		paramSource.addValue("sex", user.getSex());
		paramSource.addValue("number", user.getNumber());
		paramSource.addValue("country", user.getCountry());
		paramSource.addValue("skill", convertListToDelimitedString(user.getSkill()));
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