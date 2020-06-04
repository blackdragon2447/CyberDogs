package com.blackdragon2447.cyberdogs.util;

import com.blackdragon2447.cyberdogs.Main;
import com.blackdragon2447.cyberdogs.client.render.CyberDogRender;
import com.blackdragon2447.cyberdogs.init.ModEntitieTypes;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(ModEntitieTypes.CYBERDOG.get(), CyberDogRender::new);
	}

}
