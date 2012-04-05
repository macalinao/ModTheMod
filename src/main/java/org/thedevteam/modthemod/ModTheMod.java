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

/**
 * ModTheMod API.
 */
public class ModTheMod {

    private static ModTheModPlugin _plugin;

    static void setPlugin(ModTheModPlugin plugin) {
        _plugin = plugin;
    }

    public static ModTheModPlugin getPlugin() {
        return _plugin;
    }

    public static ModManager getModManager() {
        return getPlugin().getModManager();
    }

}
