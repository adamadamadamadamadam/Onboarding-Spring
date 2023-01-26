package com.example.onboarding.bm.obbm.util;

import com.jcraft.jsch.ChannelSftp;

public class SftpUtil {
	private static int _connectionTimeout = 60000;
	
	private String host;
	private Integer port;
	private String user;
	private String password;
	private byte[] certificateFile;
	private String homePath;
	private int idleTime;
	
	public SftpUtil(String host, String user) {
		this.host = host;
		this.user = user;
		this.password = "";
		this.port = 22;
		this.certificateFile = null;
		this.homePath = "";
		this.idleTime = _connectionTimeout;
	}
	
	public SftpUtil(String host, String user, String password) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.port = 22;
		this.certificateFile = null;
		this.homePath = "";
		this.idleTime = _connectionTimeout;
	}
	
	public SftpUtil(String host, String user, String password, String homepath) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.port = 22;
		this.certificateFile = null;
		this.homePath = homepath;
		this.idleTime = _connectionTimeout;
	}
	
	public SftpUtil(String host, String user, String password, String homepath, byte[] certificateFile) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.port = 22;
		this.certificateFile = certificateFile;
		this.homePath = homepath;
		this.idleTime = _connectionTimeout;
	}
	
}
