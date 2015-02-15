package org.tea.heart

/**
 * Created by dshybeka on 15.02.2015.
 */
enum LinkedTagsEnum {

    FOUND(name: "знойдзен", linkedName: "шукаю"),
    LOST(name: "шукаю", linkedName: "знойдзен")

    String name
    String linkedName

    public static LinkedTagsEnum findByName(String name) {

        LinkedTagsEnum.values().find{
            it.name == name
        }
    }
}