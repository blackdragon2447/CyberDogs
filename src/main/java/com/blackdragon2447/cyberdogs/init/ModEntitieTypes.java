package com.blackdragon2447.cyberdogs.init;

import com.blackdragon2447.cyberdogs.Main;
import com.blackdragon2447.cyberdogs.entities.CyberDog;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntitieTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			Main.MOD_ID);

	public static final RegistryObject<EntityType<CyberDog>> CYBERDOG = ENTITY_TYPES.register("cyberdog",
			() -> EntityType.Builder.<CyberDog>create(CyberDog::new, EntityClassification.CREATURE).size(0.7f, 0.9f)
					.build(new ResourceLocation(Main.MOD_ID, "cyberdog").toString()));
}
