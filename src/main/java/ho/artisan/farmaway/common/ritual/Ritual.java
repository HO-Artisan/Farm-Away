package ho.artisan.farmaway.common.ritual;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import ho.artisan.farmaway.common.data.FARegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Optional;

public record Ritual(Holder<Block> centre, Holder<Block> centreOut, List<Holder<Block>> ritualBase, Holder<Block> baseOut) {
	public Ritual(Block centre, Block centreOut, List<Block> base, Block baseOut) {
		this(Holder.direct(centre), Holder.direct(centreOut), base.stream().map(Holder::direct).toList(), Holder.direct(baseOut));
	}

	public static final Codec<Ritual> CODEC = RecordCodecBuilder.create(instance -> instance.group(
		BuiltInRegistries.BLOCK.holderByNameCodec().fieldOf("centre").forGetter(Ritual::centre),
		BuiltInRegistries.BLOCK.holderByNameCodec().fieldOf("centre_out").forGetter(Ritual::centreOut),
		BuiltInRegistries.BLOCK.holderByNameCodec().listOf().fieldOf("ritual_base").forGetter(Ritual::ritualBase),
		BuiltInRegistries.BLOCK.holderByNameCodec().fieldOf("base_out").forGetter(Ritual::baseOut)
	).apply(instance, Ritual::new));

	public static Optional<Ritual> of(RegistryAccess access, ResourceKey<Ritual> key) {
		Registry<Ritual> registry = access.registryOrThrow(FARegistries.RITUAL);
		var holder = registry.getHolder(key);
		return holder.map(Holder::value);
	}
}
