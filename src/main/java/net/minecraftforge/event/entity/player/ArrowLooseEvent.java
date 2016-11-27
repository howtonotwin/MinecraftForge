/*
 * Minecraft Forge
 * Copyright (c) 2016.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.event.entity.player;

import javax.annotation.Nonnull;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event.HasResult;

/**
 * Fired whenever a player stops using a bow.
 * <p>
 * This event has a {@link HasResult result}. If {@code DEFAULT}, the arrow will only be fired if the {@link #getPower power} is over the threshold of {@code .1}. If {@code DENY},
 * the arrow will not fire, and if {@code ALLOW}, it always will.
 * <p>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
@HasResult
public class ArrowLooseEvent extends PlayerEvent
{
    private final ItemStack bow;
    private ItemStack ammo;
    private final World world;
    private float power;

    public ArrowLooseEvent(@Nonnull ItemStack bow, @Nonnull ItemStack ammo, World world, EntityPlayer player, float power)
    {
        super(player);
        this.bow = bow;
        this.world = world;
        this.ammo = ammo;
        this.power = power;
    }

    @Nonnull
    public ItemStack getBow()
    {
        return bow;
    }

    /**
     * Gets the ammo to be shot. If this stack is invalid, and the player is in creative mode, or the bow has Infinity on it, then it will default to the vanilla arrow.
     * 
     * @return The arrow to use
     */
    @Nonnull
    public ItemStack getAmmo()
    {
        return ammo;
    }

    public void setAmmo(ItemStack ammo)
    {
        this.ammo = ammo;
    }

    public World getWorld()
    {
        return world;
    }

    /**
     * Gets the power of the arrow, which is calculated from the charge of the bow.
     * <p>
     * If the power is less than {@code .1} and the result of this event is {@code DEFAULT}, the arrow will not fire. If the result is {@code ALLOW}, it will always fire.
     * 
     * @return The power with which the arrow will be fired
     */
    public float getPower()
    {
        return power;
    }

    public void setPower(float power)
    {
        this.power = power;
    }
}
