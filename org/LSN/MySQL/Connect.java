package org.LSN.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection con;

	public static void connect() {
		if (!isConnected())
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/server", "admin", "29112005");
				System.out.println("MySQL Connection Successful!");
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

	public static void createTable() {
		if (isConnected())
			try {
				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `banned` ( `id` INT(11) NOT NULL AUTO_INCREMENT ,`name` VARCHAR(100) NOT NULL, `UUID` VARCHAR(100) NOT NULL , `reason` VARCHAR(100) NOT NULL , `ende` VARCHAR(100) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;");
				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS `users` ( `id` INT(11) NOT NULL AUTO_INCREMENT, `name` VARCHAR(100) NOT NULL, `uuid` VARCHAR(100) NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;");
			} catch (SQLException e) {
				e.printStackTrace();

			}
	}

	private static boolean isConnected() {
		return (con != null);
	}
}
