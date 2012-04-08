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
package org.thedevteam.modthemod.mod;

import java.util.Map;
import org.spout.api.Source;
import org.spout.api.util.Named;
import org.thedevteam.modthemod.part.Part;

/**
 * Represents a Mod.
 */
public interface Mod extends Source, Named {

    /**
     * Gets the language the mod was written in.
     *
     * @return The language the mod was written in.
     */
    public ModLanguage getLanguage();

    /**
     * Gets the name of the mod.
     *
     * @return The name of the mod.
     */
    @Override
    public String getName();

    /**
     * Gets the description of the mod.
     *
     * @return The description of the mod.
     */
    public Description getDescription();

    /**
     * Gets the parts of the mod.
     *
     * @return The parts of the mod.
     */
    public Map<String, Part> getParts();

}
