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

import java.util.regex.Pattern;

/**
 * Base class for PartTypes.
 */
public class CommonPartType implements PartType {

    private final String name;

    /**
     * Creates a CommonPartType.
     *
     * @param name The name of the part type. It should only consist of
     * alphanumeric characters and spaces.
     */
    public CommonPartType(String name) {
        if (!name.matches("[A-Za-z0-9 ]+")) {
            throw new IllegalArgumentException("Invalid part name '" + name + "'!");
        }
        this.name = name;
    }

    @Override
    public String getId() {
        return name.toLowerCase().replace(' ', '-');
    }

    @Override
    public String getName() {
        return name;
    }

}
