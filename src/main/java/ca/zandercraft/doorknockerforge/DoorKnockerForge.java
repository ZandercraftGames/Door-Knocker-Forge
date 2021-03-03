package ca.zandercraft.doorknockerforge;

import net.minecraft.block.*;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("doorknockerforge")
public class DoorKnockerForge {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public DoorKnockerForge() {
        // Register the setup method for mod-loading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // Pre-init code for mod setup.
        LOGGER.info("Loading Door Knocker (Forge)...");
    }

    // Register sounds.
    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        // Register sound for knocking on doors.
        event.getRegistry().registerAll(new SoundEvent(KnockSounds.DOOR_KNOCK), KnockSounds.DOOR_KNOCK_EVENT);
        // Register sound for knocking on trapdoors.
        event.getRegistry().registerAll(new SoundEvent(KnockSounds.TRAPDOOR_KNOCK), KnockSounds.TRAPDOOR_KNOCK_EVENT);
    }

    @SubscribeEvent
    // TODO: Add a cooldown so that the sound does not fire too often.
    public void onPlayerInteract(final PlayerInteractEvent.LeftClickBlock event){
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        BlockState block = event.getWorld().getBlockState(pos);

        if (block.getBlock() instanceof DoorBlock) {
            world.playSound(null, pos, KnockSounds.DOOR_KNOCK_EVENT, SoundCategory.PLAYERS, 1f, 1f);
        }
        if (block.getBlock() instanceof TrapDoorBlock) {
            world.playSound(null, pos, KnockSounds.TRAPDOOR_KNOCK_EVENT, SoundCategory.PLAYERS, 1f, 1f);
        }
    }
}
