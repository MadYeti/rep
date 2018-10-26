package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	
	private String url = "jdbc:mysql://localhost/apps";
	private String username = "";
	private String password = "root";
	private String[] data = new String[10];
	
	// method to get connection to DB
	
	public void getDataBaseConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("Unable to load driver");
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(url, password, username);
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			e.printStackTrace();
		}
		
		if(connection != null) {
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				System.out.println("Unable to create Statement");
				e.printStackTrace();
			}
		}
		
	}
	
	/* method to get data from database; it fills up the data[] with the
	 * value of column that transmit to the method as a parameter 
	 */
	
	public String[] getDataFromDB(String column) {
		
		if(statement != null) {
			try {
				resultSet = statement.executeQuery("SELECT * FROM records");
			} catch (SQLException e) {
				System.out.println("Unable to create resultSet");
				e.printStackTrace();
			}
		}
		
		if(resultSet != null) {
			int i = 0;
			try {
				while(resultSet.next()) {
					data[i] = resultSet.getString(column);
					i++;
				}
			} catch (SQLException e) {
				System.out.println("Unable to iterate over resultset");
				e.printStackTrace();
			}
		}
		return data;
	}

	public void addResultToDB(int steps, String nickname) {
		
		if(statement != null) {
			try {
				resultSet = statement.executeQuery("SELECT * FROM records");
			} catch (SQLException e) {
				System.out.println("Unable to create resultSet");
				e.printStackTrace();
			}
		}
		
		if(resultSet != null) {
			int tempValue = 0;
			String tempString = null;
			String sql = null;
			int index = 0;
			boolean flag = false;
			try {
				for(int i = 1; i < 11; i++) {
					resultSet.next();
					tempValue = resultSet.getInt("Score");
					if(tempValue == 0) {
						sql = "UPDATE records SET Score = " + steps + ", Nickname = '" + nickname + "' WHERE Position = " + i;
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.executeUpdate();
						break;
					} else if(steps <= tempValue){
						index = i;
						flag = true;
						break;
					}
				}
				if(flag) {
					resultSet.last();
					for(int j = 10; j > index; j--) {
						resultSet.previous();
						tempValue = resultSet.getInt("Score");
						tempString = resultSet.getString("Nickname");
						sql = "UPDATE records SET Score = '" + tempValue + "', Nickname = '" + tempString + "' WHERE Position = " + (j);
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.executeUpdate();
					}
					sql = "UPDATE records SET Score = '" + steps + "', Nickname = '" + nickname + "' WHERE Position = " + index;
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.executeUpdate();
				}
			} catch (SQLException e) {
				System.out.println("Unable to iterate over resultset");
				e.printStackTrace();
			}
		}
		
	}
	
	public void freeDBResources() {
		try {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
			if(preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
