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
package org.thedevteam.modthemod.part;

import org.thedevteam.modthemod.mod.Description;

/**
 * Represents a part, or a section of a plugin.
 *
 * <p>Parts will generally consist of modules that can be added to the plugin.
 * An example of this would be a Command part which would allow users to create
 * commands via a new part.</p>
 */
public interface PartType {

    /**
     * Gets the id of the part.
     *
     * @return The id of the part.
     */
    public String getId();

    /**
     * Gets the name of the part.
     *
     * @return The name of the part.
     */
    public String getName();

    /**
     * Gets the description of the part.
     *
     * @return The description of the part.
     */
    public Description getDescription();

}
