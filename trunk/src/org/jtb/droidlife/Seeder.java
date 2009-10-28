package org.jtb.droidlife;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;

public abstract class Seeder implements Comparable<Seeder> {
	protected final Random RANDOM = new Random(System.currentTimeMillis());
	
	protected String name;
	protected SeedSource seedSource;
	
	public Seeder(SeedSource seedSource, String name) {
		this.seedSource = seedSource;
		this.name = name;
	}
	
	public SeedSource getSeedSource() {
		return seedSource;
	}
	
	public abstract void seed(World world);
	
	public SeederDialog.Builder getSeederDialogBuilder(Context context, GameView gameView) {
		return null;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
		
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Seeder other = (Seeder) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		
		String n1 = name.toLowerCase();
		String n2 = other.name.toLowerCase();
		
		if (!n1.equals(n2))
			return false;
		
		return true;
	}

	public int compareTo(Seeder other) {
		String n1 = name.toLowerCase();
		String n2 = other.name.toLowerCase();

		return n1.compareTo(n2);
	}
	
}
