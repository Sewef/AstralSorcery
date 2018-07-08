/*******************************************************************************
 * HellFirePvP / Astral Sorcery 2018
 *
 * All rights reserved.
 * The source code is available on github: https://github.com/HellFirePvP/AstralSorcery
 * For further details, see the License file there.
 ******************************************************************************/

package hellfirepvp.astralsorcery.common.constellation.perk.attribute.type;

import hellfirepvp.astralsorcery.common.constellation.perk.attribute.PerkAttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;

import java.util.UUID;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: AttributeTypeAttackDamage
 * Created by HellFirePvP
 * Date: 08.07.2018 / 15:31
 */
public class AttributeTypeAttackDamage extends PerkAttributeType {

    private static final UUID ATTACK_DAMAGE_BOOST_ADD_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010FF91A0");
    private static final UUID ATTACK_DAMAGE_BOOST_ADD_MULTIPLY_ID = UUID.fromString("020E0DFB-87AE-4653-95D6-831010FF91A1");
    private static final UUID ATTACK_DAMAGE_BOOST_STACK_MULTIPLY_ID = UUID.fromString("020E0DFB-87AE-4653-9F56-831010FF91A2");

    public AttributeTypeAttackDamage() {
        super(AttributeTypeRegistry.ATTR_TYPE_DAMAGE);
    }

    @Override
    public void onModeApply(EntityPlayer player, PerkAttributeModifier.Mode mode, Side side) {
        super.onModeApply(player, mode, side);

        IAttributeInstance attr = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE);
        switch (mode) {
            case ADDITION:
                attr.applyModifier(new DynamicPlayerAttributeModifier(ATTACK_DAMAGE_BOOST_ADD_ID, "Perk AttackDamage Add", getTypeString(), mode, player, side));
                break;
            case ADDED_MULTIPLY:
                attr.applyModifier(new DynamicPlayerAttributeModifier(ATTACK_DAMAGE_BOOST_ADD_MULTIPLY_ID, "Perk AttackDamage Multiply Add", getTypeString(), mode, player, side));
                break;
            case STACKING_MULTIPLY:
                attr.applyModifier(new DynamicPlayerAttributeModifier(ATTACK_DAMAGE_BOOST_STACK_MULTIPLY_ID, "Perk AttackDamage Stack Add", getTypeString(), mode, player, side));
                break;
        }
    }

    @Override
    public void onModeRemove(EntityPlayer player, PerkAttributeModifier.Mode mode, Side side) {
        super.onModeRemove(player, mode, side);

        IAttributeInstance attr = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.ATTACK_DAMAGE);
        switch (mode) {
            case ADDITION:
                attr.removeModifier(ATTACK_DAMAGE_BOOST_ADD_ID);
                break;
            case ADDED_MULTIPLY:
                attr.removeModifier(ATTACK_DAMAGE_BOOST_ADD_MULTIPLY_ID);
                break;
            case STACKING_MULTIPLY:
                attr.removeModifier(ATTACK_DAMAGE_BOOST_STACK_MULTIPLY_ID);
                break;
        }
    }

}
