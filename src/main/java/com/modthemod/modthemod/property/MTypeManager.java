package com.modthemod.modthemod.property;

import com.modthemod.api.base.Base;
import com.modthemod.api.mod.Mod;
import com.modthemod.api.property.Matcher;
import com.modthemod.api.property.Primitive;
import com.modthemod.api.property.Type;
import com.modthemod.api.property.TypeManager;
import com.modthemod.modthemod.MGame;

public class MTypeManager implements TypeManager {
	private final MGame game;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerPrimitive(Primitive<?> primitive) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerBase(Base base, Mod mod) {
		// TODO Auto-generated method stub

	}

}
