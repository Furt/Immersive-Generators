package me.furt.immersivegenerators;

import blusunrize.immersiveengineering.api.MultiblockHandler;
import me.furt.immersivegenerators.blocks.multiblocks.MultiblockCoalGenerator;
import me.furt.immersivegenerators.init.ModItems;
import me.furt.immersivegenerators.proxy.IProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPS)
public class ImmersiveGenerators {
	
	@Instance(Reference.MODID)
	public static ImmersiveGenerators instance;

	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MultiblockHandler.registerMultiblock(MultiblockCoalGenerator.instance);
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent event) {
		
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		
	}
	
	public static CreativeTabs creativeTab = new CreativeTabs(Reference.MODID) {
		@Override
		public Item getTabIconItem() {
			return null;
		}

		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.COAL, 1);
		}
	};

}
