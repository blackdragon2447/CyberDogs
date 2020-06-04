package com.blackdragon2447.cyberdogs.client.render;

import com.blackdragon2447.cyberdogs.Main;
import com.blackdragon2447.cyberdogs.client.model.CyberDogModel;
import com.blackdragon2447.cyberdogs.entities.CyberDog;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CyberDogRender extends MobRenderer<CyberDog, CyberDogModel<CyberDog>>{
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/cyberdog.png");
	
	public CyberDogRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CyberDogModel<CyberDog>(), 0.5f);
		
		
	}
	
	@Override
	public ResourceLocation getEntityTexture(CyberDog entity) {
		return TEXTURE;
	}

}
