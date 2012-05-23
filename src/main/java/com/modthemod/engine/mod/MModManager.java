package com.modthemod.engine.mod;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.modthemod.api.mod.Mod;
import com.modthemod.api.mod.ModLoader;
import com.modthemod.api.mod.ModManager;
import com.modthemod.api.mod.java.JavaModLoader;
import com.modthemod.engine.MGame;
import com.modthemod.engine.MLogger;

public final class MModManager implements ModManager {
	private final MGame game;

	private final Set<ModLoader<?>> loaders = new HashSet<ModLoader<?>>();

	private final Map<String, Mod> mods = new HashMap<String, Mod>();

	private final Map<Pattern, ModLoader<?>> filters = new HashMap<Pattern, ModLoader<?>>();

	public MModManager(MGame game) {
		this.game = game;
	}

	@Override
	public Mod getMod(String name) {
		return mods.get(name.toLowerCase());
	}

	@Override
	public Set<Mod> getMods() {
		return new HashSet<Mod>(mods.values());
	}

	@Override
	public void registerModLoader(ModLoader<?> loader) {
		loaders.add(loader);
		for (Pattern p : loader.getFileFilters()) {
			filters.put(p, loader);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Mod> void enableMod(T mod) {
		ModLoader<T> loader = (ModLoader<T>) mod.getModLoader();
		try {
			loader.enableMod(mod);
		} catch (Throwable ex) {
			MLogger.log(Level.SEVERE,
					"Error while enabling " + loader.getLanguage() + " mod '"
							+ mod.getName() + "'. (Is it up to date?)", ex);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Mod> void disableMod(T mod) {
		ModLoader<T> loader = (ModLoader<T>) mod.getModLoader();
		try {
			loader.disableMod(mod);
		} catch (Throwable ex) {
			MLogger.log(Level.SEVERE,
					"Error while disabling " + loader.getLanguage() + " mod '"
							+ mod.getName() + "'. (Is it up to date?)", ex);
		}
	}

	/**
	 * Loads mods in the given directory.
	 * 
	 * @param directory
	 *            The directory to load mods from.
	 * @return
	 */
	public Set<Mod> loadMods(File directory) {
		if (!directory.isDirectory()) {
			throw new IllegalArgumentException(
					"Specified mod directory is not a directory!");
		}

		Set<Mod> result = new HashSet<Mod>();

		for (File file : directory.listFiles()) {
			ModLoader<?> loader = null;

			for (Entry<Pattern, ModLoader<?>> entry : filters.entrySet()) {
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
			result.add(mod);
		}

		return result;
	}

	/**
	 * Load up 'dem loaders. Enable them too.
	 */
	public void loadLoaders() {
		// Java mod loaders
		JavaModLoader javaModLoader = new JavaModLoader();
		registerModLoader(javaModLoader);

		// Load the loaders; ensure all mods are able to be loaded.
		File loadersFolder = game.getPlatform().getFileHierarchy()
				.getLoadersFolder();
		Set<Mod> loaderMods = loadMods(loadersFolder);
		for (Mod loader : loaderMods) {
			try {
				MLogger.info("Loading loader: " + loader.getName());
				loader.onLoad();
			} catch (Throwable ex) {
				MLogger.log(Level.SEVERE,
						"Error initializing loader " + loader.getName()
								+ "! (Is the loader up to date?)", ex);
			}
		}

		for (Mod mod : loaderMods) {
			enableMod(mod);
		}
	}

	/**
	 * Load up the mods.
	 */
	public void loadMods() {
		File modsFolder = game.getPlatform().getFileHierarchy().getModsFolder();
		Set<Mod> mods = loadMods(modsFolder);
		for (Mod mod : mods) {
			try {
				MLogger.info("Loading mod: " + mod.getName());
				mod.onLoad();
			} catch (Throwable ex) {
				MLogger.log(Level.SEVERE,
						"Error initializing mod " + mod.getName()
								+ "! (Is the mod up to date?)", ex);
			}
		}
	}

	/**
	 * Enable all of the mods.
	 */
	public void enableMods() {
		for (Mod mod : mods.values()) {
			enableMod(mod);
		}
	}

	/**
	 * Disable all of the mods.
	 */
	public void disableMods() {
		for (Mod mod : mods.values()) {
			disableMod(mod);
		}
	}
}
