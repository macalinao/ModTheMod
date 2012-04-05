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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.thedevteam.modthemod.mod.Mod;

/**
 * Manages our mods.
 */
public class ModManager {

    private final ModTheModPlugin plugin;

    private final Map<String, Mod> names = new HashMap<String, Mod>();

    private List<Mod> mods = new ArrayList<Mod>();

    public ModManager(ModTheModPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Registers an arbitrary mod with the mod manager.
     * 
     * @param mod The mod to register.
     */
    public void registerMod(Mod mod) {
        names.put(mod.getName(), mod);
        mods.add(mod);
    }

}
