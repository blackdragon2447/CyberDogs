package com.blackdragon2447.cyberdogs;

import com.blackdragon2447.cyberdogs.client.render.CyberDogRender;
import com.blackdragon2447.cyberdogs.init.ModEntitieTypes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("cyberdogs")
public class Main{
    
    public static final String MOD_ID = "cyberdogs";

	public Main() {
        
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        
		ModEntitieTypes.ENTITY_TYPES.register(modEventBus);

        
        MinecraftForge.EVENT_BUS.register(this);
      
    }

    private void setup(final FMLCommonSetupEvent event)
    {
       
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        
    	RenderingRegistry.registerEntityRenderingHandler(ModEntitieTypes.CYBERDOG.get(), CyberDogRender::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        
       
    }

    private void processIMC(final InterModProcessEvent event)
    {
       
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    }
}
