package com.modthemod.engine.mod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.modthemod.api.mod.Mod;
import com.modthemod.api.mod.ModLoader;
import com.modthemod.api.mod.ModManager;

public class MModManager implements ModManager {
	private List<ModLoader> loaders = new ArrayList<ModLoader>();

	private Map<String, Mod> mods = new HashMap<String, Mod>();

	@Override
	public Mod getMod(String name) {
		return mods.get(name.toLowerCase());
	}

	@Override
	public List<Mod> getMods() {
		return new ArrayList<Mod>(mods.values());
	}

	@Override
	public void registerModLoader(ModLoader loader) {
		loaders.add(loader);
	}

}
