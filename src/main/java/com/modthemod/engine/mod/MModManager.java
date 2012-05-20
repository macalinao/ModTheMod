package com.modthemod.engine.mod;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.modthemod.api.mod.Mod;
import com.modthemod.api.mod.ModLoader;
import com.modthemod.api.mod.ModManager;
import com.modthemod.engine.MGame;

public final class MModManager implements ModManager {
	private final MGame game;

	private final List<ModLoader> loaders = new ArrayList<ModLoader>();

	private final Map<String, Mod> mods = new HashMap<String, Mod>();

	private final Map<Pattern, ModLoader> filters = new HashMap<Pattern, ModLoader>();

	public MModManager(MGame game) {
		this.game = game;
	}

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
		for (Pattern p : loader.getFileFilters()) {
			filters.put(p, loader);
		}
	}

	/**
	 * Loads mods in the given directory.
	 * 
	 * @param directory
	 * @return
	 */
	public List<Mod> loadMods(File directory) {
		if (!directory.isDirectory()) {
			throw new IllegalArgumentException(
					"Specified mod directory is not a directory!");
		}

		List<Mod> modsLoading = new ArrayList<Mod>();

		for (File file : directory.listFiles()) {
			ModLoader loader = null;

			for (Entry<Pattern, ModLoader> entry : filters.entrySet()) {
				Matcher match = entry.getKey().matcher(file.getName());
				if (match.find()) {
					loader = entry.getValue();
					break;
				}
			}

			if (loader == null) {
				continue;
			}

			Mod mod = loader.loadMod(file);
			mods.put(mod.getName(), mod);
		}

		return modsLoading;
	}

}
