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
package com.modthemod.modthemod;

import com.modthemod.modthemod.mod.ModManager;

/**
 * ModTheMod API.
 */
public class ModTheMod {

    /**
     * The instance of the {@link ModTheModCore} to use.
     */
    private static ModTheModCore instance;

    /**
     * Default constructor to prevent creation of this class.
     */
    private ModTheMod() {
    }

    /**
     * Sets the {@link ModTheModCore} to use.
     *
     * @param core The {@link ModTheModCore} to use.
     */
    static void setCore(ModTheModCore core) {
        instance = core;
    }

    /**
     * Gets the {@link ModTheModCore} currently in use.
     *
     * @return The {@link ModTheModCore} currently in use.
     */
    private static ModTheModCore getCore() {
        return instance;
    }

    /**
     * Gets the {@link ModManager}.
     *
     * @return The {@link ModManager}.
     */
    public static ModManager getModManager() {
        return getCore().getModManager();
    }

}
