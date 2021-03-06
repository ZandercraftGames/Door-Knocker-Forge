package ca.zandercraft.doorknockerforge;

import ca.zandercraft.doorknockerforge.interfaces.ICooldown;

// Implementation of Cooldown
public class Cooldown implements ICooldown {
    private float cooldown = 10;

    public void reset()
    {
        this.cooldown = 10;
    }

    public void set(float ticks)
    {
        this.cooldown = ticks;
    }

    public float getCooldown()
    {
        return this.cooldown;
    }
}
