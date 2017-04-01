package com.ceok.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceok.configuration.Logger;

@Component
public class DBOperation implements IDBOperation {
	
	private Connection conn = null;	
	private static final String	MODULE = "DB-OPERATION";
	private int dbQueryTimeout	= 60000;
	private static final String SELECT = "SelectQuery>>[";
	private static final String UPDATE = "UpdateQuery>>[";
	private static final String DELETE = "DeleteQuery>>[";
	private static final String INSERT = "InsertQuery>>[";
	
	public DBOperation() throws FileNotFoundException, IOException {
	    	conn = ConnectionProvider.getConnection();
	}
	@Override
	public List<Map<String, Object>> select(String selectQuery, Object[] objects) {
		PreparedStatement psForselect = null;
		ResultSet rsForselect = null;
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Map<String, Object> row = null;
		
		try {
			psForselect = conn.prepareStatement(selectQuery);
			if (objects != null) {

				for (int i = 0; i < objects.length; i++) {
					Object object = objects[i];
					if (object != null && object instanceof String) {
						psForselect.setString(i + 1, String.valueOf(object));
					} else if (object != null && object instanceof Integer) {
						psForselect.setInt(i + 1, Integer.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Long) {
						psForselect.setLong(i + 1, Long.valueOf(String.valueOf(object)));

					} else if (object != null && object instanceof Float) {
						psForselect.setFloat(i + 1, Float.valueOf(String.valueOf(object)));

					} else if (object != null && object instanceof Double) {
						psForselect.setDouble(i + 1, Double.valueOf(String.valueOf(object)));

					} else if (object != null && object instanceof Timestamp) {
						psForselect.setTimestamp(i + 1, (Timestamp) object);
					}
				}

			}
			psForselect.setQueryTimeout(dbQueryTimeout);

			Logger.logInfo(MODULE, "Entered execute method of " + getClass().getName());
			Logger.logDebug(MODULE, SELECT + psForselect.toString().split(":")[1] + "]");

			long queryExecutionTime = System.currentTimeMillis();
			rsForselect = psForselect.executeQuery();

			queryExecutionTime = System.currentTimeMillis() - queryExecutionTime;
			Logger.logDebug(MODULE, "Last Query execution time: " + queryExecutionTime + " ms");

			ResultSetMetaData metaData = rsForselect.getMetaData();
			Integer columnCount = metaData.getColumnCount();
			while (rsForselect.next()) {
				row = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					row.put(metaData.getColumnName(i), rsForselect.getObject(i));
				}
				resultList.add(row);
			}
		}catch (Exception e) {
			Logger.logTrace(MODULE, e);
			Logger.logError(MODULE, "Error while fetching data. Reason : " + e.getMessage());
		} finally {
			if (psForselect != null) {
				try {
					psForselect.close();
				} catch (SQLException e) {
					Logger.logTrace(MODULE, e.toString());
				}
			}
		}
		return resultList;
	}

	@Override
	public int insert(String insertQuery, Object[] objects) {
		
		PreparedStatement psForInsert = null;
		int uffectedRows = 0;

		try {
			psForInsert = conn.prepareStatement(insertQuery);
			
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					Object object = objects[i];
					if (object != null && object instanceof String) {
						psForInsert.setString(i + 1, String.valueOf(object));
					} else if (object != null && object instanceof Integer) {
						psForInsert.setInt(i + 1, Integer.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Long) {
						psForInsert.setLong(i + 1, Long.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Float) {
						psForInsert.setFloat(i + 1, Float.valueOf(String.valueOf(object)));

					} else if (object != null && object instanceof Double) {
						psForInsert.setDouble(i + 1, Double.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Timestamp) {
						psForInsert.setTimestamp(i + 1, (Timestamp) object);

					} else if (object != null && object instanceof Boolean) {
						psForInsert.setBoolean(i + 1, (Boolean) object);
					}
				}
			}
			psForInsert.setQueryTimeout(dbQueryTimeout);
			Logger.logDebug(MODULE, INSERT + psForInsert.toString().split(":", 2)[1] +"]");

			long queryExecutionTime = System.currentTimeMillis();
			uffectedRows = psForInsert.executeUpdate();
			queryExecutionTime = System.currentTimeMillis() - queryExecutionTime;
			Logger.logDebug(MODULE, "Last Query execution time: " + queryExecutionTime + " ms");

		} catch (SQLException sqlEx) {
			Logger.logTrace(MODULE, "SQL Error while inserting data. Reason : " + sqlEx.getMessage());
			Logger.logTrace(MODULE, sqlEx);
		} catch (Exception e) {
			Logger.logTrace(MODULE, e);
			Logger.logTrace(MODULE, "Error while inserting data. Reason : " + e.getMessage());
		} finally {
			if (psForInsert != null) {
				try {
					psForInsert.close();
				} catch (SQLException e) {
					Logger.logTrace(MODULE, e.toString());
				}
			}
		}
		return uffectedRows;
	}

	@Override
	public int update(String updateQuery, Object[] objects) {
		PreparedStatement psForUpdate = null;
		int uffectedRows = 0;

		try {
			psForUpdate = conn.prepareStatement(updateQuery);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					Object object = objects[i];
					if (object != null && object instanceof String) {
						psForUpdate.setString(i + 1, String.valueOf(object));
					} else if (object != null && object instanceof Integer) {
						psForUpdate.setInt(i + 1, Integer.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Long) {
						psForUpdate.setLong(i + 1, Long.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Float) {
						psForUpdate.setFloat(i + 1, Float.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Double) {
						psForUpdate.setDouble(i + 1, Double.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Timestamp) {
						psForUpdate.setTimestamp(i + 1, (Timestamp) object);
					}
				}
			}
			psForUpdate.setQueryTimeout(dbQueryTimeout);
			Logger.logDebug(MODULE, UPDATE  + psForUpdate.toString().split(":", 2)[1] +"]");

			long queryExecutionTime = System.currentTimeMillis();
			uffectedRows = psForUpdate.executeUpdate();
			queryExecutionTime = System.currentTimeMillis() - queryExecutionTime;
			Logger.logDebug(MODULE, "Last Query execution time: " + queryExecutionTime + " ms");

		}  catch (Exception e) {
			Logger.logTrace(MODULE, e);
			Logger.logTrace(MODULE, "Error while updating data. Reason : " + e.getMessage());
		} finally {
			if (psForUpdate != null) {
				try {
					psForUpdate.close();
				} catch (SQLException e) {
					Logger.logTrace(MODULE, e.toString());
				}
			}
		}
		return uffectedRows;
	}

@Override
public int delete(String deleteQuery, Object[] objects) {
		PreparedStatement psForDelete = null;
		int uffectedRows = 0;
		try {
			psForDelete = conn.prepareStatement(deleteQuery);
			
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					Object object = objects[i];
					if (object != null && object instanceof String) {
						psForDelete.setString(i + 1, String.valueOf(object));
					} else if (object != null && object instanceof Integer) {
						psForDelete.setInt(i + 1, Integer.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Long) {
						psForDelete.setLong(i + 1, Long.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Float) {
						psForDelete.setFloat(i + 1, Float.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Double) {
						psForDelete.setDouble(i + 1, Double.valueOf(String.valueOf(object)));
					} else if (object != null && object instanceof Date) {
						psForDelete.setDate(i + 1, (Date) object);
					}
				}
			}
			psForDelete.setQueryTimeout(dbQueryTimeout);
			Logger.logDebug(MODULE, DELETE + psForDelete.toString().split(":", 2)[1] + "]");

			long queryExecutionTime = System.currentTimeMillis();
			uffectedRows = psForDelete.executeUpdate();
			queryExecutionTime = System.currentTimeMillis() - queryExecutionTime;
			Logger.logDebug(MODULE, "Last Query execution time: " + queryExecutionTime + " ms");
			
		} catch (Exception e) {
			Logger.logTrace(MODULE, e);
			Logger.logError(MODULE, "Error while deleting data. Reason : " + e.getMessage());
		} finally {
			if (psForDelete != null) {
				try {
					psForDelete.close();
				} catch (SQLException e) {
					Logger.logDebug(MODULE, e.toString());
				}
			}
		}
		return uffectedRows;
	}

@Override
public boolean lockTable(String lockQuery) {
	// TODO Auto-generated method stub
	return false;
}
}
/*	
 * @Override
 * public boolean lockTable(String lockQuery) {
		PreparedStatement psForLock = null;
		boolean uffectedRows = false;

		Transaction transaction = null;
		try {
			TransactionFactory transactionFactory = DialerCenterDBConnectionManager.getInstance()
					.getTransactionFactory();

			if (transactionFactory.isAlive() == false) {
				if (LogManager.getLogger().isLogLevel(LogLevel.WARN))
					LogManager.getLogger().warn(MODULE, "Operation Failed. Reason: Server DB is down");
				return false;
			}

			transaction = transactionFactory.createTransaction();
			transaction.begin();

			psForLock = transaction.prepareStatement(lockQuery);

			psForLock.setQueryTimeout(dbQueryTimeout);

			long queryExecutionTime = System.currentTimeMillis();
			uffectedRows = psForLock.execute();
			queryExecutionTime = System.currentTimeMillis() - queryExecutionTime;

			if (LogManager.getLogger().isLogLevel(LogLevel.WARN)) {
					LogManager.getLogger().warn(MODULE, "DB Query execution time is high while deleting data. "
							+ "Last Query execution time: " + queryExecutionTime + " ms");
			}
			transaction.commit();
		} catch (TransactionException ex) {
			if (ex.getErrorCode() == TransactionErrorCode.CONNECTION_NOT_FOUND) {
				LogManager.getLogger()
						.warn(MODULE, "Unable to delete data from Server Database. Reason: Connection not available");
			}
			if (LogManager.getLogger().isLogLevel(LogLevel.ERROR))
				LogManager.getLogger().error(MODULE, "No connection available while deleting data in server database");

			LogManager.getLogger().trace(MODULE, ex);

		} catch (SQLException sqlEx) {
			if (transaction != null) {
				if (transaction.isDBDownSQLException(sqlEx)) {
					transaction.markDead();
				}
			}
			getLogger().error(MODULE, "SQL Error while deleting data. Reason : " + sqlEx.getMessage());
			getLogger().trace(MODULE, sqlEx);
		} catch (Exception e) {
			getLogger().trace(MODULE, e);
			getLogger().error(MODULE, "Error while deleting data. Reason : " + e.getMessage());
		} finally {
			if (psForLock != null) {
				try {
					psForLock.close();
				} catch (SQLException e) {
					LogManager.getLogger().trace(MODULE, e.toString());
				}
			}
			if (transaction != null) {
				try {
					transaction.end();
				} catch (TransactionException e) {
					LogManager.getLogger().trace(MODULE, e.toString());
				}
			}
		}

		return !uffectedRows;
	}

}*/
