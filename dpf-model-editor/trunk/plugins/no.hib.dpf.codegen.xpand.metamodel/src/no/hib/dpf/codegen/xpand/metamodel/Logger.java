package no.hib.dpf.codegen.xpand.metamodel;

import java.util.HashMap;

//Wrapper class
public class Logger {
	
	private static enum LogLevel {DEBUG, INFO, WARN, ERROR};
	
	protected static LogLevel LOG_LEVEL = LogLevel.INFO;
	
	private static HashMap<String, Logger> instances = new HashMap<String, Logger>();
	
	private String name;
	
	public static Logger getLogger(Class clazz) {
		if(instances.get(clazz.getName()) == null) {
			instances.put(clazz.getName(), new Logger(clazz.getName()));
		} 
		return instances.get(clazz.getName());
	}
	
	private Logger(String name) {
		this.name = name;
	}
	
	public void warn(String msg) {
		if(LOG_LEVEL.ordinal() <= LogLevel.WARN.ordinal())
			System.out.println("[WARN]" + name + ": " + msg);
	}
	
	public void debug(String msg) {
		if(LOG_LEVEL.ordinal() <= LogLevel.DEBUG.ordinal())
			System.out.println("[DEBUG]" + name + ": " + msg);
	}
	
	public void info(String msg) {
		if(LOG_LEVEL.ordinal() <= LogLevel.INFO.ordinal())
			System.out.println("[INFO]" + name + ": " + msg);
	}
	
	public void error(String msg) {
		if(LOG_LEVEL.ordinal() <= LogLevel.ERROR.ordinal())
			System.err.println("[ERROR]" + name + ": " + msg);
	}
	
	public void error(String msg, Throwable t) {
		if(LOG_LEVEL.ordinal() <= LogLevel.ERROR.ordinal()) {
			System.err.println("[ERROR]" + name + ": " + msg);
			t.printStackTrace();
		}
	}
	
	public void debug(String msg, Throwable t) {
		if(LOG_LEVEL.ordinal() <= LogLevel.DEBUG.ordinal()) {
			System.out.println("[DEBUG]" + name + ": " + msg);
			t.printStackTrace();
		}
	}
}
