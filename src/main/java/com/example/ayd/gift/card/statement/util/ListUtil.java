package com.example.ayd.gift.card.statement.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    /**
     * 将list切分
     * @param list
     * @param subListLength 子集合长度
     * @return
     * @param <T>
     */
    public static <T> List<List<T>> groupList(List<T> list, int subListLength) {
        List<List<T>> listGroup = new ArrayList<List<T>>();
        int listSize = list.size();
        int toIndex = subListLength;
        for (int i = 0; i < list.size(); i += toIndex) {
            if (i + toIndex > listSize) {
                toIndex = listSize - i;
            }
            List<T> newList = list.subList(i, i + toIndex);
            listGroup.add(newList);
        }
        return listGroup;
    }
}
