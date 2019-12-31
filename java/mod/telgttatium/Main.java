package mod.telgttatium;
import mod.telgttatium.proxy.IProxy;
import mod.telgttatium.utils.Utils;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Main.MODID, name = Main.NAME, version = Main.VERSION, acceptedMinecraftVersions =Main.MC_VERSION)
public class Main {
	public static final String MODID = "tel";
	public static final String NAME = "Telgttatium";
	public static final String VERSION = "0.4.1";
	public static final String MC_VERSION = "[1.12.2]";

	public static final Logger LOGGER = LogManager.getLogger(Main.MODID);

	public static final String CLIENT = "mod.telgttatium.proxy.ClientProxy";
	public static final String SERVER = "mod.telgttatium.proxy.ServerProxy";
	@SidedProxy(clientSide = Main.CLIENT, serverSide = Main.SERVER)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Utils.Generate(Main.MODID);
        proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		LOGGER.info(Main.NAME + " steps into the ring!");

		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
	}
}
