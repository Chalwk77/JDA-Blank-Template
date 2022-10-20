package com.chalwk.Utilities;

import com.chalwk.Interfaces.EmbedInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class GettersAndSetters implements EmbedInterface {

    static JSONObject embed;

    public GettersAndSetters(Object o) {
        embed = (JSONObject) setEmbedTable(o);
    }

    @Override
    public Object setEmbedTable(Object embed) {
        return embed;
    }

    @Override
    public String getTitle() {
        return embed.has("title") ? embed.getString("title") : null;
    }

    @Override
    public String getDescription() {
        return embed.has("description") ? embed.getString("description") : null;
    }

    @Override
    public String getColor() {
        return embed.has("color") ? embed.getString("color") : null;
    }

    @Override
    public String getFooter() {
        return embed.has("footer") ? embed.getJSONObject("footer").getString("text") : null;
    }

    @Override
    public String getImage() {
        return embed.has("image") ? embed.getJSONObject("image").getString("url") : null;
    }

    @Override
    public JSONArray getFields() {
        return embed.has("fields") ? embed.getJSONArray("fields") : null;
    }
}
