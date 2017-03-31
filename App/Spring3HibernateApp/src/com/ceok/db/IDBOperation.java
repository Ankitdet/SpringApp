package com.ceok.db;

import java.util.List;
import java.util.Map;


public interface IDBOperation {
	/**
	 * <p>
	 * This method will execute select query in data base, which you will provide in @param selectQuery.
	 * </p> 
	 * <p>We have created this method for execution of prepared statement so if you have used '?' in your query than 
	 * you need to add value in @param objects array in same sequence
	 * </p>
	 * <p>
	 * If you haven't used any '?' in query than you need to pass null or Array with 0 element.
	 * </p>
	 * <p>
	 * This will return the result in list where size of list is returned rows and inside list you will get Map<String, Object>
	 * where String is column name and Object is value of that column
	 * </p>
	 * 
	 * @param selectQuery
	 * @param objects
	 * @return
	 */
	public List<Map<String, Object>> select(String selectQuery,Object[] objects);
	
	/**
	 * This method will execute insert query in data base which you will provide in @param insertQuery.
	 * <p>
	 * We have created this method for execution of prepared statement so if you have used '?' in your query than 
	 * you need to add value in @param objects array in same sequence
	 * </p>
	 * <p>
	 * If you haven't used any '?' in query than you need to pass null or Array  with 0 element. 
	 * </p>
	 * <p>
	 * This will return affected rows count.
	 * </p>
	 * 
	 * @param insertQuery
	 * @param objects
	 * @return
	 */
	public int insert(String insertQuery,Object[] objects) ;
	
	/**
	 * <p>
	 * This method will execute update query in data base which you will provide in @param updateQuery. 
	 * </p>
	 * <p>
	 * We have created this method for execution of prepared statement so if you have used '?' in your query than 
	 * you need to add value in @param objects array in same sequence
	 * </p>
	 * <p>
	 * If you haven't used any '?' in query than you need to pass null or Array  with 0 element. 
	 * </p>
	 * <p>
	 * This will return affected rows count.
	 * </p>
	 * 
	 * @param updateQuery
	 * @param objects
	 * @return
	 */
	public int update(String updateQuery,Object[] objects);
	
	/**
	 * <p>
	 * This method will execute delete query in data base which you will provide in @param deleteQuery.
	 * </p>
	 * <p>
	 * We have created this method for execution of prepared statement so if you have used '?' in your query than 
	 * you need to add value in @param objects array in same sequence
	 * </p>
	 * <p>
	 * If you haven't used any '?' in query than you need to pass null or Array  with 0 element. 
	 * </p>
	 * <p>
	 * This will return affected rows count.
	 * </p>
	 * @param deleteQuery
	 * @param objects
	 * @return
	 */
	public int delete(String deleteQuery,Object[] objects);
	
	/**
	 * <p>
	 * This method will execute lock/unlock table query in data base which you will provide in @param lockQuery.
	 * </p>
	 * <p>
	 * We have created this method for execution of lock/unlock table
	 * </p>
	 * <p>
	 * This will return boolean count.
	 * </p>
	 * @param lockQuery
	 * @param objects
	 * @return
	 */
	public boolean lockTable(String lockQuery);
}
