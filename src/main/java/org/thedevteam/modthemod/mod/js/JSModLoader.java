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

import com.google.common.base.Charsets;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.thedevteam.modthemod.mod.Mod;
import org.thedevteam.modthemod.mod.ModLoader;

/**
 * Represents a Javascript mod loader.
 */
public class JSModLoader implements ModLoader {
    @Override
    public Mod loadMod(byte[] data) {
        String js = new String(data, Charsets.UTF_8);

        try {
            Context cx = Context.enter();
            Scriptable scope = cx.initStandardObjects();

            Object wrappedOut = Context.javaToJS(System.out, scope);
            ScriptableObject.putProperty(scope, "out", wrappedOut);

            //Evaluate
            cx.evaluateString(scope, js, "<mod>", 1, null);
        } finally {
            Context.exit();
        }

        return null;
    }

}
