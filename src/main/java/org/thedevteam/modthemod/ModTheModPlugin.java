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
package org.thedevteam.modthemod;

import org.spout.api.plugin.CommonPlugin;
import static org.thedevteam.modthemod.MLogger.info;

/**
 * ModTheMod main plugin file.
 */
public class ModTheModPlugin extends CommonPlugin {

    private ModManager modManager;

    @Override
    public void onEnable() {
        //Setup logging
        MLogger.setLogger(getLogger());

        //Start enabling
        info("=============== MOD THE MOD ===============");
        info("=== Setting up the mod manager...");
        modManager = new ModManager(this);
        info("=========== MOD THE MOD ENABLED! ==========");
        //Stop enabling
    }

    @Override
    public void onDisable() {
        //Start disabling
        info("=============== MOD THE MOD ===============");
        info("========== MOD THE MOD DISABLED! ==========");
        //Stop disabling

        //Unload logging.
        MLogger.setLogger(null);
    }

    public ModManager getModManager() {
        return modManager;
    }

}
