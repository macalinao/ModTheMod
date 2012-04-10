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
package com.modthemod.modthemod.part;

/**
 * Represents a part.
 */
public interface Part {

    /**
     * Gets the id of the part.
     *
     * @return The id of the part.
     */
    public String getId();

    /**
     * Gets the type of the part.
     *
     * @return The type of the part.
     */
    public PartType getType();

    /**
     * Gets the properties of the part.
     *
     * @return The properties of the part.
     */
    public PartProperties getProperties();

    /**
     * Gets the handlers of the part.
     *
     * @return The handlers of the part.
     */
    public PartHandlers getHandlers();

}
