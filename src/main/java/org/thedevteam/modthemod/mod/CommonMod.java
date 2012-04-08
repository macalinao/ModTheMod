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

import java.util.HashMap;
import java.util.Map;
import org.thedevteam.modthemod.part.Part;

/**
 * Represents a common mod.
 */
public abstract class CommonMod implements Mod {

    private final ModLanguage language;

    private final String name;

    private final Description description;

    private final Map<String, Part> parts;

    protected CommonMod(ModLanguage language, String name, Description description, Map<String, Part> parts) {
        this.language = language;
        this.name = name;
        this.description = description;
        this.parts = parts;
    }

    public ModLanguage getLanguage() {
        return language;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Map<String, Part> getParts() {
        return new HashMap<String, Part>(parts);
    }

}
