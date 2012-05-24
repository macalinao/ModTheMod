package com.modthemod.engine.entity;

import com.modthemod.api.entity.EntityManager;
import com.modthemod.engine.MGame;

/**
 * The entity manager.
 */
public class MEntityManager implements EntityManager {
	private final MGame game;

	public MEntityManager(MGame game) {
		this.game = game;
	}
}
