package com.lulan.shincolle.utility;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;

import java.util.ArrayList;
import java.util.List;

public class NBTHelper {

    public NBTHelper() {
    }

    public static void saveIntListToNBT(CompoundTag save, String tagName, List<Integer> ilist) {
        if (save != null) {
            if (ilist != null && ilist.size() > 0) {
                int[] intary = CalcHelper.intListToArray(ilist);
                save.putIntArray(tagName, intary);
            } else {
                save.putIntArray(tagName, new int[]{});
            }
        } else {
            LogHelper.debug("DEBUG: NBT helper: save nbt fail: tag is null ");
        }
    }

    // load string tag, return array list
    public static ArrayList<String> loadStringTagArrayList(CompoundTag nbt, String tagName) {
        ListTag nameTags = nbt.getList(tagName, Tag.TAG_STRING);
        ArrayList<String> nameList = new ArrayList<>();

        for (int i = 0; i < nameTags.size(); ++i) {
            String str = nameTags.getString(i);

            if (str.length() > 0) {
                nameList.add(str);
            }
        }

        return nameList;
    }

    // save string tag array list
    public static CompoundTag saveStringTagArrayList(CompoundTag nbt, String tagName, ArrayList<String> strs) {
        if (strs != null) {
            ListTag tagList = new ListTag();

            for (String name : strs) {
                if (name == null || name.length() <= 0)
                    name = " "; // empty string not allowed!
                tagList.add(StringTag.valueOf(name));
            }

            nbt.put(tagName, tagList);
        }

        return nbt;
    }

}
