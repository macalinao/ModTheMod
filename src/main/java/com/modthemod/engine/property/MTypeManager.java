package com.modthemod.engine.property;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Pattern;

import com.modthemod.api.base.Base;
import com.modthemod.api.mod.Mod;
import com.modthemod.api.property.Matcher;
import com.modthemod.api.property.Primitive;
import com.modthemod.api.property.Type;
import com.modthemod.api.property.TypeManager;
import com.modthemod.engine.MGame;

public class MTypeManager implements TypeManager {
	private static final Pattern basePattern = Pattern
			.compile("\\(([a-z,]+)\\)");

	private final MGame game;

	private Map<String, Primitive<?>> primitives = new HashMap<String, Primitive<?>>();

	private Map<Mod, Map<String, Base>> bases = new HashMap<Mod, Map<String, Base>>();

	private Map<String, Base> baseNames = new HashMap<String, Base>();

	public MTypeManager(MGame game) {
		this.game = game;
	}

	@Override
	public Matcher getMatcher(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type<?> getType(String name) {
		String baseName = basePattern.matcher(name).group();
		if (!baseName.isEmpty() && baseName != null && name.matches("[a-z]+")) {
			return baseNames.get(baseName);
		}
		return primitives.get(name);
	}

	@Override
	public void registerPrimitive(Primitive<?> primitive) {
		primitives.put(primitive.getName(), primitive);
	}

	@Override
	public void registerBase(Base base) {
		Map<String, Base> map = getBaseMap(base.getMod());
		Base exists = map.get(base.getName());
		if (exists != null) {
			game.getLogger().log(
					Level.WARNING,
					"Base '" + exists.getName()
							+ "' already exists! Be careful!");
		}
		map.put(base.getName(), base);

		// Now the name
		baseNames.put(base.getMod().getName() + ":" + base.getName(), base);
	}

	/**
	 * Gets the map of bases of the given mod.
	 * 
	 * @param mod
	 * @return
	 */
	private Map<String, Base> getBaseMap(Mod mod) {
		Map<String, Base> map = bases.get(mod);
		if (map == null) {
			map = new HashMap<String, Base>();
			bases.put(mod, map);
		}
		return map;
	}

	@Override
	public Base getBase(String name) {
		return baseNames.get(name);
	}
}
