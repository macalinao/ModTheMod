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
package com.modthemod.modthemod.mod;

/**
 * Interface for loading mods.
 */
public interface ModLoader {
    /**
     * Loads a mod from the given data.
     *
     * @param data The data to load from.
     * @return The loaded mod.
     */
    public Mod loadMod(byte[] data);

    /**
     * Gets the type of ModLoader this is.
     * 
     * @return The type of ModLoader.
     */
    public ModLanguage getType();
}
