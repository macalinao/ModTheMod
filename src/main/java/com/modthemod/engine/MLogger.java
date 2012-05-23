package com.modthemod.engine;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.modthemod.api.ModTheMod;

/**
 * Easy logging.
 */
public final class MLogger {
	private MLogger() {
	}

	/**
	 * Logs some info.
	 * 
	 * @param msg
	 */
	public static void info(String msg) {
		getLogger().log(Level.INFO, msg);
	}

	/**
	 * Gets the logger.
	 * 
	 * @return
	 */
	public static Logger getLogger() {
		return ModTheMod.getGame().getLogger();
	}

	/**
	 * Logs a message to the console.
	 * 
	 * @param level
	 * @param string
	 * @param ex
	 */
	public static void log(Level level, String string, Throwable ex) {
		getLogger().log(level, string, ex);
	}
}
