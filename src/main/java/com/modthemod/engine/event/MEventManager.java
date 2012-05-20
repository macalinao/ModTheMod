package com.modthemod.engine.event;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.modthemod.api.event.EventManager;
import com.modthemod.api.event.EventType;
import com.modthemod.api.mod.Mod;
import com.modthemod.engine.MGame;

public class MEventManager implements EventManager {
	private final MGame game;

	private final Map<Mod, Map<String, EventType>> eventTypes = new HashMap<Mod, Map<String, EventType>>();

	private final Map<String, EventType> eventTypeNames = new HashMap<String, EventType>();

	public MEventManager(MGame game) {
		this.game = game;
	}

	@Override
	public void registerEvent(EventType type) {
		Map<String, EventType> map = getEventMap(type.getMod());
		EventType now = map.get(type.getName());
		if (now != null) {
			game.getLogger().log(
					Level.WARNING,
					"EventType '" + type.getName()
							+ "' already exists! Be careful!!!");
		}
		map.put(type.getName(), type);

		// Now the name
		eventTypeNames
				.put(type.getMod().getName() + ":" + type.getName(), type);
	}

	@Override
	public EventType getEvent(String name) {
		return eventTypeNames.get(name.toLowerCase());
	}

	/**
	 * Gets the EventType map for the given mod.
	 * 
	 * @param mod
	 * @return
	 */
	private Map<String, EventType> getEventMap(Mod mod) {
		Map<String, EventType> map = eventTypes.get(mod);
		if (map == null) {
			map = new HashMap<String, EventType>();
			eventTypes.put(mod, map);
		}
		return map;
	}

}
