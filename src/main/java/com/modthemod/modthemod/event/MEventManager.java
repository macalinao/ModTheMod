package com.modthemod.modthemod.event;

import com.modthemod.api.event.EventManager;
import com.modthemod.api.event.EventType;
import com.modthemod.api.mod.Mod;
import com.modthemod.modthemod.MGame;

public class MEventManager implements EventManager {
	private final MGame game;

	public MEventManager(MGame game) {
		this.game = game;
	}

	@Override
	public void registerEvent(EventType type, Mod mod) {
		// TODO Auto-generated method stub

	}

	@Override
	public EventType getEvent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
