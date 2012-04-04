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

import java.util.List;

/**
 * Represents the description of a mod.
 */
public abstract class ModDescription {
    private final String name;

    private String description;

    private String version;

    private String author;

    private List<String> authors;

    public ModDescription(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

}
