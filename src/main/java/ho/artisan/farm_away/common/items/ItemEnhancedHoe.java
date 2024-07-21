package ho.artisan.farm_away.common.items;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class ItemEnhancedHoe extends HoeItem {
    public ItemEnhancedHoe() {
        super(Tiers.NETHERITE, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(Tiers.NETHERITE, -4.0F, 0.0F)));
    }
}
