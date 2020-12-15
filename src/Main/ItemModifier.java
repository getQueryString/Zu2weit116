// From another source

package Main;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemModifier {
    static ItemStack item;

    static ItemMeta itemmeta;

    public ItemModifier(ItemStack item) {
        ItemModifier.item = item;
        itemmeta = item.getItemMeta();
    }

    public Builder modify() {
        return new Builder();
    }

    public static final class Builder {
        public Builder HideFlags(ItemFlag itemflag) {
            ItemModifier.itemmeta.addItemFlags(new ItemFlag[]{itemflag});
            return this;
        }

        public Builder HideFlagExcept(ItemFlag itemflag) {
            HideFlags();
            return this;
        }

        public Builder HideFlags() {
            ItemModifier.itemmeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_DESTROYS});
            return this;
        }

        public ItemStack build() {
            ItemModifier.item.setItemMeta(ItemModifier.itemmeta);
            return ItemModifier.item;
        }
    }
}