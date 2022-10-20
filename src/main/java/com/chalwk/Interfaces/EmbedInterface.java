package com.chalwk.Interfaces;

import org.json.JSONArray;

public interface EmbedInterface {

    Object setEmbedTable(Object embed);

    String getTitle();

    String getDescription();

    String getColor();

    String getFooter();

    String getImage();

    JSONArray getFields();
}