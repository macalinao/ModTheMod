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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.thedevteam.modthemod.MLogger;

/**
 * Represents the description of a mod.
 */
public class ModDescription {

    private final String description;

    private final String version;

    private final String author;

    private final List<String> authors;

    private final String url;

    public ModDescription(String description, String version, String author, List<String> authors, String url) {
        this.description = description;
        this.version = version;
        this.author = author;
        this.authors = authors;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getUrl() {
        return url;
    }

    /**
     * Loads a {@link ModDescripton} from data.
     * 
     * @param data The data to load the {@link ModDescripton} from.
     * @return The loaded {@link ModDescripton}.
     */
    public static ModDescription load(Map<String, Object> data) {
        String description = "Default description.";
        try {
            description = (String) data.get("description");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.WARNING, "The field \'description\' in a mod was not a String.", ex);
        }

        String version = "Unspecified";
        try {
            version = (String) data.get("version");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.WARNING, "The field \'version\' in a mod was not a String.", ex);
        }

        String author = "Unknown";
        try {
            version = (String) data.get("author");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.FINE, "The field \'author\' in a mod was not a String.", ex);
        }

        List<String> authors = new ArrayList<String>();
        try {
            version = (String) data.get("authors");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.FINE, "The field \'authors\' in a mod was not a String.", ex);
        }

        String url = "Unspecified";
        try {
            version = (String) data.get("url");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.FINE, "The field \'url\' in a mod was not a String.", ex);
        }

        return new ModDescription(description, version, author, authors, url);
    }

}
