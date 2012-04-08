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
import org.thedevteam.modthemod.mod.ModLanguage;

/**
 * Represents a type of {@link Part}.
 */
public interface PartType {

    /**
     * Gets the language this {@link PartType} was written in.
     *
     * @return The language this {@link PartType} was written in.
     */
    public ModLanguage getLanguage();

    /**
     * Gets the name of the part type.
     *
     * @return The name of the part type.
     */
    public String getName();

    /**
     * Gets the description of the part type.
     *
     * @return The description of the part type.
     */
    public Description getDescription();

}
