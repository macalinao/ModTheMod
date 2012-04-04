/*
 * This file is part of ModTheMod.
 *
 * ModTheMod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ModTheMod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with ModTheMod.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.thedevteam.modthemod;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ModTheMod main logger.
 */
public class MLogger {
    private static Logger logger;
    
    /**
     * Sets the logger. Internal use only.
     * 
     * @param logger The {@link Logger} to use.
     */
    static void setLogger(Logger logger) {
        MLogger.logger = logger;
    }
    
    /**
     * Logs info to the console.
     * 
     * @param message 
     */
    public static void info(String message) {
        logger.log(Level.INFO, message);
    }
    
    /**
     * Logs a message.
     * 
     * @param level
     * @param message 
     */
    public static void log(Level level, String message) {
        logger.log(level, message);
    }
    
    /**
     * Logs a message with a {@link Throwable}.
     * 
     * @param level
     * @param message
     * @param cause 
     */
    public static void log(Level level, String message, Throwable cause) {
        logger.log(level, message, cause);
    }
}
