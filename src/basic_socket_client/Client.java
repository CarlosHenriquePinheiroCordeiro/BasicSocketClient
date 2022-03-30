package basic_socket_client;

import java.net.Socket;

/**
 * The Client class, containing Client creation, returning and settings
 * @author CarlosHenriquePinheiroCordeiro
 * @since 29/03/2022
 */
public class Client {
	
	/**
	 * The connection to server instance (Singleton)
	 */
	private static Socket connection = null;
	
	/**
	 * Server IP connection attribute
	 */
	private static String ip = "127.0.0.1";
	
	/**
	 * Server Port connection attribute
	 */
	private static int port = 3334;
	
	/**
	 * Returns the connection instance
	 * @return Socket
	 */
	public static Socket getInstance() {
		if (connection == null) {
			createConnection();
		}
		return connection;
	}
	
	/**
	 * Create and initialize the Client connection to the Server
	 */
	private static void createConnection() {
		try {
			connection = new Socket(ip, port);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		Client.ip = ip;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		Client.port = port;
	}

}
