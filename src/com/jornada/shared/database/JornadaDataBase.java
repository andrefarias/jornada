package com.jornada.shared.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.jornada.ConfigJornada;


public class JornadaDataBase {
	
	

	   //static final Logger LOG = Logger.getLogger(CockpitDataBase.class);
	   private String driver, url, host, database, userName, password;
	   private Connection connection;
	   private static String DB_SELECT_LAST_RESYNC_TIME = "select Max(start_time) as last_resync_time from exec_log where mode = ? ";
	    private static String DB_INSERT_EXEC_LOG = "INSERT INTO exec_log (start_time, end_time, mode, result,local_Start_time) VALUES(?, ?, ?, ?, ?)";
	   private static final int EXEC_LOG_MODE_RESYNC = 2;


	    public JornadaDataBase()
	    {
	    }




	   public void open()
	    {

	        this.setDriver(ConfigJornada.getProperty("config.driver"));
	        this.setUrl(ConfigJornada.getProperty("config.url"));
	        this.setHost(ConfigJornada.getProperty("config.host"));
	        this.setDatabase(ConfigJornada.getProperty("config.database"));
	        this.setUserName(ConfigJornada.getProperty("config.userName"));
	        this.setPassword(ConfigJornada.getProperty("config.password"));

	        /* Debug */
//	        LOG.debug("driver: " + driver);
//	        LOG.debug("url: " + url);
//	        LOG.debug("host: " + host);
//	        LOG.debug("database: " + database);
	        //LOG.debug("userName: " + userName);
	        //LOG.debug("password: " + password);

	        /* Open the connection */
	        try {
	            Class.forName(driver);
	            this.setConnection(DriverManager.getConnection(getUrl()+getHost()+"/"+getDatabase(), getUserName(), getPassword()));
	        } catch (Exception ex) {
	            StringBuilder strEx = new StringBuilder();

	            strEx.append(ex.getMessage());
	            strEx.append("\n");
	            //strEx.append(StringUtil.stackTraceToString(ex));

	            System.out.println(strEx);
	        }
	    }

	    public void close() {

	        if (this.getConnection() != null) {
	            try {
	                connection.close();
	            } catch (SQLException ex) {
	                StringBuilder strEx = new StringBuilder();

	                strEx.append(ex.getMessage());
	                strEx.append("\n");
	                //strEx.append(StringUtil.stackTraceToString(ex));

	                System.out.println(strEx);
	            }
	        }
	    }





	    public String getDatabase()
	    {
	        return database;
	    }
	    public void setDatabase(String database)
	    {
	        this.database = database;
	    }

	    public String getDriver()
	    {
	        return driver;
	    }
	    public void setDriver(String driver)
	    {
	        this.driver = driver;
	    }

	    public String getHost()
	    {
	        return host;
	    }
	    public void setHost(String host)
	    {
	        this.host = host;
	    }

	    public String getPassword()
	    {
	        return password;
	    }
	    public void setPassword(String password)
	    {
	        this.password = password;
	    }

	    public String getUrl()
	    {
	        return url;
	    }
	    public void setUrl(String url)
	    {
	        this.url = url;
	    }

	    public String getUserName()
	    {
	        return userName;
	    }
	    public void setUserName(String userName)
	    {
	        this.userName = userName;
	    }

	    public Connection getConnection()
	    {
	        return connection;
	    }

	    public void setConnection(Connection connection)
	    {
	        this.connection = connection;
	    }

	

}
