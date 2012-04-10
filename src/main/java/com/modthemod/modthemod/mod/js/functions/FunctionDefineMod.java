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
package com.modthemod.modthemod.mod.js.functions;

import com.modthemod.modthemod.mod.Description;
import com.modthemod.modthemod.mod.js.JSModLoader;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/**
 * Javascript function that defines a mod. <p> The argument to this function is
 * a Javascript object that consists of three parts: the name, the description,
 * and the parts. </p>
 *
 * <p><strong>The name</strong> is defined as a simple mapping as so:
 * <code>name: "the name"</code>. </p>
 *
 * <p><strong>The description</strong> is a Javascript object which is defined
 * with four attributes:
 *
 * <ul><li><strong>The description</strong>, which is simply a string of text
 * that provides general information about the mod, </li><li><strong>The
 * author</strong>, which is the handle of the person or organization who wrote
 * the mod,</li><li><strong>The version</strong>, an integer which tells what
 * revision the mod is currently on, and</li> <li><strong>The url</strong>,
 * which is a link to the homepage of the mod if any.</li> </ul></p>
 *
 * <p><strong>The parts</strong> is probably the most complex of the three. It
 * consists of multiple "parts", which are basically components that make up the
 * mod. These parts can range from listeners, to blocks, to items, to commands.
 * Parts are what make up the logic of the plugin and provide the mod's
 * functionality in the game. </p>
 */
public class FunctionDefineMod implements Callable {

    private final JSModLoader loader;

    public FunctionDefineMod(JSModLoader loader) {
        this.loader = loader;
    }

    @Override
    public Object call(Context cx, Scriptable scope, Scriptable thisObj, Object[] args) {
        if (args.length < 1) {
            return false;
        }

        if (!( args[0] instanceof Scriptable )) {
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
        if (!( descObj instanceof Scriptable )) {
            return false;
        }
        Scriptable descS = (Scriptable) descObj;
        Description desc = loader.loadDescription(descS);

        //Parts

        return null;
    }

}
