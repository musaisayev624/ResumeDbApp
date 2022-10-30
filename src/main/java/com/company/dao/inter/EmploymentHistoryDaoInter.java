package com.company.dao.inter;
import com.company.entity.EmploymentHistory;
import java.util.List;
/**
 *
 * @author Musaisayev624
 */
public interface EmploymentHistoryDaoInter {
List<EmploymentHistory> getAll();
public EmploymentHistory getById(int id);
public boolean insertEmploymentHistory(EmploymentHistory u);
boolean updateEmploymentHistory(EmploymentHistory u);
boolean removeEmploymentHistory(int id);
}