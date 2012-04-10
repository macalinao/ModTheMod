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
package com.modthemod.modthemod.mod.js;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.mozilla.javascript.Scriptable;
import com.modthemod.modthemod.MLogger;
import com.modthemod.modthemod.mod.Description;

/**
 * Loads Javascript {@link Description} objects from their {@link Scriptable}
 * description object.
 */
public class JSDescriptionLoader {

    /**
     * Loads the {@link Description} from its {@link Scriptable} object.
     *
     * @param descriptionObject The {@link Scriptable} to load.
     * @return The {@link Description} loaded.
     */
    public static Description load(Scriptable descriptionObject) {
        if (!(descriptionObject instanceof Map)) {
            MLogger.log(Level.WARNING, "Invalid description to parse for a mod! (Not a Javascript object!)");
            return null;
        }
        Map<String, Object> data = (Map<String, Object>) descriptionObject;

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
            author = (String) data.get("author");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.FINE, "The field \'author\' in a mod was not a String.", ex);
        }

        List<String> authors = new ArrayList<String>();
        try {
            authors = (List<String>) data.get("authors");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.FINE, "The field \'authors\' in a mod was not a String.", ex);
        }

        String url = "Unspecified";
        try {
            url = (String) data.get("url");
        } catch (NullPointerException ex) {
        } catch (ClassCastException ex) {
            MLogger.log(Level.FINE, "The field \'url\' in a mod was not a String.", ex);
        }

        return new Description(description, version, author, authors, url);
    }

}
