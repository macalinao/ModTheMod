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
package org.thedevteam.modthemod.mod.js;

import java.util.Map;
import org.thedevteam.modthemod.ModTheMod;
import org.thedevteam.modthemod.mod.ModDescription;
import org.thedevteam.modthemod.mod.ModFunctions;

/**
 * Contains mod functions for Javascript.
 */
public class JSModFunctions extends ModFunctions {

    @Override
    public JSMod createMod(String name, Map<String, Object> description) {
        ModDescription desc = ModDescription.load(description);
        JSMod mod = new JSMod(name, desc);
        ModTheMod.getModManager().registerMod(mod);
        return mod;
    }
    
}
