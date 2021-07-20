package com.kotakotik.createautomated.register;

import com.kotakotik.createautomated.CreateAutomated;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModPackets {
	public static final ResourceLocation CHANNEL_NAME = new ResourceLocation(CreateAutomated.MODID, "network");
	public static final String NETWORK_VERSION = (new ResourceLocation(CreateAutomated.MODID, "1")).toString();
	public static SimpleChannel channel;

	protected static int packets = 0;

	public static void registerPackets() {
		channel = NetworkRegistry.ChannelBuilder.named(CHANNEL_NAME)
				.serverAcceptedVersions(NETWORK_VERSION::equals)
				.clientAcceptedVersions(NETWORK_VERSION::equals)
				.networkProtocolVersion(() -> NETWORK_VERSION)
				.simpleChannel();
	}

	public static void sendToNear(World world, BlockPos pos, int range, Object message) {
		channel.send(PacketDistributor.NEAR
				.with(PacketDistributor.TargetPoint.p(pos.getX(), pos.getY(), pos.getZ(), range, world.dimension())), message);
	}
}
