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

    /**
     * The {@link Logger} instance that will be used.
     */
    private static Logger loggerInstance;

    /**
     * Private constructor to prevent instances of this class.
     */
    private MLogger() {
    }

    /**
     * Sets the logger. Internal use only.
     *
     * @param logger The {@link Logger} to use.
     */
    public static void setLogger(final Logger logger) {
        loggerInstance = logger;
    }

    /**
     * Logs info to the console.
     *
     * @param message The message to print to the console with a logging level
     * of "info".
     */
    public static void info(final String message) {
        loggerInstance.log(Level.INFO, message);
    }

    /**
     * Logs a message.
     *
     * @param level The logging level to use for the message.
     * @param message The message to print to the console.
     */
    public static void log(final Level level, final String message) {
        loggerInstance.log(level, message);
    }

    /**
     * Logs a message with a {@link Throwable}.
     *
     * @param level The logging level to use for the message.
     * @param message The message to print to the console.
     * @param cause The cause of the logging.
     */
    public static void log(final Level level, final String message, final Throwable cause) {
        loggerInstance.log(level, message, cause);
    }

}
