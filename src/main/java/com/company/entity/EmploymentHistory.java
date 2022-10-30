package com.company.entity;
import java.sql.Date;
/**
 *
 * @author Musaisayev624
 */
public class EmploymentHistory {
private Integer id;
private String header;
private Date beginDate;
private Date endDate;
private String jobDecription;
private User user;
public EmploymentHistory() {
}
public EmploymentHistory(Integer id, String header, Date beginDate, Date endDate, String jobDecription, User user) {
this.id = id;
this.header = header;
this.beginDate = beginDate;
this.endDate = endDate;
this.jobDecription = jobDecription;
this.user = user;
}
public Integer getId() {
return id;
}
public void setId(Integer id) {
this.id = id;
}
public String getHeader() {
return header;
}
public void setHeader(String header) {
this.header = header;
}
public Date getBeginDate() {
return beginDate;
}
public void setBeginDate(Date beginDate) {
this.beginDate = beginDate;
}
public Date getEndDate() {
return endDate;
}
public void setEndDate(Date endDate) {
this.endDate = endDate;
}
public String getJobDecription() {
return jobDecription;
}
public void setJobDecription(String jobDecription) {
this.jobDecription = jobDecription;
}
public User getUser() {
return user;
}
public void setUser(User user) {
this.user = user;
}
@Override
public String toString() {
return "EmploymentHistory{" + "id=" + id + ", header=" + header + ", beginDate=" + beginDate + ", endDate=" + endDate + ", jobDecription=" + jobDecription + ", user=" + user + '}';
}
}