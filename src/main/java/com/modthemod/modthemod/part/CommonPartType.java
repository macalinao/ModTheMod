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

import com.modthemod.modthemod.mod.Description;
import com.modthemod.modthemod.mod.ModLanguage;

/**
 * Base class for PartTypes.
 */
public class CommonPartType implements PartType {

    private final ModLanguage language;

    private final String name;

    private final Description description;

    /**
     * Creates a CommonPartType.
     *
     * @param name The name of the part type. It should only consist of
     * alphanumeric characters and spaces.
     */
    public CommonPartType(ModLanguage language, String name, Description description) {
        this.language = language;
        this.name = name;
        this.description = description;
    }

    @Override
    public ModLanguage getLanguage() {
        return language;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Description getDescription() {
        return description;
    }

}
