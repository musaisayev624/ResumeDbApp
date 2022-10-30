package com.company.main;
import com.company.dao.inter.UserDaoInter;
/**
 *
 * @author Musaisayev624
 */
public class Main {
public static void main(String[] args) throws Exception {
//CountryDaoInter dao=Context.instanceCountryDao();
//System.out.println(dao.getAll());
//SkillDaoInter dao=Context.instanceSkillDao();
//System.out.println(dao.getAll());
//EmploymentHistoryDaoInter dao=Context.instanceEmploymentHistoryDao();
//System.out.println(dao.getAllEmploymentHistoryByUserId(6));
UserDaoInter dao=Context.instanceUserDao();
System.out.println(dao.getAll());
//UserSkillDaoInter dao=Context.instanceUserSkillDao();
//System.out.println(dao.getAllSkillByUserId(6));
}
}
