package ca.zandercraft.doorknockerforge;

import ca.zandercraft.doorknockerforge.interfaces.ICooldown;
import net.minecraft.nbt.FloatNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class CooldownStorage implements Capability.IStorage<ICooldown> {
    @Override
    public INBT writeNBT(Capability<ICooldown> capability, ICooldown instance, Direction side)
    {
        return FloatNBT.valueOf(instance.getCooldown());
    }

    @Override
    public void readNBT(Capability<ICooldown> capability, ICooldown instance, Direction side, INBT nbt)
    {
        if (nbt instanceof FloatNBT) {
            instance.set(((FloatNBT) nbt).getFloat());
        }
    }
}
