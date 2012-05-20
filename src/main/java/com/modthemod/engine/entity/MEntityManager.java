package com.modthemod.engine.entity;

import com.modthemod.api.base.Base;
import com.modthemod.api.entity.Entity;
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

	@Override
	public Entity instantiateEntity(Base base, Object... args) {
		// TODO
		return null;
	}

}
