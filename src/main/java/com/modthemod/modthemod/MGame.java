package com.modthemod.modthemod;

import com.modthemod.api.Game;
import com.modthemod.api.platform.Platform;
import com.modthemod.modthemod.entity.MEntityManager;
import com.modthemod.modthemod.event.MEventManager;
import com.modthemod.modthemod.property.MTypeManager;

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

	private final MTypeManager typeManager;

	public MGame(Platform platform) {
		this.platform = platform;

		this.entityManager = new MEntityManager(this);
		this.eventManager = new MEventManager(this);
		this.typeManager = new MTypeManager(this);
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
	public MTypeManager getTypeManager() {
		return typeManager;
	}

}
