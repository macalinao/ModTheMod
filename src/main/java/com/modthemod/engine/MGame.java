package com.modthemod.engine;

import static com.modthemod.engine.MLogger.info;

import java.util.logging.Logger;

import com.modthemod.api.Game;
import com.modthemod.api.mod.ModManager;
import com.modthemod.api.platform.Platform;
import com.modthemod.engine.entity.MEntityManager;
import com.modthemod.engine.event.MEventManager;
import com.modthemod.engine.mod.MModManager;
import com.modthemod.engine.property.MTypeManager;

/**
 * Represents the game.
 */
public class MGame implements Game {
	/**
	 * The platform of the game.
	 */
	private final Platform platform;

	private final MEntityManager entityManager;

	private final MEventManager eventManager;

	private final MModManager modManager;

	private final MTypeManager typeManager;

	public MGame(Platform platform) {
		this.platform = platform;

		this.entityManager = new MEntityManager(this);
		this.eventManager = new MEventManager(this);
		this.modManager = new MModManager(this);
		this.typeManager = new MTypeManager(this);

		load();
	}

	private void load() {
		info("======== LOADING... ========");
		// TODO cool stuff, like loading the mods
		info("=== MOD THE MOD LOADED ! ===");
	}

	@Override
	public Platform getPlatform() {
		return platform;
	}

	@Override
	public MEntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public MEventManager getEventManager() {
		return eventManager;
	}

	@Override
	public ModManager getModManager() {
		return modManager;
	}

	@Override
	public MTypeManager getTypeManager() {
		return typeManager;
	}

	@Override
	public Logger getLogger() {
		return platform.getLogger();
	}

}
