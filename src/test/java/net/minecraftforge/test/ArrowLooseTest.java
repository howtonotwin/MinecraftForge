package net.minecraftforge.test;

import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ArrowLooseTest.MOD_ID, name = "ArrowLooseEvent Test", version = "1.0.0", acceptableRemoteVersions = "*")
@EventBusSubscriber
public class ArrowLooseTest
{
    public static final String MOD_ID = "arrow_loose_event_test";
    public static final boolean ENABLED = false;

    @SubscribeEvent
    public static void onArrowLoose(ArrowLooseEvent ale)
    {
        if (ENABLED && Math.abs(ale.getPower()) >= .1 && ale.getBow().getItemDamage() > 350)
        {
            ale.setPower(-ale.getPower());
            if (ale.getResult() == Result.DEFAULT)
                ale.setResult(Result.ALLOW);
        }
    }
}
