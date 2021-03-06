package ca.zandercraft.doorknockerforge.interfaces;

// Cooldown Interface. Adds cooldown capability.
public interface ICooldown {
        public void set(float ticks);
        public void reset();

        public float getCooldown();
}
