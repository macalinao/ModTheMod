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

import com.google.common.base.Charsets;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import com.modthemod.modthemod.mod.Mod;
import com.modthemod.modthemod.mod.ModLoader;
import com.modthemod.modthemod.mod.ModLanguage;

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
            
            //Define mod
            scope.put("defineMod", scope, new Callable() {

                @Override
                public Object call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
                    if (args.length < 1) {
                        return false;
                    }
                    
                    if (!(args[0] instanceof Scriptable)) {
                        return false;
                    }
                    
                    Scriptable modData = (Scriptable) args[0];
                    
                    //Name
                    Object nameObj = modData.get("name", modData);
                    if (nameObj == null) {
                        return false;
                    }
                    String name = nameObj.toString();
                    
                    //Description
                    Object descObj = modData.get("description", modData);
                    if (!(descObj instanceof Scriptable)) {
                        return false;
                    }
                    Scriptable desc = (Scriptable) descObj;
                    
                    
                    
                    //Parts
                    
                    return null;
                }

            });

            //Evaluate
            cx.evaluateString(scope, js, "<mod>", 1, null);
        } finally {
            Context.exit();
        }

        return null;
    }

    @Override
    public final ModLanguage getType() {
        return ModLanguage.JAVASCRIPT;
    }

}
