package com.company.dao.impl;
import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Musaisayev624
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
public EmploymentHistory getEmpHistory(ResultSet rs) throws SQLException {
int id = rs.getInt("id");
int userId = rs.getInt("user_id");
String header = rs.getString("header");
String jobDescription = rs.getString("job_description");
Date beginDate = rs.getDate("begin_date");
Date endDate = rs.getDate("end_date");
EmploymentHistory us=new EmploymentHistory(null,header,beginDate,endDate,jobDescription,new User(userId));
// EmploymentHistory us = new EmploymentHistory(id, new User(userId), header, beginDate, endDate, jobDescription);
//System.out.println(us);
return us;
}
@Override
public List<EmploymentHistory> getAll() {
List<EmploymentHistory> list = new ArrayList<>();
Connection conn;
try {
conn = connect();
Statement stmt = conn.createStatement();
stmt.execute("SELECT * FROM employment_history");
ResultSet rs = stmt.getResultSet();
while (rs.next()) {
EmploymentHistory us = getEmpHistory(rs);
list.add(us);
}
}catch(Exception ex) {
}
return list;
}
@Override
public EmploymentHistory getById(int id) {
EmploymentHistory em = null;
Connection conn;
try {
conn = connect();
PreparedStatement stmt = conn.prepareStatement("SELECT * FROM employment_history WHERE ID = ?");
stmt.setInt(1, id);
stmt.execute();
ResultSet rs = stmt.getResultSet();
while (rs.next()) {
em = getEmpHistory(rs);
return em;
}
}catch(Exception ex) {
System.err.println(ex);
}
return em;
}
@Override
public boolean updateEmploymentHistory(EmploymentHistory u) {
Connection conn;
boolean b = true;
try{
conn = connect();
PreparedStatement stmt = conn.prepareStatement("UPDATE employment_history SET header=? , job_description=? , begin_date = ? , end_date = ? WHERE ID= ?");
stmt.setString(1, u.getHeader());
stmt.setString(2, u.getJobDecription());
stmt.setDate(3, u.getBeginDate());
stmt.setDate(4, u.getEndDate());
stmt.setInt(5, u.getId());
b = stmt.execute();
} catch (Exception ex) {
System.err.println(ex);
b = false;
}
return b;
}
@Override
public boolean insertEmploymentHistory(EmploymentHistory u) {
Connection conn;
boolean b = true;
try {
conn = connect();
PreparedStatement stmt = conn.prepareStatement("INSERT employment_history  (header , job_description , begin_date  , end_date, user_id ) VALUES (? , ? , ? , ? , ?) ",Statement.RETURN_GENERATED_KEYS);
stmt.setString(1, u.getHeader());
stmt.setString(2, u.getJobDecription());
stmt.setDate(3, u.getBeginDate());
stmt.setDate(4, u.getEndDate());
stmt.setInt(5, u.getUser().getId());
b = stmt.execute();
ResultSet genKeys = stmt.getGeneratedKeys();
if(genKeys.next()){
u.setId(genKeys.getInt(1));
}
}catch(Exception ex) {
System.err.println(ex);
b = false;
}
return b;
}
@Override
public boolean removeEmploymentHistory(int id) {
Connection conn;
try{
conn = connect();
Statement stmt = conn.createStatement();
return stmt.execute("DELETE FROM employment_history  WHERE id=" + id);
}catch(Exception ex) {
return false;
}
}
}